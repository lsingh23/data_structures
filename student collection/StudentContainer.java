package assignment_1;

/*
 * This class represents the collection of Student objects created in the Student class.
 * @author Lakhveer Singh
 */
public class StudentContainer {
	
	/*
	 * array - the array of Student objects.
	 * noOfStudents - total no. of students in the array.
	 */
	private Student[] array;
	private int noOfStudents;
	
	/*
	 * No-argument constructor that creates a StudentConatiner with noOfStudents 0 and array-size 10.
	 */
	StudentContainer(){
		noOfStudents =0;
		array = new Student[10];
	}
	
	/*
	 * Argumented Constructor that creates a StudentContainer with noOfStudents 0 and array-size 
	 * as specified.
	 * @param initialCapacity initial capacity of the array.
	 * @throws IllegalArgumentException 
	 * if initialCapacity<1
	 */
	public StudentContainer(int initialCapacity) {
		if(initialCapacity <1) {
			throw new IllegalArgumentException("Intial size must be greater than or equal to 1");
		}
		noOfStudents =0;
		array = new Student[initialCapacity];
	}

	/*
	 * ensureCapacity method ensures that there is enough space in  the array to
	 * add another object.
	 */
	public void ensureCapacity() {
		
		int new_capacity = 2*array.length;//doubling the original size
		
		Student[] fake = new Student[new_capacity];//creating a fake array 
		
		//for loop to copy all the elements into the fake array
		for(int i=0;i<array.length;i++) {
			fake[i] = array[i];
		}
		
		array = fake;//referencing the original array to fake array.
	}
	
	/*
	 * Add a student object in the StudentContainer & sort & save the objects in
	 * the ascending order of their grades.
	 * @param student Student object to be added in the container.
	 */
	public void add(Student student) {
		if(array.length == noOfStudents) {
			ensureCapacity();
		}
		int position = 0;
		for(int i=0;i<noOfStudents; i++) {
			if(student.getGrade()>array[i].getGrade()) {
				position++;
			}
		}
		
		for(int i=noOfStudents; i>position; i--) {
			array[i]=array[i-1];
		}
		
		array[position]=student;
		noOfStudents++;
	}
	
	/*
	 * Return a string of  the student records in the ascending order of their records.
	 * @return student records in the ascending order of their records.
	 */
	public String ascending() {
		Student fake[] = new Student[array.length];
		
		for(int i=0;i<noOfStudents; i++) {
			fake[i] = new Student(array[i]);
		}
		for(int i =0; i<noOfStudents; i++) {//0,1,2,3
			for(int j=i+1; j<noOfStudents; j++) {//1,2,3
				if(fake[i].getGrade()>fake[j].getGrade()) {
					Student temp = fake[i];
					fake[i]=fake[j];
					fake[j]= temp;
				}
			}
		}
		String str = noOfStudents + "\n";
		for(int i=0; i<noOfStudents; i++) {
			str += fake[i]+" \n" ;
		}
		str += " ";
		return str;
	}
	
	/*
	 * Return a string of the student records in the descending order of their records.
	 * @return student records in the descending order of their records.
	 */
	public String descending() {
		Student fake[] = new Student[array.length];
		
		for(int i=0;i<noOfStudents; i++) {
			fake[i] = new Student(array[i]);
		}
		for(int i =0; i<noOfStudents; i++) {//0,1,2,3
			for(int j=i+1; j<noOfStudents; j++) {//1,2,3
				if(fake[i].getGrade()<fake[j].getGrade()) {
					Student temp = fake[i];
					fake[i]=fake[j];
					fake[j]= temp;
				}
			}
		}
		String str = noOfStudents + "\n";
		for(int i=0; i<noOfStudents; i++) {
			str += fake[i]+" \n" ;
		}
		str += " ";
		return str;
	}
	
	/*
	 * Return a string of the maximum grade and the student who got the maximum grade. 
	 * @return a string of the maximum grade and the student who got the maximum grade.  
	 */
	public String maximum() {
		int index = 0;
		double max = array[0].getGrade();
		for(int i=0; i<noOfStudents; i++) {
			if(array[i].getGrade()>max) {
				max = array[i].getGrade();
				index = i;
			}
		}
		String str =  "Maximum Grade : "+max+"\n"+"Student Name: "+array[index].getName()+"\n"
				           +"Student ID : "+array[index].getID();
		return str;
		
	}
	

	/*
	 * Return a string of the minimum grade and the student who got the maximum grade. 
	 * @return a string of the minimum grade and the student who got the maximum grade.  
	 */
	public String minimum() {
		int index = 0;
		double min = array[0].getGrade();
		for(int i=0; i<noOfStudents; i++) {
			if(array[i].getGrade()<min) {
				min = array[i].getGrade();
				index = i;
			}
		}
		String str = "Minimum Grade : "+min+"\n"+"Student Name: "+array[index].getName()+"\n"
				           +"Student ID : "+array[index].getID()+"\n";
		return str;
		
	}
	

	/*
	 * Return average grade of the class.
	 * @return a string of the average grade of the class.
	 */
	public String average() {
		double avg = 0;
		for(int i=0; i<noOfStudents; i++) {
			avg += array[i].getGrade();
		}
		avg /= noOfStudents;
	    String str = "Average grade of the class is : "+avg ; 
	    return str;
	}
	
	/*
	 * return the no. of students in the StudentContainer.
	 * @return the no. of students in the StudentContainer.
	 */
	public int size() {
		return noOfStudents;
	}
	
	/*
	 * return a Student object at a specified index.
	 * @param index index of the Student object to be returned.
	 * @return a Student object at a specified index.
	 */
	public Student get(int index) {
		if(index<0 || index>=noOfStudents) {
			throw new IllegalArgumentException("Invalid index");
		}
		return array[index];
	}
	
	/*
	 * return the state of the StudentContainer.
	 * @return state of the StudentContainer object.
	 */
	public String toString() {
		String str = "";
		if(noOfStudents == 0) {
			str = "No record found";
		}
	    str = noOfStudents + "\n";
		for(int i=0; i<noOfStudents; i++) {
			str += array[i]+" \n" ;
		}
		str += " ";
		return str;
	}

}
