package Question1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;


/**
 * This class calculates the gcd of two positive integers using recursive algorithm
 * @author Lakhveer Singh
 *
 */
public class Euclid extends JFrame implements ActionListener{
	
	/*
	 * widgets required for GUI
	 */
	private JPanel mainPanel,inputPanel,outputPanel;
    private JTextField input1,input2;
    private JLabel label1,label2; 
	private JButton button;
	private JTextArea output;
	
	/*
	 * Default Constructor for Euclid class that defines all widgets for GUI
	 */
	public Euclid() {
		
		//JPanel
		mainPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new GridLayout(3,2));
		outputPanel = new JPanel(new GridLayout(1,1));
		//JButton
		button = new JButton("Calculate GCD");
		button.addActionListener(this);
		//JTextFields
		input1 = new JTextField(10);
		input1.addActionListener(this);
		input2 = new JTextField(10);
		input2.addActionListener(this);
		//JLabels
		label1 = new JLabel("Enter num1 :");
		label2 = new JLabel("Enter num2 :");
		//JTextArea
		output = new JTextArea(15,35);
		//add all widgets wherever required
		outputPanel.add(new JScrollPane(output));
		inputPanel.add(label1);
		inputPanel.add(input1);
		inputPanel.add(label2);
		inputPanel.add(input2);
		inputPanel.add(button);
		//add all panels
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		add(mainPanel);
	}

	/**
	 * Main method that sets up the GUI window settings
	 */
	public static void main(String[] args) {
		
 		Euclid window = new Euclid();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("GCD Calculator");
		
	}
	
	/**
	 * Method for calculating the greatest common divisor(gcd)
	 * @param m integer argument1
	 * @param n integer argument2
	 * @return gcd of m and n
	 */
	public static int gcd(int m,int n) {
		//if the first argument is > than first argument then we swap the values in order to have the greatest 
		//among the two as first argument.
		if(m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		//base case for stopping the recursive process
		if(m%n==0) {
			return n;
		}
		else {
			return gcd(n,m%n); // recursive step 
		}
	}

	/*
	 * actionPerformed method for ActionListener of Euclid class
	 */
	public void actionPerformed(ActionEvent e) {
		//if source of input is "button"
		if(e.getSource()==button) {
			//clear the output text 
			output.setText("");
			try {
				int num1 = Integer.parseInt(input1.getText());//num1 from input1
				int num2 = Integer.parseInt(input2.getText());//num2 from input2
				output.append("GCD of "+num1+" & "+num2+" : "+gcd(num1,num2)+"\n");
			}
			catch(NumberFormatException m) {
				JOptionPane.showMessageDialog(null, "Invalid number\nTry Again.");
			}
			catch(Exception n) {
				JOptionPane.showMessageDialog(null, n.getMessage());
			}
			input1.setText("");
			input2.setText("");
		}
		
	}
}
