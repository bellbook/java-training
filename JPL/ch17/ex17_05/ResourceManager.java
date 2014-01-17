package ch17.ex17_05;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class ResourceManager {

    final Map<Object, WeakReference<Resource>> resourceMap;
    boolean shutdown = false;

    public ResourceManager() {
        resourceMap = new WeakHashMap<Object, WeakReference<Resource>>();

        // リソースの初期化
    }

    public synchronized void shutdown() {
        if (!shutdown) {
            shutdown = true;

            for (Object key : resourceMap.keySet()) {
                Resource res = resourceMap.get(key).get();
                if (res != null)
                    res.release();
            }

            resourceMap.clear();
        }
    }

    public synchronized Resource getResource(Object key) {
        if (shutdown)
            throw new IllegalStateException();

        Resource res = new ResourceImpl(key);
        resourceMap.put(key, new WeakReference<Resource>(res));
        return res;
    }

    private static class ResourceImpl implements Resource {
        int keyHash;
        boolean needsRelease = false;

        ResourceImpl(Object key) {
            keyHash = System.identityHashCode(key);

            // 外部リソースの設定

            needsRelease = true;
        }

        public void use(Object key, Object... args) {
            if (System.identityHashCode(key) != keyHash)
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
