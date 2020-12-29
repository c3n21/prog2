package collections.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Overview:
 *
 * A dumb implementation of a Queue
 *
 */

public class DumbQueue<T> implements Queue<T> {

    private final List<T> elements;

    /**
     * [ABS FUN] 
     *      AF(elements) = {x0, x1, x_{n-1}, x_n}
     *
     * [REP INV]
     *      elements != null
     */

    public DumbQueue() {
        elements = new ArrayList<>();
    }

	@Override
	public Iterator<T> iterator() {
		return elements.iterator();
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

    /**
     * @param e - element to add
     * @return - true as specified in {@link java.util.Collection}
     *
     * [OP CORRECTNESS]
     *      adds the element at the end of the list
     *
     * [REP PRESERVATION]
     *      the rep is preservated since the new element is added at the end of the list
     */
	@Override
	public boolean enqueue(T e) {
		return elements.add(e);
	}

    /**
     * @return - pops the value of the first element
     *
     * [OP CORRECTNESS]
     *      if queue != empty:
     *          retrieves the first element and stores it
     *          removes the element from the list
     *      else:
     *          element is null
     *
     * [REP PRESERVATION]
     */
	@Override
	public T dequeue() {
        T element;

        if (elements.size() > 0) {
            element = elements.get(0);
            elements.remove(0);
        } else {
            element = null;
        }

		return element;
	}

    @Override
    public String toString() {
        return "[" + elements.stream().map(element -> element.toString()).collect(Collectors.joining(",")) + "]";
    }
}
