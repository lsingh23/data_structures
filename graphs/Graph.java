package Assignment5;

/*
 * importing required containers
 */
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class represents a graph built using an adjacency list.
 * @author Lakhveer Singh
 *
 */
public class Graph {
	
	/*
	 * numVertices variable for number of vertices in the graph
	 * list variable for the list that stores the connected vertices at each index of the list
	 */
	private int numVertices;
	private LinkedList<Character>[] list;
	
	/**
	 * Constructor that sets the numVertices to the argument provided and initializes the each index of 
	 *  the list to a new linkedlist 
	 * @param numVertices -> number of vertices in the graph
	 */
	public Graph(int numVertices) {
		this.numVertices = numVertices;
		list = new LinkedList[numVertices];
		for(int i=0;i<numVertices;i++) {
			list[i] = new LinkedList<Character>();			
		}
	}
	
	/**
	 * this method returns an array of all the connected vertices to a given vertex
	 * @param vertex -> vertex for which we want to know the connected vertices
	 * @return an array of all the connected vertices to a given vertex
	 */
	public char[] neighbours(char vertex) {
		int index = vertex-65;          //covert char to integer first to get the index number
		                               // using ASCII value of A=65
		char[] array = new char[list[index].size()];
		for(int i=0; i<list[index].size(); i++) {
			array[i] = (list[index]).get(i);
		}
		return array;
	}
	
	/**
	 * this method adds an edge to a  vertex  in the graph
	 * @param i -> vertex from where edge is to  be added in the graph
	 * @param j -> vertex to which edge is to be added in the graph
	 */
	public void addEdge(char i,char j) {
		int index = i-65;                  //covert char to integer first to get the index number
		list[index].add(j);
	}
	
	/**
	 * this method returns true if  an edge to a  vertex  in the graph is found else returns false
	 * @param i -> vertex from where edge is to  be checked in the graph
	 * @param j -> vertex to which edge is to be checked in the graph
	 */
	public boolean isEdge(char i,char j) {
		int index = i-65;               //covert char to integer first to get the index number
		return list[index].contains(j);
	}
	
	/**
	 * this method removes an edge to a  vertex  in the graph
	 * @param i -> vertex from where edge is to  be removed in the graph
	 * @param j -> vertex to which edge is to be removed in the graph
	 */
	public void removeEdge(char i,char j) {
		int index = i-65;                //covert char to integer first to get the index number
		list[index].remove(j);
	}
	
	/**
	 * this method returns the number of vertices in the graph
	 * @return number of vertices in the graph
	 */
	public int size() {
		return numVertices;
	}
	
	/**
	 * This method prints the graph according to their position stored in the list
	 */
	public void printGraph(){
        for (int i = 0; i <numVertices ; i++) {
            if(list[i].size()>0) {
            	char c = (char)(i+65);       //covert integer to char  to get the character 
                System.out.print("Vertex " + c + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
	
	/**
	 * Breadth First Search method to iterate through the list 
	 * @param vertex->starting point of the search
	 * @return true if all vertices are visited else return false
	 */
	public boolean bfs(char vertex) {
		int index = vertex-65;              //covert char to integer first to get the index number
		Queue<Character> queue = new PriorityQueue<Character>(); // Container to keep track of next character
		queue.add(vertex);                  //add first character in the queue
		boolean[] marked = new boolean[numVertices]; // array to keep track of marked or visited vertices
		marked[index]=true;                 //first char is marked as visited
		while(!queue.isEmpty()) {           
			char front = queue.remove();    //remove an element from the front of the queue and print it
			//System.out.print(front + " "); //print the element for debugging
			int i = 0;                     
			//while the removed element has any neighbour vertex left 
			while(neighbours(front).length!=0 && i<neighbours(front).length) {
				char nextNeighbour = neighbours(front)[i++]; 
				int nextIndex = nextNeighbour-65;
				//check if the neighbour is already marked ,if not mark it
				if(!marked[nextIndex]) {
					marked[nextIndex]=true;
					queue.add(nextNeighbour); //add the nextNeighbour to the list
				}
			}
		}
		//check the list to see if any vertex is unmarked 
		for(int i=0;i<list.length;i++) {
			if(marked[i]==false) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * This method checks for the strong connectivity of the graph
	 * @param vertex ->starting point to run breadth first search on the graph
	 * @return true if the graph is strongly connected else return false
	 */
	public boolean strong_connectivity(char vertex) {
		/*
		 * if the breadth first search on the list as well as the breadth first search on the transpose of the 
		 * list returns true , the graph is strongly connected.
		 */
		if(this.bfs('A') && this.getTranspose().bfs('A')) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns the graph in the reverse order 
	 * @return the graph that has all the edges reversed
	 */
	public Graph getTranspose() {
		//create a new graph that will be the new reversed graph
		Graph graph = new Graph(numVertices);
		int index=0;
		while(index<numVertices) {
			for(int i=0;i<list[index].size();i++) {
				char c = (char)(index+65);
				graph.addEdge(list[index].get(i),c);//add edge from the  vertices stored at each index to the 
				                                    // index at which they are stored
			} 
			index++;
		}
		return graph;
	}
	
}