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
     * [ABS FUN]
     *      AF(elements) = insieme [x1, x2 ... xn] senza elementi duplicati
     *
     * [REP INV]
     *      elements non deve contenere numeri uguali fra loro
     */

    /**
     * [CONSTRUCTOR]
     * */
    public IntSet() {
        this.elements = new ArrayList<>();
    }

    /**
     * [METHODS]
     * */

    /**
     * [EFFECTS] ritorna un numero arbitrario contenuto nell'insieme
     *
     * @return {@code int} from the set
     *
     * @throws EmptyException se non ci sono elementi da estrarre
     */
    public int choose() {
        if (this.elements.size() <= 0) {
            throw new EmptyException("[IntSet::choose] IntSet is empty!");
        }

        return elements.get((int) Math.random() * this.elements.size());
    }

    /**
     * [EFFECTS] ritorna true se @param x e' contenuto nell'insieme
     * 
     * @param x {@code int} da ricercare all'interno dell'insieme
     *
     * @return true se e' contenuto nell'insieme false altrimenti
     *
     */
    public boolean contains(int x) {
        return this.elements.contains(x);
    }

    /**
     * [EFFECTS] inserisce un elemento nell'insieme
     *
     * @param x {@code int} da inserire all'interno dell'insieme
     */
    public void insert(int x) {
        if (!this.elements.contains(x)) {
            this.elements.add(x);
        }
    }

    /** [EFFECTS] restituisce la dimensione dell'insieme
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof IntSet)) {
            return false;
        }

        boolean res = true;
        IntSet other = (IntSet) obj;
        
        for (Integer i : elements) {
            if (!other.contains(i)) {
                res = false;
                break;
            }
        }

        return res;
    }
}
