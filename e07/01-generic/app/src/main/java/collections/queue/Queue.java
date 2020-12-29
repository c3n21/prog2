package collections.queue;

public interface Queue<E> extends Iterable<E> {
    /**
     * @return - size of the queue
     */
    int size();

    /**
     * @return - whether the queue is empty or not
     */
    boolean isEmpty();

    /**
     * @param e - element to add in the queue
     * @return - true if the insertion is successful, otherwise false
     */
    boolean enqueue(E e);

    /**
     * @return - pops the value of the first element
     */
    E dequeue();
}
