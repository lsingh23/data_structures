package assignment_1;

/*
 *  A Simple Student Class that represents a single Student object that has a name ,
 *  id and grade.
 *  
 *  @author Lakhveer Singh
 */
public class Student {
	
	/*
	 * declaring all of the private variables that we need.
	 */
	private String studentName ;
	private  int studentID;
	private double grade;
	
	/*
	 * A No-argument constructor that creates a Student object with the initializations 
	 * specified below.
	 */
	public Student(){
		studentName = "";
		studentID = 0;
		grade  = 0;
	}
	
	/*
	 * Argumented Constructor that creates a Student object with the provided parameters 
	 * @param studentName Name of the student
	 * @param studentID  ID of the student(integer value)
	 * @param grade  Grade of the student(double value)
	 */
	public Student(String studentName,int studentID,double grade){
		this.studentName = studentName;
		this.studentID = studentID;
		this.grade = grade;
	}
	
	/*
	 * A Copy constructor that creates a copy of a Student Object.
	 * @param other Student object whose copy is to be created.
	 */
	public Student(Student other){
		studentName = other.studentName;
		studentID = other.studentID;
		grade = other.grade;
	}
	
	/*
	 * A simple getName method that returns the name of the Student object.
	 * @return name of the Student object.
	 */
	public String getName() {
		return studentName;
	}
	
	/*
	 * getID method returns the id of the Student object.
	 * @return id of the Student object.
	 */
	public int getID() {
		return studentID;
	}
	
	/*
	 * getGrade method returns grade of the Student object.
	 * @return grade of the Student object.
	 */
	public double getGrade() {
		return grade;
	}
	
	/*
	 * A simple toString method to print the state of the Student object
	 * @return string representing the state of the Student object.
	 */
	public String toString() {
		return ""+studentName + "  " + studentID + " " + grade+"";
	}
	
	
}
