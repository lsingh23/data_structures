package Question3;

/**
 * This class represents binary tree for storing and testing Strings 
 * @author Lakhveer Singh
 *
 */
public class TreeBag {
	
	//root of the tree
	private BTNode root;
	
	/**
	 * Default Constructor that sets the root to null
	 */
	public TreeBag() {
		root = null;
	}
	
	/**
	 * This method returns the root of the tree
	 * @return root of the tree
	 */
	public BTNode getRoot() {
		return root;
	}
	
	/**
	 * This method adds the String into the tree 
	 * @param str -> string to be added in the tree
	 */
	public void add(String str) {
		//create the node with the str as data of the node
		BTNode new_node = new BTNode(str,null,null);
		BTNode cursor = root;    //cursor to loop through the tree
		BTNode ptr = null;       //pointer to find the location where string is to be added 
		
		while(cursor!=null) {
			ptr = cursor;        //set the pointer to root
			if(str.compareToIgnoreCase((String)ptr.getData())<0) //set the cursor to the left if the string is
				                                                 //lower in alphabetic order
			{	                                                  
				cursor = cursor.getLeft();
			}
			else {
				cursor = cursor.getRight();                        //set the cursor to the right
			}
		}
		
		if(ptr == null) {       //if tree is empty set the root to new_node
			root = new_node;
		}
		else if(str.compareToIgnoreCase((String)ptr.getData())<0) {
			ptr.setLeft(new_node);; //set the new_node as the left child of the pointer
		}
		else {
			ptr.setRight(new_node); //set the new_node as the right child of the pointer
		}	
	}
	
	/**
	 * This method search for a string in the tree , return true if it is found else return false
	 * @param str ->string to be searched in the tree
	 * @return true if str is found else return false
	 */
	public boolean search(String str) {
		
		//cursor to loop through the tree
		BTNode cursor = root;
		//pointer to find the location of the string
		BTNode ptr = null;
		
		while(cursor!=null) {
			ptr = cursor;   //set the pointer to root
			if(str.compareToIgnoreCase((String)ptr.getData())==0) {//string is found 
				return true;
			}
			if(str.compareToIgnoreCase((String)ptr.getData())<0) {//string  is in the left sub-tree
				cursor = cursor.getLeft();
			}
			else {                                                //string is in the right sub-tree
				cursor = cursor.getRight();         
			}
		}
		return false;
	}
}
