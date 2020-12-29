package collections.map;

import java.util.ArrayList;

/**
 * Overview:
 *
 * A dumb implementation of a Map
 */

import java.util.Iterator;
import java.util.List;

public class DumbMap<K,V> implements Map<K,V>{
    private final List<Map.Entry<K,V>> entries;

    public DumbMap() {
        entries = new ArrayList<>();
    }

    public static class DumbEntry<K,V> implements Map.Entry<K,V> {

        private final K key;
        private V value;

        /**
         * [ABS FUN]
         *      AF(key, value) = (key, value)
         *
         * [REP INV]
         *      key is not null
         */

        DumbEntry(K key) {
            this.key = key;
            this.value = null;
        }

        DumbEntry(K key, V value) {
            this.key   = key;
            this.value = value;
        }

        /**
         * @return key
         *
         */
		@Override
		public K getKey() {
			return key;
		}

        /**
         * @return value
         *
         */
		@Override
		public V getValue() {
			return value;
		}

        /**
         * @return old value
         * and sets the new value
         */
		@Override
		public V setValue(V value) {
            V old      = this.value;
            this.value = value;
			return old;
		}

        @Override
        public int hashCode() {
            int hash = 1;
            hash = 31*hash + key.hashCode();
            hash = 31*hash + value.hashCode();
            return hash;
        }

        @Override
        public String toString() {
            return "" + key + ": " + value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry<?, ?> other = (Map.Entry<?,?>) obj;
                return equals(other);
            }
            return false;
        }

        public boolean equals(Map.Entry<K,V> other) {
            if (this == other) {
                return true;
            }

            return true;
        }
    }

	public Iterator<Map.Entry<K,V>> iterator() {
		return entries.iterator();
	}

    /**
     * @return number of the entries in the map
     */
	@Override
	public int size() {
		return entries.size();
	}

    /**
     * @return true if there are no entries, otherwire false
     *
     * [OP CORRECTNESS]
     *      if size is 0 then the map is empty, otherwise it is not
     */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

    /**
     * @param the key to search for
     * @return true if the key is present, otherwire false
     *
     * [OP CORRECTNESS]
     *      iterates over each entry, and for each one it checks if entry.key is equals to the key param, and after fetching that
     *      element is checks whether it's null or not
     */
	@Override
	public boolean containsKey(Object key) {
		return entries.stream().filter(entry -> entry.getKey().equals(key)).findAny() != null;
	}

    /**
     * @param the key whose associated value is to be returned
     * @return gets the value corresponding to the parameter key
     *
     * [OP CORRECTNESS]
     *      iterates through all the entries, for each it checks if the key matches, after the first match it stores the value
     *      and returns it
     *
     *      if there is no match then null will be returned
     */
	@Override
	public V get(Object key) {
        Map.Entry<K,V> entry = getEntry(key);

		return entry.getValue();
	}

    /**
     * @param key the key to be associated to the value
     * @param value the value to be associated with the key provided
     * @return old value if it was already present, otherwise null
     *
     * [REP PRESERVATION]
     *      if the entry with key already exists it will be retrieved, so no new entry is created
     *      it the entry with key does not exist, it will be created
     *
     *      so there are no multiple entries with the same key
     *
     * [OP CORRECTNESS]
     *      checks if there is an entry that matches the key
     *      matches:
     *          it will retrieve it, and set the value in that entry which returns the old value
     *
     *      no matches:
     *          it will create an entry with the appropriate key with no value, and then set the value with the one provided which
     *          will return null in this case as the entry does not hold any value
     */
	@Override
	public V put(K key, V value) {
        Map.Entry<K,V> entry = getEntry(key);


        if (entry == null) {
            entry = new DumbEntry<>(key);
            entries.add(entry);
        }

		return entry.setValue(value);
	}

    /**
     * @param key - is the key of the entry to be removed
     * @return 
     *
     * [OP CORRECTNESS]
     *      retrieves the object associated with key, if it's not null it will be removed
     *
     * [REP PRESERVATION]
     *      in case there is no such element, the rep doesn't change.
     *      However, if there is such element and it has been removed, the rep will be preserved because you can't have
     *      duplicated elements if you remove one.
     */
	@Override
	public V remove(Object key) {
        Map.Entry<K,V> to_remove = getEntry(key);
        if (to_remove != null) {
            entries.remove(to_remove);
            return to_remove.getValue();
        }

        return null;
	}

    /**
     * @param key - lookup key
     * @return DumbEntry if key is in entries, otherwire null
     *
     * [OP CORRECTNESS]
     *      for each entry checks for key match.
     *      if match:
     *          retrieve that entry
     *      else:
     *          return null
     */
    private Map.Entry<K,V> getEntry(Object key) {
        for (Entry<K,V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 1;

        for (Map.Entry<K,V> entry: entries) {
            hash = 31*hash + entry.hashCode();
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DumbMap: {\n");

        entries.forEach(entry -> stringBuilder.append("\t" + entry + ",\n"));
        stringBuilder.append("\b\b}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DumbMap) {
            Map<?,?> map = (Map<?,?>) obj;
            return equals(map);
        }
        return false;
    }

    public boolean equals(Map<K,V> map) {
        if(map == this) {
            return true;
        }

        if (this.size() != map.size()) {
            return false;
        }

        for (Map.Entry<K,V> entry : map) {
            Map.Entry<K,V> found = getEntry(entry.getKey());

            if (found == null || !found.equals(entry)) {
                return false;
            }
        }

        return true;
    }
}
