package collections.set;

public interface Set<E> extends Iterable<E> {

    /**
     * @return size of the Set
     */
    int size();

    /**
     * @return true if the Set is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * @param o - object to lookup
     * @return true if the Set contains the object o
     */
    boolean contains(Object o);

    /**
     * @return extracts an element from the Set
     */
    E choose();

    /**
     * @param e - element to add in the Set if it is not present
     * @return true if the element was added succesfully, false otherwise
     */
    boolean add(E e);

    /**
     * @param o - element to remove from the Set
     * @return true if it was removed successfully, false otherwise
     */
    boolean remove(Object o);
}
