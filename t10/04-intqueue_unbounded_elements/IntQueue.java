import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementation of the queue data structure with integer data. IntQueue
 * objects are mutable.
 */
public class IntQueue {
	private final List<Integer> q;

	/*
	 * Abstraction Function: AF(q) = Queue{q.get(0), q.get(1), ...,
	 * q.get(q.size()-1)}. If q.isEmpty(), AF(q) is the empty queue.
	 *
	 * Representation Invariant: q is non null.
	 */

	/**
	 * Constructs an empty {@code IntQueue}.
	 */
	public IntQueue() {
		this.q = new ArrayList<Integer>(); // non null
		assert repOk();
	}

	/**
	 * Implementation of the representation invariant. Returns true if the
	 * representation respects all its requirements. Used in assertions.
	 * 
	 * @return true if the representation is ok; false otherwise.
	 */
	public boolean repOk() {
		return q != null;
	}

	/**
	 * Returns true if this queue has no elements.
	 *
	 * @return true if the queue is empty.
	 */
	public boolean isEmpty() {
		// observer
		return q.isEmpty();
	}

	/**
	 * Adds n to this queue. Modifies this.
	 * 
	 * @param n element to add.
	 */
	public void enqueue(int n) {
		q.add(n); // still not null
		assert repOk();
	}

	/**
	 * Removes and returns the head element from this queue. The queue must not be
	 * empty. Modifies this.
	 * 
	 * @return the removed element.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public int dequeue() {
		if (q.isEmpty())
			throw new EmptyQueueException("can't dequeue, queue is empty");
		int out = q.remove(0); // still not null
		assert repOk();
		return out;
	}

	/**
	 * Returns this queue's size.
	 *
	 * @return this' size.
	 */
	public int size() {
		// observer
		return q.size();
	}

	/**
	 * Returns a string identifying this queue.
	 *
	 * @return a string identifying this queue.
	 */
	@Override
	public String toString() {
		String res = "IntQueue : [";
		int size = q.size();
		if (size > 0) {
			Iterator<Integer> iter = q.iterator();
			for (int i = 0; i < size - 1; i++)
				res += iter.next() + ", ";
			res += iter.next();
		}
		return res + "]";
	}

	/**
	 * Compares the specified object with this IntQueue for equality. Two
	 * {@code IntQueue}s are defined to be equal if they contain equal {@code int}s,
	 * in the same place relative to the head of the queue.
	 *
	 * @param o the object to be compared with this.
	 * @return true if this and o are equals.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof IntQueue))
			return false;
		IntQueue other = (IntQueue) o;
		return this.q.equals(other.q);
	}

	/**
	 * Returns the hash code value for this IntQueue.
	 *
	 * @return the hash code.
	 */
	@Override
	public int hashCode() {
		return q.hashCode();
	}

	/**
	 * Returns a shallow copy of this IntQueue instance.
	 *
	 * @return a clone of this
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		IntQueue res = new IntQueue();
		for (int element : q)
			res.enqueue(element);
		return res;
	}

    public Iterator<Integer> elements() {
        return q.iterator();
//        return new Iterator<Integer>() {
//
//            
//        };
    }
}
