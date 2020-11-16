import java.util.ArrayList;
import java.util.List;

/**
 * [OVERVIEW]
 *      Classe che rappresenta una mappa che ha come chiave una stringa, 
 *      e valore un intero.
 *
 *      Le operazioni disponibili saranno:
 *      {@link put}
 *      {@link remove}
 *      {@link get}
 *
 * */

public class Map {

    /**
     * [FIELDS]
     * */

    private List <String> keys;
    private List <Integer> values;

    /**
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
     * */


    /**
     * [CONSTRUCTOR]
     * */

    /**
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
     * */
    public Map () {
        keys   = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * [METHODS]
     * */

    public void put (String key, int value) {
    }

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
