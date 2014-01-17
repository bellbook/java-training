package ch17.ex17_03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

    final ReferenceQueue<Object> queue;
    final Map<Reference<?>, Resource> refs;
    final Thread reaper;
    boolean shutdown = false;

    public ResourceManager() {
        queue = new ReferenceQueue<Object>();
        refs = new HashMap<Reference<?>, Resource>();
        reaper = new ReaperThread();
        reaper.start();

        // リソースの初期化
    }

    public synchronized void shutdown() {
        if (!shutdown) {
            shutdown = true;
            reaper.interrupt();
        }
    }

    public synchronized Resource getResource(Object key) {
        if (shutdown)
            throw new IllegalStateException();

        Resource res = new ResourceImpl(key);
        // key が Phantom 参照になったときに参照 queue に追加される
        Reference<?> ref = new PhantomReference<Object>(key, queue);
        refs.put(ref, res);
        return res;
    }

    class ReaperThread extends Thread {
        public void run() {
            while (true) {
                try {
                    // 参照 queue から Phantom 参照を取り除いて返す
                    // Phantom 参照が queue に入るまで待つ
                    Reference<?> ref = queue.remove();
                    Resource res = null;
                    synchronized (ResourceManager.this) {
                        res = refs.get(ref);
                        refs.remove(ref);
                    }
                    res.release();
                    ref.clear();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private static class ResourceImpl implements Resource {
        WeakReference<Object> key;
        boolean needsRelease = false;

        ResourceImpl(Object key) {
            this.key = new WeakReference<Object>(key);

            // 外部リソースの設定

            needsRelease = true;
        }

        public void use(Object key, Object... args) {
            if (key != this.key.get())
                throw new IllegalArgumentException("worng key");

            // リソースの使用
        }

        public synchronized void release() {
            if (needsRelease) {
                needsRelease = false;

                // リソースの解放
            }
        }
    }

}
