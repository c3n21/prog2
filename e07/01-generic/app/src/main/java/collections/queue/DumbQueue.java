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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enqueue(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
}
