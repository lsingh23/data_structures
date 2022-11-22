package question2;

import java.util.Random;

/**
 * LinkedList  of integers.
 * @author Lakhveer Singh
 *
 */
public class IntLinkedList {


	/*
	 * head - the head of LinkedList .
	 * size -  no. of elements in the list.
	 */
	private Node<Integer> head;
	private int size;
	

	/**
	 * No-argument constructor that creates a IntLinkedList with size 0 and head = null
	 */
	public IntLinkedList() {
		head =null;
		size =0;
	}
	
	/**
	 * this method creates  a new LinkedList with the user-specified size and with random values from 1 to 1000
	 * and returns this new LinkedList.
	 * @param list_size  size of the list to be created
	 * @return  a new LinkedList with the user-specified size and with random values from 1 to 1000
	 */
	public IntLinkedList createList(int list_size) {
		if(list_size<0) {
			throw new IllegalArgumentException ("list size can't be negative");
		}
		Random rand = new Random();
		IntLinkedList list = new IntLinkedList(); // create a new list 
		for(int i=0;i<list_size;i++) {
			list.add(rand.nextInt(1000)+1);
		}                                         // run the loop list_size times and 
		                                          // keep on adding random numbers in the list
		return list;
	}
	
	/**
	 * This method add elements at the head of the list
	 * @param element element to added in the list
	 */
	public void add(int element) {
		 
		 head = new Node(element,head);
		 size++;
	}
	
	/**
	 * this method returns the size of the IntLinkedList
	 * @return size of the list
	 */
	public int size(){
		return size;
	}
	
	/**
     * this method takes a linked list of integers and reverses its order.
	 * @param list list to be reversed
	 */
	public void reverse() {
		
		Node previous = null;
		Node next = null;
		Node ptr  = head;
		while(ptr!=null) {
			next = ptr.getLink();      // next = ptr.link;
			ptr.setLink(previous);     // ptr = previous;
			previous = ptr;
			ptr = next;
		}
		
		head = previous; 
	}
	
	/**
	 * print the List.
	 */
	public String toString() {
		String str = "";
		Node ptr = head;
		while(ptr!=null) {
			str += ptr.getData();
			if(ptr.getLink()!=null) {
				str += "\n";
			}
			ptr = ptr.getLink();
		}
		str += "";
		return str;
	}

}
