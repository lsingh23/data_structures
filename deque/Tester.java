package question1;
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
 * Tester class for testing the Deque class
 * @author Lakhveer Singh
 *
 */
public class Tester extends JFrame implements ActionListener{
	
	private JPanel mainPanel,titlePanel,optionPanel,option1,option2,option3,option4,outputPanel, inputPanel;
	private JLabel titleLabel,newList;
	private JTextArea output;
	private JButton insertFront, insertRear, removeFront,removeRear; 
	private Deque<Integer> list ;
	
	/*
	 * No-Argument Constructor basically creates  the GUI.
	 */
	public Tester() {
		
		/*
		 * create all JPanels that we need.
		 */
		mainPanel = new JPanel(new FlowLayout());
		titlePanel = new JPanel(new GridLayout(3,0));
		optionPanel = new JPanel(new GridLayout(2,2));
		outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		option1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		option2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		option3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		option4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//JButtons
		insertFront = new JButton("Insert Front");
		insertRear = new JButton("Insert Rear");
		removeFront = new JButton("Remove Front");
		removeRear = new JButton("Remove Rear");
		insertFront.addActionListener(this);
		insertFront.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue, 1, true) ,BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		removeRear.addActionListener(this);
		removeRear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1, true) ,BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		insertRear.addActionListener(this);
		insertRear.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red, 1, true) ,BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		removeFront.addActionListener(this);
		removeFront.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.green, 1, true) ,BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		
		
		list = new Deque(); // initialize the list using default constructor
		// add random elements to the list
		for(int i=0;i<5;i++) {
			Random rand = new Random();
			list.insertFront(rand.nextInt(10)+1);
		}
		
		//JLabels
		titleLabel = new JLabel("Sample Deque List: "+list);
		titleLabel.setFont(new Font("Serif",Font.BOLD,20));
		option1.add(insertFront);
		option2.add(insertRear);
		option3.add(removeFront);
		option4.add(removeRear);
		optionPanel.add(option1);
		optionPanel.add(option2);
		optionPanel.add(option3);
		optionPanel.add(option4);
		
		//output section 
		newList = new JLabel("New List: ");
		outputPanel.add(newList);
		output = new JTextArea(4,20);
		outputPanel.add(new JScrollPane(output));
		
		//add all the panels
		titlePanel.add(titleLabel);
		titlePanel.add(optionPanel);
		titlePanel.add(outputPanel);
		mainPanel.add(titlePanel);
		add(mainPanel);
	}
	

	/*
	 * Main method that sets the GUI window settings
	 */
	public static void main(String[] args) {
 		Tester window = new Tester();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("DEQUE USING SINGLY LINKED LIST");
		
	}

	/*
	 * actionPerformed method for ActionListener of Tester class
	 */
	public void actionPerformed(ActionEvent e) {
		/*
		 * if insertFront button is selected
		 */
		if(e.getSource()==insertFront) {
			String optionPane = JOptionPane.showInputDialog("Enter the number you want to add:");
			try {
			int num = (Integer.parseInt(optionPane));
			list.insertFront(num);
			}
			catch(NumberFormatException E) {
				JOptionPane.showMessageDialog(null,"Invalid Argument");
			}
			output.append(list+"\n");
			output.setFont(new Font("Seoge Script",Font.BOLD,20));
			output.setForeground(Color.red);
		}
		/*
		 * if insertRear button is selected
		 */
		else if(e.getSource()==insertRear) {
			String optionPane = JOptionPane.showInputDialog("Enter the number you want to add:");
			
			try{
				int num = (Integer.parseInt(optionPane));
				list.insertRear(num);
			}
			catch(NumberFormatException E) {
				JOptionPane.showMessageDialog(null,"Invalid Argument");
			}
			output.append(list+"\n");
			output.setFont(new Font("Seoge Script",Font.BOLD,20));
			output.setForeground(Color.blue);
		}
		/*
		 * if removeFront button is selected
		 */
		else if(e.getSource()==removeFront) {
			try {
				list.removeFront();
			}
			catch (EmptyDequeException e1) {
				JOptionPane.showMessageDialog(null, "Empty Queue");
			}
			output.append(list+"\n");
			output.setFont(new Font("Seoge Script",Font.BOLD,20));
			output.setForeground(Color.green);
		}
		/*
		 * if removeRear button is selected
		 */
		else if(e.getSource()==removeRear){
			try {
				list.removeRear();
			} 
			catch (EmptyDequeException e2) {
				JOptionPane.showMessageDialog(null, "Empty List");
			}
			output.append(list+"\n");
			output.setFont(new Font("Seoge Script",Font.BOLD,20));
			output.setForeground(Color.orange);
		}
		
	}

	
}
