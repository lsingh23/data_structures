package question2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.NumberFormatException;

/**
 * This class represents a GUI that takes size of Integer LinkedList as input and then allow the user to reverse the list.
 * @author Lakhveer Singh  (0380837)
 *
 */
public class Tester extends JFrame implements ActionListener {
	
	/**
	 * declare all the widgets required for our gui
	 */
	private JPanel mainPanel,inputPanel,inputPanelUpper,outputPanel,createPanel1,createPanel2,reversePanel;
	private JTextField input;
	private JButton createButton,reverseButton;
	private JTextArea output;
	private JLabel inputLabel;
	private IntLinkedList list = new IntLinkedList();
	private int num;
	private int countButton;
	
	/**
	 * Constructor for the GUI that create the panels , set the layout of panels and add widgets .
	 */
	public Tester() {
		mainPanel = new JPanel();
		inputPanel = new JPanel();
		outputPanel = new JPanel();
		inputPanelUpper = new JPanel();
		createPanel1 = new JPanel();
		createPanel2 = new JPanel();
		reversePanel = new JPanel();
		input = new JTextField(7);
		output = new JTextArea(20,20);
		createButton = new JButton("Create List");
		reverseButton = new JButton("Reverse List");
		inputLabel = new JLabel("Size of list: ");
		createButton.setEnabled(false);
		
		mainPanel.setLayout(new GridLayout(1,2));
		inputPanel.setLayout(new GridLayout(2,1));
		inputPanelUpper.setLayout(new GridLayout(2,1));
		outputPanel.setLayout(new FlowLayout());
		createPanel1.setLayout(new FlowLayout());
		createPanel2.setLayout(new FlowLayout());
		reversePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
		
		
		inputPanel.setBorder(BorderFactory.createTitledBorder("List Options"));
		inputPanelUpper.setBorder(BorderFactory.createTitledBorder("New List"));
		outputPanel.setBorder(BorderFactory.createTitledBorder("Contents of List"));
		
		input.addActionListener(this);
		createButton.addActionListener(this);
		reverseButton.addActionListener(this);
		createPanel1.add(inputLabel);
		createPanel1.add(input);
		createPanel2.add(createButton);
		reversePanel.add(reverseButton);
		inputPanelUpper.add(createPanel1);
		inputPanelUpper.add(createPanel2);
		inputPanel.add(inputPanelUpper);
		inputPanel.add(reversePanel);
		outputPanel.add(new JScrollPane(output));
		mainPanel.add(inputPanel);
		mainPanel.add(outputPanel);
		
		add(mainPanel);		
	}

	
	/**
	 * Method to interact with the user/get input from user and use specific widget accordingly.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			 num = Integer.parseInt(input.getText());
			 if(e.getSource() == input || e.getSource() == createButton) {
				 createButton.setEnabled(true);
					countButton++;
					if(countButton>=2) {
						output.setText("");
						list = list.createList(num);
						output.append("New List:"+"\n"+list+"\n");
						output.append("-------------------------------------------\n");
					}
					else {
						list = list.createList(num);
						output.append("New List:\n"+list+"\n");
						output.append("------------------------------------------\n");
					}
						
				}
				else if (e.getSource() == reverseButton) {
					list.reverse();
					output.append(list+"\n");
					output.append("-----------------------------------------\n");
				}

		}
		catch(NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Please enter an integer value" );
		}
		catch(IllegalArgumentException a) {
			JOptionPane.showMessageDialog(null, "Can't create a  with value: "+num+"\n"+"Please try another value.");
		}

	}
	
	/**
	 * Main method to create and test the GUI 
	 */
	public static void main(String[] args) {

		Tester gui = new Tester();
		
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500,400);
		gui.setTitle("Dice GUI!!");
		gui.setResizable(true);
	}


}
