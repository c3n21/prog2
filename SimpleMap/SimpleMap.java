import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/**
 * <pre>
 * [OVERVIEW]
 *      Classe che rappresenta una mappa che ha come chiave una stringa, 
 *      e valore un intero.
 *
 *      Le operazioni disponibili saranno:
 *      {@link put}
 *      {@link remove}
 *      {@link get}
 * </pre>
 * */

public class SimpleMap {

    /**
     * [FIELDS]
     * */

    private final List<Entry> entries;

    /**
     * <pre>
     * [AF]
     *      AF(keys, values) = values[key] dove "key" appartiene all'insieme delle stringhe chiavi keys {x1 ... xn} con xi non ridondante
     *          e "values" una lista di interi associati alla chiave key (due chiavi diverse possono avere lo stesso value)
     *
     * [RI]
     *      keys.size == values.size
     *      keys != null
     *      values != null
     *      keys non deve contenere chiavi uguali
     *                         
     * [AI]
     *      per qualsiasi elemento in keys, non ci devono essere duplicati
     * </pre>
     * */


    /**
     * <pre>
     * [CONSTRUCTOR]
     * </pre>
     * */

    /**
     * <pre>
     * [RI PRESERVATION]
     *      keys e values vengono istanziati, quindi hanno la stessa dimensione che e' 0
     *
     * [OP CORRECTNESS]
     *      AF(keys, values) = keys = {}
     *                       = values = {}
     *
     * [AI PRESERVATION]
     *      keys.size   >= 0
     *      values.size >= 0
     *      keys.size   == values.size
     * </pre>
     * */
    public SimpleMap () {
        entries = new ArrayList<>();

        assert repOk();
    }

    /**
     * [METHODS]
     * */

    /**
     * <pre>
     * [RI PRESERVATION]
     *      {@code viene aggiunto <==> key non appartiene a keys}
     *      {@code key viene aggiunto => value viene aggiunto, quindi} 
     *      {@code values.size() == keys.size()}
     *
     * [OP CORRECTNESS]
     *      AF(keys, values) = values[key] con {@code key} appartenente a {@code keys}
     *                         con {@code keys.size == values.size}
     *                         {@code keys.add(key) => values.add(value)}
     *      {@code key esiste in keys => values[keys[key]] = value}
     *      {@code key non esiste in keys => keys.add(key) && values.add(values) }
     *      {@code => keys.size == values.size}
     *
     * [AI PRESERVATION]
     *      keys.size   {@code >= 0}
     *      values.size {@code >= 0}
     *      keys.size   == values.size
     *
     * [MODIFIES]
     *      {@code Map.keys}
     *      {@code Map.values}
     *
     * [EFFECTS]
     *      {@code Inserisce value nella map}
     *      {@code se key e' gia' presente, il value corrispondente viene rimpiazzato}
     *
     * @param key
     *
     * @param value
     *
     * </pre>
     * */
    public void put (String key, int value) {
        entries.stream().filter(entry -> entry.key.equals(key)) //not found
            .findFirst().ifPresentOrElse(entry -> entry.value = value,
                    () -> entries.add(new Entry(key, value)));

        assert repOk();
    }

    /**
     * <pre>
     * [RI PRESERVATION]
     *      {@code viene aggiunto <==> key non appartiene a keys}
     *      {@code key viene aggiunto => value viene aggiunto, quindi}
     *      {@code values.size() == keys.size()}
     *
     * [OP CORRECTNESS]
     *      AF(keys, values) = values[key] con key appartenente a {@code keys}
     *                         con {@code keys.size == values.size}
     *                         {@code keys.add(key) => values.add(value)}
     *
     * [AI PRESERVATION]
     *      keys.size   {@code >= 0}
     *      values.size {@code >= 0}
     *      keys.size   == values.size
     *
     * [MODIFIES]
     *      {@code Map.keys}
     *      {@code Map.values}
     *
     * [EFFECTS]
     *      {@code rimuove value associato alla chiave key se quest'ultima e' presente}
     *
     * </pre>
     **/
    public void remove (String key) {
        entries.removeIf(entry -> entry.key.equals(key));
        assert repOk();
    }

    /**
     * <pre>
     * [EFFECTS]
     *      {@code restituisce il valore associato alla chiave key}
     *
     * @throws NoSuchElementException se la chiave non e' presente
     *
     * </pre>
     **/
    public int get (String key) {
        return entries.stream().filter(entry -> entry.key.equals(key))
            .findFirst().get().value;
    }

    public int size () {
        return entries.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SimpleMap: [");

        entries.forEach(entry -> {
            stringBuilder.append(entry + ", ");
        });

        stringBuilder.append("]");

        return stringBuilder.toString().replace(", ]", "]");
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof SimpleMap)) {
            return false;
        }

        SimpleMap sm = (SimpleMap) obj;

        return entries.equals(sm.entries);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private boolean repOk () {

        return entries == null || 
            entries.parallelStream().filter(entry -> Collections.frequency(entries, entry) > 1).count() > 1;
    }

    private class Entry {
        private final String key;
        private int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }

            Entry entry = (Entry) obj;

            return entry.key.equals(key) && entry.value == value;
        }

        @Override
        public String toString() {
            return String.format("'%s': %d", key, value);
        } 
    }
}
