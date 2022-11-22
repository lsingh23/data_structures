package question2;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

/**
 * Tester class for testing the  Palindrome
 * @author Lakhveer Singh
 *
 */
public class Tester extends JFrame implements ActionListener{
	
	private JPanel mainPanel,inputPanel,buttonPanel;
	private JLabel titleLabel;
	private JTextField input;
	private JButton test;
	private Stack<String> stack;
	private Queue<String> queue;
	
	/**
	 * Default Constructor
	 */
	public Tester() {
		
		stack = new Stack();
		queue = new Queue();
		
		mainPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new GridLayout(3,0));
		titleLabel = new JLabel("Word-by-word Palindrome Tester:");
		inputPanel.add(titleLabel);
		input = new JTextField(50);
		input.setText("Enter a string to test .");
		input.addActionListener(this);
		inputPanel.add(input);
		buttonPanel = new JPanel(new FlowLayout());
		test = new JButton("Test String!");
		test.addActionListener(this);
		test.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1, true) ,BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		buttonPanel.add(test);
		inputPanel.add(buttonPanel);
		mainPanel.add(inputPanel);
		add(mainPanel);
	}

	/**
	 * Sets the GUI window
	 */
	public static void main(String [] args) {
		Tester window = new Tester();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("Palindrome Tester");
	}
	
	/**
	 * Split the string
	 */
	public static String[] splitString(String str) {
		String[] array = str.split("[\\p{Punct}\\s]+");
		return array;
	}


	/**
	 * ActionListener 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input || e.getSource()==test) {
			String str = input.getText();
			input.setText("");
			String[] array =splitString(str);
			for(String w: array) {
				stack.push(w);
				queue.enqueue(w);
			}
			
			String testStack,testQueue;
			boolean isPalindrome = true;
			
			for(int i=0;i<array.length;i++){
				testStack = stack.peek();
				stack.pop();
				try {
					testQueue = queue.dequeue();
					if(testStack.compareToIgnoreCase(testQueue)<0 || testStack.compareToIgnoreCase(testQueue)>0) {
						isPalindrome = false;
					}
				} catch (EmptyQueueException e1) {
					JOptionPane.showMessageDialog(null, "Empty String");
				}
				
				
			}
			if(isPalindrome) {
				JOptionPane.showMessageDialog(null, "String entered is a Palindrome");
			}
			else {
				JOptionPane.showMessageDialog(null,"String tested is not a Palindrome");
			}

		}
    }

}
