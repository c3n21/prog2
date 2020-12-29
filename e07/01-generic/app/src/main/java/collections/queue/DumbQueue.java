package collections.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	@Override
	public boolean enqueue(T e) {
		return elements.add(e);
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
}
