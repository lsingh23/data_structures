package Question2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;

import Question1.Euclid;

/**
 * This class calculates an approximation of the square root of a number within a specified tolerance
 * @author Lakhveer Singh
 *
 */
public class SqRoot extends JFrame implements ActionListener{
	
	/*
	 * widgets required for GUI
	 */
	private JPanel mainPanel,inputPanel,outputPanel;
    private JTextField input1,input2,input3;
    private JLabel label1,label2,label3; 
	private JButton button;
	private JTextArea output;
	
	/*
	 * Default Constructor for SqRoot class that defines all widgets for GUI
	 */
	public SqRoot() {
		
		//JPanel
		mainPanel = new JPanel(new FlowLayout());
		inputPanel = new JPanel(new GridLayout(4,2));
		outputPanel = new JPanel(new GridLayout(1,1));
		//JButton
		button = new JButton("Calculate Square Root");
		button.addActionListener(this);
		//JTextFields
		input1 = new JTextField(10);
		input1.addActionListener(this);
		input2 = new JTextField(10);
		input2.addActionListener(this);
		input3 = new JTextField(10);
		input3.addActionListener(this);
		//JLabels
		label1 = new JLabel("Enter Number :");
		label2 = new JLabel("Enter Approx value :");
		label3 = new JLabel("Enter Tolerance:");
		//JTextArea
		output = new JTextArea(15,35);
		outputPanel.add(new JScrollPane(output));
		//add all widgets wherever required
		inputPanel.add(label1);
		inputPanel.add(input1);
		inputPanel.add(label2);
		inputPanel.add(input2);
		inputPanel.add(label3);
		inputPanel.add(input3);
		inputPanel.add(button);
		//add Panels
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		add(mainPanel);
	}

	/**
	 * Main method that sets up the GUI window settings
	 */
	public static void main(String [] args) {
		SqRoot window = new SqRoot();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("SqRoot Calculator");
	}
	
	/**
	 * Recursive method that calculates an approximation of the square root of a number
	 * starting with an approximate answer  within the specified tolerance . 
	 * @param number number whose square root is to be calculated
	 * @param approx approximate answer for square root
	 * @param tol tolerance
	 * @return square root of the number 
	 */
	public static double sqrRoot(double number,double approx,double tol) {
		
		//approx^2-number
		double check = Math.pow(approx, 2)-number;
		//if check is negative make it positive (take the absolute value)
		check = check < 0 ? -(check) : check;
		//base case for stopping the recursive process
		if(check<=tol) {
			return approx;
		}
		//recursive 
		return sqrRoot(number,(Math.pow(approx, 2)+number)/(2*approx),tol);
	}
	
	/**
	 * Non-recursive method that calculates an approximation of the square root of a number
	 * starting with an approximate answer  within the specified tolerance . 
	 * @param number number whose square root is to be calculated
	 * @param approx approximate answer for square root
	 * @param tol tolerance
	 * @return square root of the number 
	 */
	public static double NR_sqRoot(double number,double approx,double tol) {
		
		//approx^2-number
		double check = Math.pow(approx, 2)-number;
		//if check is negative make it positive (take the absolute value)
		check = check < 0 ? -(check) : check;
		//non recursive while loop to calculate square root
		while(check>tol) {
			approx = (Math.pow(approx,2)+number)/(2*approx);
			check = Math.pow(approx, 2)-number;
		}
		return approx;
	}
	
	/*
	 * actionPerformed method for ActionListener of SqRoot class
	 */
	public void actionPerformed(ActionEvent e) {
		//if source of input is "button"
		if(e.getSource()==button) {
			//clear the text area
			output.setText("");
			try {
				double num1 = Double.parseDouble(input1.getText());//number from input1
				double num2 = Double.parseDouble(input2.getText());//approx from input2
				double num3 = Double.parseDouble(input3.getText());//tolerance from input3
				output.append("Square Root (Non-Recursive Method):-\n"+NR_sqRoot(num1,num2,num3)+"\n");
				output.append("Square Root (Recursive Method):-\n"+sqrRoot(num1,num2,num3)+"\n");
			}
			catch(StackOverflowError e1) {
				JOptionPane.showMessageDialog(null, "Stack OverFlow for the recursive method");
			}
			catch(NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}
			input1.setText("");
			input2.setText("");
			input3.setText("");
		}
	}
}
