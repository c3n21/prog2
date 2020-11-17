import java.util.ArrayList;
import java.util.List;

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

public class Map {

    /**
     * [FIELDS]
     * */

    private List <String> keys;
    private List <Integer> values;

    /**
     * <pre>
     * [AF]
     *      AF(keys, values) = values[key] dove "key" appartiene all'insieme delle stringhe chiavi keys {x1 ... xn} con xi non ridondante
     *          e "values" una lista di interi associati alla chiave key (due chiavi diverse possono avere lo stesso value)
     *
     * [RI]
     *      keys.size === values.size
     *      keys !== null
     *      values !== null
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
     *      keys e values vengono istanziati, quindi hanno la stessa dimensione che è 0
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
    public Map () {
        keys   = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * [METHODS]
     * */

    /**
     * <pre>
     * [RI PRESERVATION]
     *      key viene aggiunto <==> key non appartiene a keys
     *      se key viene aggiunto => value viene aggiunto, quindi 
     *      {@code values.size()} == {@code keys.size()}
     *
     * [OP CORRECTNESS]
     *      AF(keys, values) = values[key] con {@code key} appartenente a {@code keys}
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
     *      {@code Inserisce value nella map}
     *      restituisce true se è stato possibile aggiungerlo
     *      false altrimenti (la chiave e' gia' utilizzata)
     *
     * @param key
     *
     * @param value
     *
     * @throws IllegalArgumentException se @param key {@code e' gia' presente}
     * </pre>
     **/
    public boolean put (String key, int value) {
        if (keys.contains(key)) {
            return false;
        }
        
        keys.add(key);
        values.add(value);

        return true;
    }

    /**
     * <pre>
     * [RI PRESERVATION]
     *      key viene aggiunto <==> key non appartiene a keys
     *      se key viene aggiunto => value viene aggiunto, quindi 
     *      {@code values.size()} == {@code keys.size()}
     *
     * [OP CORRECTNESS]
     *      AF(keys, values) = values[key] con {@code key} appartenente a {@code keys}
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
        
    }

    public int get (String key) {
        return 0;
    }

    @Override
    public String toString() {
        return "Map []";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
