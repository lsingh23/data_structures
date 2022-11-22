package question1;

/**
 * Deque class using singly linked list
 * @author Lakhveer Singh
 *
 */
public class Deque<E> {

	/**
	 * Node class representing a node for the singly linked list
	 * @author Lakhveer Singh
	 *
	 */
	private class Node<E>{
		/*
		 * data - variable containing the element in the node
		 * next - pointer to the next node
		 */
		private E data;
		private Node next;
		
		/**
		 * Constructor for the Node
		 * @param data - element in the node 
		 * @param next - pointer to the next node
		 */
		public Node(E data,Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	/*
	 * private Nodes for head and tail of the list
	 */
	private Node head,tail;
	
	/**
	 * Default Constructor for Deque
	 */
	public Deque() {
		head = null;
		tail = null;
	}
	
	/**
	 * insert an element at the head of the list
	 * @param element - element to be inserted at the head of the list 
	 */
	public void insertFront(E element) {
		Node new_node = new Node(element,null); // create a new node
		if(head==null) // if the list is empty
		{
			tail = new_node;
		}
		new_node.next = head;
		head = new_node;
	}
	
	/**
	 * remove an element from the head of the list 
	 * @return element at the head of the list
	 * @throws EmptyDequeException
	 */
	public E removeFront() throws EmptyDequeException {
		if(isEmpty()) {
			throw new EmptyDequeException("Empty Queue");
		}
		Node answer = head;
		head  =  head.next;
		return (E) answer.data;
	}
	
	/**
	 * add an element at the tail of the list
	 * @param element element to be inserted at the tail of the list
	 */
	public void insertRear(E element) {
		Node new_node = new Node(element,null);
		if(head==null) // if list is empty
		{
			head = new_node;
			tail = new_node;
		}
		tail.next = new_node;
		tail = new_node;
	}
	
	/**
	 * remove an element from the tail of the list
	 * @return element at the tail of the list
	 * @throws EmptyDequeException
	 */
	public E removeRear()  throws EmptyDequeException{
		
		
		if(head == tail) {
			head = tail = null;
		}
		if(isEmpty()) {
			throw new EmptyDequeException("Empty Queue");
		}
		Node ptr1 = head; //cursor to track the element at node before the tail node
		Node ptr = head.next; 
	
		while(ptr.next != null)
		{
			ptr1 = ptr;
			ptr = ptr.next;
		}
		
		ptr1.next = null;
		tail = ptr1;
		return (E) ptr.data;
	}
	
	/**
	 * Clear the list 
	 */
	public void clear() {
		head = tail = null;
	}
	
	/**
	 * return the element at the head of the list
	 * @return  element at the head of the list
	 * @throws EmptyDequeException
	 */
	public E front() throws EmptyDequeException{
		return (E) head.data;
	}
	
	/**
	 * return the element at the tail of the list
	 * @return element at the tail of the list
	 * @throws EmptyDequeException
	 */
	public E rear() throws EmptyDequeException{
		return (E) tail.data;
	}
	
	/**
	 * return true if the list is empty else return false
	 * @return true if the list is empty else return false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * return the size of the list
	 * @return size of the list
	 */
	public int size() {
		int size = 0;
		Node ptr = head;
		while(ptr!=null) {
			ptr = ptr.next;
			size++;
		}
		return size;
	}
	
	/**
	 * return the string representation of the deque list
	 * @return the string representation of the deque list
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[");
		Node ptr = head;
		while(ptr != null) {
			str.append(ptr.data);
			if(ptr.next!=null) {
				str.append(",");
			}
			ptr = ptr.next;
		}
		str.append("]");
		return str.toString();
	}
}
