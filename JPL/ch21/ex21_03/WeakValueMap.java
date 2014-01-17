package ch21.ex21_03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeakValueMap<K, V> implements Map<K, V> {

    private Map<K, V> map = new HashMap<K, V>();

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public boolean containsValue(Object obj) {
        return false;
    }

    @Override
    public V get(Object obj) {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V remove(Object obj) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
    }

    @Override
    public Collection<V> values() {
        return null;
    }

}
