package collections.map;

public interface Map<K, V> extends Iterable<Map.Entry<K,V>> {
    /**
     * @return - get the size of the map
     */
    int size();

    /**
     * @return - whether the map is empty or not
     */
    boolean isEmpty();

    /**
     * @param key - the key to lookup
     * @return - whether the map contains the key or not
     */
    boolean containsKey(Object key);

    /**
     * @param key - the key to lookup
     * @return - get the value associated with the key
     */
    V get(Object key);

    /**
     * @param key - the key associated with the value to add
     * @param value - the value to add
     * @return - old value if there is one
     */
    V put(K key, V value);

    /**
     * @param key - the key associated with the value to remove
     * @return - value of the entry removed
     */
    V remove(Object key);

    interface Entry<K, V> {
        /**
         * @return - the key of the entry
         */
        K getKey();

        /**
         * @return - the value of the entry
         */
        V getValue();

        /**
         * @param value - set the value of the entry
         * @return - old value of the entry
         */
        V setValue(V value);
    }
}
