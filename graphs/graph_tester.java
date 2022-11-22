package Assignment5;


/*
 * import statements for GUI
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


/**
 * graph_tester class for testing the Graph class
 * @author Lakhveer Singh
 *
 */
public class graph_tester extends JFrame implements ActionListener{
	
	/*
	 * widgets for creating the GUI
	 */
	private JPanel mainPanel,innermainPanel,titlePanel,inputPanel;
	private JLabel title;
	private JButton selectfile;
	private JFileChooser filechooser;
	private File file;
	private int returnVal;
	private Graph graph;
	
	/**
	 * Default constructor for setting  the widgets of GUI
	 */
	public graph_tester() {
		//JPanels
		mainPanel = new JPanel(new FlowLayout());
		innermainPanel = new JPanel(new GridLayout(2,1));
		titlePanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new FlowLayout());
		//JFileChooser
		filechooser = new JFileChooser();
		//JLabel
		title = new JLabel("Computer Network Tester");
	    //JButton
		selectfile = new JButton("Select the file ");
		//add action listener to the button
		selectfile.addActionListener(this);
		//add all the widgets to the panels 
		titlePanel.add(title);
		inputPanel.add(selectfile);
		//add all the panels wherever required
		innermainPanel.add(titlePanel);
		innermainPanel.add(inputPanel);
		mainPanel.add(innermainPanel);
		add(mainPanel);
	}
	
	/*
	 * Main method that sets the GUI window settings
	 */
	public static void main(String[] args) {
 		graph_tester window = new graph_tester();
		window.setVisible(true);
		window.setSize(350, 150);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("Computer Network Connectivity Tester");
	}

	/*
	 * actionPerformed method for ActionListener of graph_tester class
	 */
	public void actionPerformed(ActionEvent e) {
		//if source of input is selctfile button
		if(e.getSource()==selectfile) {
			returnVal = filechooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				//get the selected file
				file = filechooser.getSelectedFile();
				//scanner to read the file 
				Scanner reader;
				try {
					//initialize the scanner
					reader = new Scanner(file);
					//get the number of vertices from the file
					int numVertices = reader.nextInt();
					//create the graph with the number of vertices specified
					graph = new Graph(numVertices);
					// while file has anything to read 
					while(reader.hasNext()) {
						// read the vertex 
						String str = reader.next();
						//convert the vertex to char
						char c = str.charAt(0);
						//store the edges given as integers in an array 
						int num[] = new int[numVertices];
						for(int i=0;i<numVertices;i++) {
							num[i] = reader.nextInt();
							if(num[i]==1) {//if number is one i.e. is an edge
								graph.addEdge(c, (char)(i+65)); // add an edge in the graph
							}
						}
					}
					
					//check for strong connectivity
					if(graph.strong_connectivity('A')) {
						JOptionPane.showMessageDialog(null, "The given computer network has a strong connectivity");
					}
					else {
						JOptionPane.showMessageDialog(null, "The given computer network does not have a strong connectivity");
					}
					reader.close();
				} 
				catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(null, "Input mismatched.Please check your data in the file and try again.");
				}
				catch(NoSuchElementException e3) {
					JOptionPane.showMessageDialog(null, "There is something wrong with the input format.");
				}
				catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null,"File Not Found");
				}
			}
	    }
	}

	
}
