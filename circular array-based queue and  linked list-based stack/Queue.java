package question2;

/**
 * Circular array based Queue
 * @author Lakhveer Singh
 */
public class Queue<E> {
	
	private E[] data;//data variable represents an array of type E
	private int f; //front index
	private int r; // rear index
	private int manyItems;// no. of elements in the array
	
	/**
	 * Constructor that sets the front and rear to zero position
	 * and initialize an array of size 5 and set the number of elements to zero
	 */
	public Queue() {
		f = 0;
		r = 0;
		data = (E[])new Object[5];
		manyItems = 0;
	}
	
	/**
	 * EnsureCapacity method to increase the size of the array when required
	 */
	public void ensureCapacity() {
		E[] fake = (E[]) new Object [data.length*2];
		System.arraycopy(data, 0, fake, 0, data.length);
		data = fake;
	}
	
	/**
	 * Add an element to the Queue at the rear index
	 * @param element element to be added to the Queue
	 */
	public void enqueue(E element) {
		if(data.length/2 <= size()) {
			ensureCapacity();
		}
		data[r] = element;
		r = (r+1)%data.length;
	}
	
	/**
	 * Remove an element from the front index of the queue
	 * @return removed element
	 * @throws EmptyQueueException
	 */
	public E dequeue() throws EmptyQueueException{
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}
		E value = data[f];
		data[f] = null;
		f = (f+1)%data.length;
		return value;
	}
	
	/**
	 * return the element at the front index
	 * @return the element at the front index 
	 */
	public E front() {
		return data[f];
	}
	
	/**
	 * Clear the Queue
	 */
	public void clear() {
		data = (E[]) new Object[data.length];
		f = 0;
		r = 0;
	}
	
	/**
	 * return the number of elements in the queue
	 * @return  the number of elements in the queue
	 */
	public int size() {
		return (data.length-f+r)%data.length;
	}
	
	/**
	 * return true if the queue is empty else return false
	 * @return true if the queue is empty else return false
	 */
	public boolean isEmpty() {
		return f==r;
	}
	
	/**
	 * String representation of the queue
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Queue[");
		int last = 0;
		for(int i=0;i<data.length-1;i++) {
			if(data[i+1]!=null) {
			str.append(data[i]+",");
			last = i+1;
			}
		}
		str.append(data[last]);
		str.append("]");
		return str.toString();
	}
}
