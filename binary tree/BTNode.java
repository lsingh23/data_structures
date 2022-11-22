package Question3;

/**
 * This class represents the generic type building structure for  a binary-tree 
 * @author Lakhveer Singh
 *
 */
public class BTNode <E>{
	/*
	 * data -> data of the object
	 * left -> left child 
	 * right-> right child
	 */
	private E data;
	private BTNode left;
	private BTNode right;
	
	/**
	 * Constructor for BTNode that sets the data ,left child and right child according to arguments
	 * @param data ->data to be stored in the node
	 * @param left ->left child
	 * @param right ->right child
	 */
	public BTNode(E data,BTNode left,BTNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
	}
	
	/**
	 * This method returns data stored in the node
	 * @return data stored in the node
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * This method returns a reference to the left child of the calling node
	 * @return left child of the node
	 */
	public BTNode getLeft() {
		return this.left;
	}
	
	/**
	 * set the left child of a node
	 * @param left ->node to be set at the left  
	 */
	public void setLeft(BTNode left) {
		this.left = left;
	}
	
	/**
	 * This method returns a reference to the right child of the calling node
	 * @return right child of the node
	 */
	public BTNode getRight() {
		return this.right;
	}
	
	/**
	 * set  the right child of a node
	 * @param right ->node to be set at the left
	 */
	public void setRight(BTNode right) {
		this.right = right;
	}
	
	/**
	 * Set the data in the node
	 * @param data -> data to be set in the node
	 */
	public void setData(E data) {
		this.data = data;
	}
	
	/**
	 * This method returns true if the given node is  the leaf-node of the tree
	 * @return true if the given node is  the leaf-node of the tree else return false
	 */
	public boolean isLeaf() {
		return (left==null)&&(right==null);
	}
	
	/**
	 * This method returns the leftmost node in the tree
	 * @return leftmost node in the tree
	 */
	public E getLeftMost() {
		if(left==null) {   //base case
			return (E)data;
		}
		return (E)left.getLeftMost();//recursive call
	}
	
	/**
	 * This method removes the leftmost node in the tree
	 * @return new node at the leftmost position
	 */
	public BTNode removeLeftMost() {
		if(left == null) {        //base case
			return right;
		}
		else {
			left = left.removeLeftMost(); // recursive step
		    return this;
		}
	}	
	
	/**
	 * Prints the tree in pre-order (Starting from root,then left and then right)
	 */
	public void preOrderPrint() {
    	System.out.println(data);
    	if(left!=null)
    	left.preOrderPrint();
    
    	if(right!=null)
    	right.preOrderPrint();
    }
	
	/**
	 * Prints the tree in order (Starting from left,then root and then right)
	 */
	public void inOrderPrint() {
		if(left!=null)
	    	left.inOrderPrint();
		System.out.println(data);
	   	if(right!=null)
	    	right.inOrderPrint();
	}
	
	/**
	 * Prints the tree in post-order (Starting from left,then right and then root)
	 */
	public void postOrderPrint() {
		if(left!=null)
	    	left.postOrderPrint();
	    if(right!=null)
	    	right.postOrderPrint();
	    System.out.println(data);
	}
	
	/**
	 * This method create a copy of the tree and returns reference to the root of the new tree 
	 * @param source root of the tree to be copied
	 * @return root of the new tree
	 */
    public static BTNode treeCopy(BTNode source) {
    	if(source==null) { // base case
    		return null;
    	}
    	else {
    		BTNode leftCopy = treeCopy(source.left);//copy left subtree recursively
        	BTNode rightCopy = treeCopy(source.right);//copy right subtree recursively
        	BTNode new_source = new BTNode(source.data,leftCopy,rightCopy);
    		return new_source;
    	}
    }
    
    /**
     * This method returns the height of the tree
     * @param source ->root of the tree whose height is to be calculated
     * @return the height of the tree
     */
    public static int height(BTNode source) {
    	if(source == null) {     //base case
    		return -1;
    	}
    	else {
    		return 1+Math.max(height(source.left),height(source.right)); //recursive step
    	}
    }
    
    /**
     * This method returns the size of the tree
     * @param source ->root of the tree whose size is to be calculted
     * @return size of the tree
     */
    public static int size(BTNode source) {
    	if(source == null) {         // base case
    		return 0;
    	}
    	else {
    		return 1+size(source.left)+size(source.right); //recursive step
    	}
    }
    
    
    
    
    
    
}
 


