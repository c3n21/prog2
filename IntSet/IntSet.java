/**
 * [OVERVIEW]
 *      classe che rappresenta gli insiemi di interi matematici.
 *      Una volta istanziato un {@code IntSet} e' possibile manipolarlo
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class IntSet {

    /**
     * [FIELDS]
     * */

    /**
     * struttura dati per contenere gli elementi
     * */
    private List<Integer> elements;

    /**
     * [CONSTRUCTOR]
     * */

    /**
     * [ABS FUN]
     *      AF(elements) = {elements.get(0), ... elements.get(els.size-1)}
     *
     * [REP INV]
     *      elements != null
     *      elements deve contenere interi
     *      elements non deve contenere numeri uguali fra loro
     *
     * [ABS INV]
     *      per qualsiasi elemento contenuto in elements, non vi deve essere un suo duplicato al suo interno
     *
     *******************************************************************
     *
     * [OP CORRECTNESS]
     *     AF(elements) = {}
     *
     * [PRESERVAZIONE RI]
     *     elements = {}
     *
     * [PRESERVAZIONE AI]
     *      l'insieme e' vuoto quindi non ci sono duplicati
     *
     */
    public IntSet() {
        this.elements = new ArrayList<>();
    }

    /**
     * [METHODS]
     * */

    /**
     * [EFFECTS] 
     *      ritorna un numero arbitrario contenuto nell'insieme
     *
     * [OP CORRECTNESS]
     *      se size <= 0 non viene estratto nessun numero
     *      altrimenti il numero che viene estratto (casuale) e' in modulo con size, quindi puo' essere solo un numero da 
     *      0 a size()-1
     *
     * @return {@code int} from the set
     *
     * @throws EmptyException se non ci sono elementi da estrarre
     */
    public int choose() {
        if (this.elements.size() <= 0) {
            throw new EmptyException("[IntSet::choose] IntSet is empty!");
        }

        return elements.get((int) Math.random() % this.elements.size());
    }

    /**
     * [EFFECTS] ritorna true se @param x e' contenuto nell'insieme
     * 
     * @param x {@code int} da ricercare all'interno dell'insieme
     *
     * @return true se e' contenuto nell'insieme false altrimenti
     *
     * [OP CORRECTNESS]
     *     restituisce true se x e' contenuto nella lista
     *     altrimenti false
     *
     */
    public boolean contains(int x) {
        return this.elements.contains(x);
    }

    /**
     * [EFFECTS] 
     *      inserisce un elemento nell'insieme se non vi e' gia' contenuto
     *
     * @param x {@code int} da inserire all'interno dell'insieme
     *
     * [PRESERVAZIONE RI]
     *     se x non e' contenuto in elements, allora aggiunge x ad elements
     *     elements.size() > 0
     *
     * [OP CORRECTNESS]
     *     assumo AF(elements) = {x0 ... xn} vero
     *     se x non e' contenuto in elements, allora aggiunge x ad elements
     *
     * [PRESERVAZIONE AI]
     *     se x non e' contenuto in elements, allora aggiunge x ad elements
     *
     */
    public void insert(int x) {
        if (!this.elements.contains(x)) {
            this.elements.add(x);
        }
    }

    /** 
     * [EFFECTS] 
     *      restituisce la dimensione dell'insieme
     *
     * [OP CORRECTNESS]
     *      assumo AF(elements) = {x1, ... xn | x_i != x_j && i != j} vero
     *      restituisco la dimensione di elements
     *
     * @return {@code int} dimensione insieme
     */
    public int size() {
        return this.elements.size();
    }

    @Override
    public String toString() {

        return "IntSet: " + elements.toString().replace('[', '{').replace(']', '}');
    }

    /**
     * [OP CORRECTNESS]
     *      se il riferimento di obj e' this allora true
     *      se obj non e' un'istanza di IntSet allora e' false
     *      se la loro dimensione e' diversa allora e' false
     *      verifico che ogni elemento di this.elements sia contenuto in obj
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof IntSet)) {
            return false;
        }

        IntSet other = (IntSet) obj;

        if (other.size() != size()) {
            return false;
        }
        
        for (Integer i : elements) {
            if (!other.contains(i)) {
                return false;
            }
        }

        return true;
    }
}
