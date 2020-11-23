import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <pre>
 * [OVERVIEW]
 *      Classe che rappresenta una mappa che ha come chiave una stringa, 
 *      e valore un intero.
 *      È un oggetto mutabile.
 *      Esempio di SimpleMap: {"key1": value1, "key2": value2 ... "keyn": valuen} dove keyi sono chiavi uniche, quindi k_i != k_j per i != j
 *
 *      Le operazioni disponibili saranno:
 *      {@link put}
 *      {@link remove}
 *      {@link get}
 * </pre>
 * */

public class SimpleMap {


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

        @Override
        public int hashCode() {
            int result = Integer.hashCode(value);
            result = (31 * result) + key.hashCode();
            return result;
        }
    }
    /**
     * [FIELDS]
     * */

    private final List<Entry> entries;

    /**
     * <pre>
     * [AF]
     *      AF(entries) = { entry1, entry2 ... entryn } "entry" e una coppia "key":value, con entry.key_i != entry.key_j e i != j
     *
     * [RI]
     *      entries != null
     *      entries.size >= 0
     *      entry.key_i != entry.key_j e i != j
     *                         
     * [AI]
     *      per qualsiasi elemento entry, non ci devono essere altre entry con la stessa chiave
     *      ad ogni chiave corrisponde un solo elemento
     *      numero di associazioni k -> v in ciascuna SimpleMap e >= 0
     * </pre>
     * */


    /**
     * <pre>
     * [CONSTRUCTOR]
     * </pre>
     * */

    /**
     * <pre>
     * [EFFECTS]
     *      crea una mappa vuota
     *
     * [RI PRESERVATION]
     *      entries viene inizializzato, perciò non e null         
     *      entries non contiene alcun valore
     *      entries == 0
     *
     * [OP CORRECTNESS]
     *      AF(entries) = {}
     *
     * [AI PRESERVATION]
     *      this e vuoto => entries.size() == 0
     *
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
     * [MODIFIES]
     *      {@code Map.keys}
     *      {@code Map.values}
     *
     * [EFFECTS]
     *      {@code aggiunge k -> v in entries}
     *      {@code se key e' gia' presente, il value corrispondente viene rimpiazzato}
     *
     * [OP CORRECTNESS]
     *      Assumo AF(entries) = { entry1, entry2 ... entryn} valido
     *      AF(keys, values) = values[key] con {@code key} appartenente a {@code keys}
     *                         con {@code keys.size == values.size}
     *                         {@code keys.add(key) => values.add(value)}
     *      {@code se key e' una chiave gia' in uso da una entry allora value di quella entry viene sostituito e la dimensione
     *      rimane la stessa,
     *      altrimenti entries.size += 1 => entries.size() > 0}
     *
     * [RI PRESERVATION]
     *      {@code value viene aggiunto <==> key != entry_keyi | i = 0 ... entries.size()-1} 
     *      {@code se key e' gia' la chiave di una entry allora il value di quella entry viene sostituito con il nuovo value, quindi la 
     *      dimensione rimane la stessa, altrimenti aumenta di uno} 
     *
     * [AI PRESERVATION]
     *      {@code se key e' la chiave di una entry allora il value associato viene rimpiazzato dal nuovo value e la dimensione della mappa
     *      non aumenta;
     *      altrimenti aumenta di 1}
     *
     * @param key string that is not null
     *
     * @param value 
     *
     * @throws NullPointerException if key == null
     *
     * </pre>
     * */
    public void put (String key, int value) {
        Objects.requireNonNull(key, "key must not be null");

        entries.stream().filter(entry -> entry.key.equals(key)) //not found
            .findFirst().ifPresentOrElse(entry -> entry.value = value,
                    () -> entries.add(new Entry(key, value)));

        assert repOk();
    }

    /**
     * <pre>
     *
     * [EFFECTS]
     *      {@code rimuove value associato alla chiave key se quest'ultima e' presente}
     *
     * [OP CORRECTNESS]
     *      assumo AF(entries) = {entry1 ... entryn} valido prima delle rimozione
     *      se key e' la chiave di una entry, allora rimuovo la Entry
     *      altrimenti non faccio nulla
     *
     * [RI PRESERVATION]
     *      se key non e' chiave di nessuna entry allora la dimensione rimane invariata.
     *      se invece c'e' allora entries.size() > 0, quindi se viene rimosso entries.size() non puo' essere minore di 0
     *
     * [AI PRESERVATION]
     *      se key non e' presente, la dimensione della mappa non viene modificata
     *      se key e' presente => entries.size() >=1, quindi dopo l'eliminazione entries.size() >= 0
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
     * [OP CORRECTNESS]
     *      se key esiste in entries allora viene restituito il suo value corrispondente
     *
     * @throws NoSuchElementException se la chiave non e' presente
     *
     * </pre>
     **/
    public int get (String key) {
        return entries.stream().filter(entry -> entry.key.equals(key))
            .findFirst().get().value;
    }

    /**
     * <pre>
     * [EFFECTS]
     *      restituisce la dimensione di entries
     *
     * [OP CORRECTNESS]
     *      le associazioni key -> value sono raggruppate in entry, percio' entries.size() restituisce la dimensione corretta della mappa (ovvero quante coppie key -> value ho nella lista)
     *
     * @throws NoSuchElementException se la chiave non e' presente
     *
     * </pre>
     **/
    public int size () {
        return entries.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SimpleMap: {");

        entries.forEach(entry -> {
            stringBuilder.append(entry + ", ");
        });

        stringBuilder.append("}");

        return stringBuilder.toString().replace(", ]", "]");
    }

    /** 
     * [OP CORRECTNESS]
     *      se obj non e' una SimpleMap allora non possono essere uguali
     *      se non hanno la stessa dimensione allora non possono essere uguali
     *      per ogni entry di this verifico che entry.key sia presente in obj con il relativo value
     */

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SimpleMap)) {
            return false;
        }


        SimpleMap sm = (SimpleMap) obj;

        if (size() != sm.size()) { return false; }

        for (Entry entry : entries) {
            if (sm.get(entry.key) != entry.value) { return false; }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * entries.stream().parallel()
            .mapToInt(entry -> entry.hashCode())
            .reduce(0, (sum, hash) -> 31*sum + hash);
    }

    private boolean repOk () {

        return entries != null &&
            entries.parallelStream().filter(entry -> Collections.frequency(entries, entry) > 1).count() > 1;
    }
}
