package algorithms.utility;
public interface RingADT<T> {

	/**
	 * Task: moves the reference to the next item in the collection. When the
	 * reference reaches the last item, the next advance operation will move the
	 * reference back to the first item
	 */
	public void advance();

	/**
	 * Task: Gets the current item in the ring
	 * 
	 * @return the current element where the reference is
	 */
	public T getCurrentItem();

	/**
	 * Adds a new entry to the ring after in the end. Expand capacity of needed
	 * 
	 * @param element
	 *            is the entry that will be added
	 * @return true if the addition is successful, or false if it is not
	 */
	public boolean add(T element);

	/**
	 * Remove an element entry from the ring if it is possible
	 * 
	 * @param element
	 *            is the entry that will be removed
	 * @return element if the removal was successful or null if it was not
	 */
	public T remove(T element);

}
