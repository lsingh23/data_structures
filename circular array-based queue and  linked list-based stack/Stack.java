package question2;

/**
 * Stack class using linked list
 * @author Lakhveer Singh
 *
 */
public class Stack<E> {
	
	/**
	 * Node class that is used for the linked  list
	 * @author Lakhveer Singh
	 *
	 */
	private class Node {
		/*
		 * data - element in the node
		 * next - pointer to the next node
		 */
		public Node next;
		public E data;
		
		/**
		 * Constructor for Node
		 * @param data element in the node
		 * @param next pointer to the next node
		 */
		public Node(E data,Node next) {
			this.next = next;
			this.data = data ;
		}
	}
	
	/*
	 * head of the list
	 */
	private Node head;
	
	/**
	 * Add an element at the head of the list
	 * @param element
	 */
	public void push(E element) {
		Node new_node = new Node(element,null);
		new_node.next = head;
		head = new_node;
	}
	
	/**
	 * Remove an element from the head of the stack
	 */
	public void pop() {
		head = head.next;
	}
	
	/**
	 * return the element at the head of the stack
	 * @return the element at the head of the stack
	 */
	public E peek() {
		return head.data;
	}
	
	/**
	 * return true if the list is empty else return false
	 * @return  true if the list is empty else return false
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * return the size of the list
	 * @return  the size of the list
	 */
	public int size() {
		int size = 0;
		Node ptr = head;
		while(ptr != null) {
			ptr = ptr.next;
			size++;
		}
		return size;
	}
	
	/**
	 * String representation of the string
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Stack[");
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
