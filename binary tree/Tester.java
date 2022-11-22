package Question3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;


/**
 * This class tests the functionality of the TreeBag and BTNode using a GUI program
 * @author Lakhveer Singh
 *
 */
public class Tester extends JFrame implements ActionListener{
	
	/*
	 * widgets for creating the GUI
	 */
	private JPanel mainPanel,inputPanel,outputPanel;
    private JFileChooser choose_dictionary,choose_file;
	private File file;
	private int returnVal;
	private JButton select_dictionary,select_file;
	private JTextArea output;
	private TreeBag bag;
	
	/**
	 * Default constructor for setting  the widgets of GUI
	 */
	public Tester() {
		//JPanels
		mainPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new GridLayout(3,1));
		outputPanel = new JPanel(new GridLayout(1,1));
		//JFileChooser
		choose_dictionary = new JFileChooser();
		choose_file = new JFileChooser();
		//JTextArea
		output = new JTextArea(20,35);
		outputPanel.add(new JScrollPane(output));
		//JButtons
		select_dictionary = new JButton("Select Dictionary");
		select_dictionary.addActionListener(this);
		select_file = new JButton("Select File");
		select_file.addActionListener(this);
		//add widgets wherever required
		inputPanel.add(select_dictionary);
		inputPanel.add(new JPanel(new FlowLayout()));
		inputPanel.add(select_file);
		//add Panels
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		add(mainPanel);
	}
	
	/**
	 * Main method that sets the GUI window 
	 */
	public static void main(String[] args) {
		
 		Tester window = new Tester();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("Binary Tree Dictionary Tester");	
	}

	/**
	 * ActionListener for the Tester class 
	 */
	public void actionPerformed(ActionEvent e) {
		
		//clear the output 
		output.setText("");
		//if source of input is "select_dictionary"
		if(e.getSource()==select_dictionary) {
			returnVal = choose_dictionary.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				file = choose_dictionary.getSelectedFile();
				Scanner reader;
					try {
						reader = new Scanner(file);  
						bag = new TreeBag();        //create a tree  
						String str;
						while(reader.hasNext()) { //read the input from dictionary
							str = reader.next();
							String[] st = stringSplit(str); //split the String to ignore spaces,punctuation
							                                //and numbers
							bag.add(st[0]);  // add the word to the tree
						}
						output.append("Dictionary has been loaded successfully.\n"
								+ "Select a File to continue.\n");
						reader.close();
					}
					catch(InputMismatchException e1) {
						JOptionPane.showMessageDialog(null, "Please select a correct file");
					}
					catch (FileNotFoundException e2) {
						JOptionPane.showMessageDialog(null, "File Not Found");
					}
					
			}
		}
		//if source is "select_file"
		else if(e.getSource()==select_file) {
			returnVal = choose_file.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				file = choose_file.getSelectedFile();
				int mis_spelled = 0;//counter for no. of misspelled words
				Scanner reader;
				try {
					reader = new Scanner(file);
					String str;
					output.append("Misspelled Words: \n");
					while(reader.hasNext()) { //read the file
						str = reader.next();
						String[] st = stringSplit(str);//split the String to ignore spaces,punctuation
                                                       //and numbers
						if(!bag.search(st[0])) {       //if not found
							mis_spelled++;             //increment the counter
							output.append(str + "\n"); //print the misspelled words
						}
					}
					output.append("\n-----------------------------------------------");
					output.append("\n"+"Number of misspelled words : "+mis_spelled);
					output.append("\n-----------------------------------------------");
					output.append("\n"+"Height of the tree: "+ bag.getRoot().height(bag.getRoot()));
					output.append("\n-----------------------------------------------");
					output.append("\n"+"Total number of words in the dictionary: "+bag.getRoot().size(bag.getRoot()));
					output.append("\n-----------------------------------------------\n");
					reader.close();
				}
				catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(null, "Please select a correct file");
				}
				catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "File Not Found");
				}
			}
		}
	}
	
	/**
	 * This method splits the string using in-built string functions and return an array containing the 
	 * string with no spaces ,punctuation and numbers
	 * @param str string to be split
	 * @return  array containing the  string with no spaces ,punctuation and numbers
	 */
	public static String[] stringSplit(String str) {
		String s = str.replaceAll("\\d+", ""); //replace all the numbers
		String[] array = s.split("[\\p{Punct}\\s]+"); //split the string ignoring punctuation and spaces
		return array;
	}
	
}



