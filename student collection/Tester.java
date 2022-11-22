package assignment_1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;

/*
 * Tester class for testing the StudentConatiner
 * @author Lakhveer Singh
 */
public class Tester extends JFrame implements ActionListener {

	private JPanel mainPanel,titlePanel,outputPanel, inputPanel;
	private JTextArea output;
	private JLabel titleLabel,sortLabel;
	private JButton maximum, minimum, average, select;
	private JComboBox sort;
	private StudentContainer student_record;
	private JFileChooser filechooser;
	private File file;
	private int returnVal;
	
	/*
	 * No-Argument Constructor basically creates  the GUI.
	 */
	public Tester() {
		
		/*
		 * create all JPanels that we need.
		 */
		mainPanel = new JPanel(new FlowLayout());
		titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		outputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//JTextArea
		output = new JTextArea(15, 30);
		
		//JLabels
		titleLabel = new JLabel("Student Records:");
		sortLabel = new JLabel("Sort by:");
		
		//JButtons
		maximum = new JButton("Maximum");
		maximum.setEnabled(false);
		maximum.addActionListener(new buttonListener());
		minimum = new JButton("Minimum");
		minimum.setEnabled(false);
		minimum.addActionListener(new buttonListener());
		average = new JButton("Average");
		average.setEnabled(false);
		average.addActionListener(new buttonListener());
		select = new JButton("Select File");
		select.addActionListener(this);
			
        String options[] = {"Ascending", "Descending"};//options array for JComboBox
    
        //JComboBox
      	sort = new JComboBox(options);
      	sort.setEnabled(false);
  		sort.addActionListener(new buttonListener());
      		
		filechooser = new JFileChooser();              
		student_record = new StudentContainer(20);//initialize the StudentConatiner using it's constructor
	
		//add everything to the JPanels
		titlePanel.add(titleLabel);
		outputPanel.add(new JScrollPane(output));
		output.setText("");
		inputPanel.add(maximum);
		inputPanel.add(minimum);
		inputPanel.add(average);
		inputPanel.add(select);
		inputPanel.add(sortLabel);
		inputPanel.add(sort);
		
        //add all the Panels to the main Panel.
		mainPanel.add(titlePanel);
		mainPanel.add(outputPanel);
		mainPanel.add(inputPanel);
		add(mainPanel);

	}


	/*
	 * Main method that sets the GUI window settings
	 */
	public static void main(String[] args) throws Exception {
		
 		Tester window = new Tester();
		window.setVisible(true);
		window.setSize(650, 350);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("STUDENT CONTAINER");
 
	}

	/*
	 * buttonListener class for maximum,minimum,average & sort 
	 */
	private class buttonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==maximum) {
				output.append(student_record.maximum());
				output.append("\n"+"--------------------------------------"+"\n");
				
			}
			else if(e.getSource()==minimum) {
				output.append(student_record.minimum());
				output.append("\n"+"--------------------------------------"+"\n");
				
			}
			else if(e.getSource()==average) {
				output.append(student_record.average());
				output.append("\n"+"--------------------------------------"+"\n");
				
			}
			else if(e.getSource()==sort) {
				String selection = (String)sort.getSelectedItem();
				if(selection == "Ascending") {
					output.append(student_record.ascending());
					output.append("\n"+"--------------------------------------"+"\n");
				}
				else {
					output.append(student_record.descending());
					output.append("\n"+"--------------------------------------"+"\n");
				}
			}
			
		}
	}

	/*
	 * actionPerformed method for ActionListener of Tester class
	 */
	public void actionPerformed(ActionEvent e) {
		
		output.setText("");
		/*
		 * if the button "Select File" is selected do the following.
		 */
		if(e.getSource()==select) {
			returnVal = filechooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				maximum.setEnabled(true);
				maximum.setBackground(Color.green);
				minimum.setEnabled(true);
				minimum.setBackground(Color.orange);
				average.setEnabled(true);
				average.setBackground(Color.yellow);
				select.setBackground(Color.red);
				sort.setEnabled(true);
				file = filechooser.getSelectedFile();
				
				Scanner reader;
				try {
					reader = new Scanner(file);
					int value = reader.nextInt();//get the no. of students from the file
					student_record = new StudentContainer(value);
					while(reader.hasNext()) {
						Student student;
						String name = reader.next();//first name of student 
						String lastname = reader.next();// last name of student
						int id = reader.nextInt();//id of student
						double grade = reader.nextDouble();//grade of student
						student = new Student(name+" "+lastname,id,grade);//create a Student object using 
						                                                  // it's copy constructor
						student_record.add(student);//add student to the the student container
					}
					output.append(student_record+"");
					output.append("\n"+"--------------------------------------"+"\n");
					
					reader.close();
					
				} 
				catch(InputMismatchException e1) {
					JOptionPane.showMessageDialog(null, "Input mismatched.Please check your data in the file and try again.");
				}
				catch(NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "No such element found in the selected file.");
				}
				catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null,"File Not Found");
				}
			}
		 }
	}
}

