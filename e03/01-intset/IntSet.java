
/**
 * [OVERVIEW]
 *      classe che rappresenta gli insiemi matematici.
 *      Una volta istanziato un {@code IntSet} e' possibile manipolarlo
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class IntSet {

    private List<Integer> elements;

    public IntSet() {
        this.elements = new ArrayList<>();
    }

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

    /**
     * [EFFECTS] restituisce la dimensione dell'insieme
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
}