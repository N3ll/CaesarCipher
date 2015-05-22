package algorithms.utility;

import java.util.Arrays;

public class ArrayRing<T> implements RingADT<T> {

	private T[] items;
	private int reference;
	private int numberOfentries;
	private static int INITIAL_CAPACITY;

	public ArrayRing(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[initialCapacity];
		items = temp;
		reference = 0;
		numberOfentries = 0;
	}

	public ArrayRing() {
		this(INITIAL_CAPACITY);
	}

	@Override
	public void advance() {
		if (reference == numberOfentries - 1) {
			reference = 0;
		} else {
			reference++;
		}
	}

	public void counterAdvance() {
		if (reference == 0) {
			reference = numberOfentries - 1;
		} else {
			reference--;
		}
	}

	@Override
	public T getCurrentItem() {
		return items[reference];
	}

	@Override
	public boolean add(T element) {
		ensureCapacity();
		items[numberOfentries] = element;
		numberOfentries++;
		return true;
	}

	// Doubles the size of the array bag if it is full.
	private void ensureCapacity() {
		if (numberOfentries == items.length)
			items = Arrays.copyOf(items, 2 * items.length);
	}

	@Override
	public T remove(T element) {
		T toRemove = null;
		if (reference == numberOfentries - 1) {
			advance();
		}
		for (int i = 0; i < numberOfentries; i++) {
			if (items[i].equals(element)) {
				toRemove = items[i];
				items[i] = items[numberOfentries];
				numberOfentries--;
			}
		}

		return toRemove;
	}

	public int size() {
		return numberOfentries;
	}
}
