package question2;


/**
 * A simple node class that forms the base for the LinkedList using generics.
 * @author Lakhveer Singh
 */
public class Node<E> {

	/*
	 * data - Object type variable and pointer to the next node 
	 */
	private E data;
	private Node next;
	
	/**
	 * Constructor that sets the data as well as pointer of the node
	 * @param data Object type data to be added in the node
	 * @param next pointer to the next node
	 * 
	 */
	public Node(E data,Node next) {
		this.data = data;
		this.next = next;
	}
	
	/**
	* this method returns the value inside the data field of the node
    * @return the value inside the data field of the node 
    */
	public E getData() {return data;}
	
	/**
	 * this method returns the pointer to the next Node
	 * @return the pointer to the next Node
	 */
	public Node getLink(){return next;}
	
	/**
	 * this method sets the value provided as parameter to the data field of the Node
	 * @param data value to be set in the Node's data field
	 */
	public void setData(E data) {this.data = data;}
	
	/**
	 * this method sets the pointer of the node as per the argument given
	 * @param next Node to be pointed by the this node's next pointer
	 */
	public void setLink(Node next) {this.next = next;}
	
	/**
	 * Prints the object's state inside Node's data field
	 * @return data field of the Node
	 */
	public String toString() {
		return data+" ";
	}
}
