
 package question1;

/**
 * This class represents the collection of Student objects created in the Student class.
 * @author Lakhveer Singh
 */
public class StudentContainer{


	/*
	 * head - the head of LinkedList .
	 * noOfStudents - total no. of students in the list.
	 */
	private Node<Student> head;
	private int noOfStudents;
	

	/**
	 * No-argument constructor that creates a StudentConatiner with noOfStudents 0 and head = null
	 */
	public StudentContainer() {
		head =null;
		noOfStudents =0;
	}
	
	/**
	 * Add a student object in the StudentContainer & sort 	& save the objects in
	 * the ascending order of their grades.
	 * @param student Student object to be added in the container.
	 */
	public void add(Student student) {
		 if(head==null || head.getData().getGrade()>= student.getGrade()) 
		 {
			 head = new Node(student,head);
		 }                //place the student with the least grade at the head of the list.
		 else {
			 Node ptr = head;
			 Node new_node = new Node(student,null);
			 
			 //ptr.next!=null && ptr.next.data.grade < student.grade
			 while(ptr.getLink()!=null && ((Student) ptr.getLink().getData()).getGrade()<student.getGrade()) {
				 ptr = ptr.getLink(); //ptr = ptr.next;
			 }
			 
			 new_node.setLink(ptr.getLink()); // new_node = ptr.next;
			 ptr.setLink(new_node);           // ptr = new_node;
		 }
		 noOfStudents++;
	}
	
	/**
	 * Return a string of the student records in the descending order of their records.
	 * @return student records in the descending order of their records.
	 */
	public String descending() {
		StudentContainer record_copy = new StudentContainer();//create a new StudentContainer
        Node ptr = head;
		Node copyHead = new Node(head.getData(),null);
		Node copyTail = copyHead;
		
		while(ptr!=null){
			copyTail.setLink(new Node(ptr.getData(),null));
			copyTail = copyTail.getLink();
			record_copy.add((Student)ptr.getData());
			ptr = ptr.getLink();
		} // copy the elements into the new container 
		
		reverse(record_copy); // reverse the elements in the new container
		return record_copy+"";
		
	}
	
	/**
	 * Return a string of the maximum grade and the student who got the maximum grade. 
	 * @return a string of the maximum grade and the student who got the maximum grade.  
	 */
	public String maximum() {
		Node ptr = head;
		Node max_node = head; //set the max_node to head
		double max = head.getData().getGrade();// max grade is initially set to first element
		while(ptr!=null) {
			if(((Student) ptr.getData()).getGrade()>max) {
				max =((Student)ptr.getData()).getGrade();
				max_node = ptr;
			}
			ptr = ptr.getLink();
		}                     // compute the max_node 
        return "Maximum Grades : "+ ((Student) max_node.getData()).getGrade() +
				"\n"+ "Student Name : "+((Student)max_node.getData()).getName() + 
				"\n" + "Student ID : "+ ((Student)max_node.getData()).getID()+"\n";
	}
	
	/**
	 * Return a string of the minimum grade and the student who got the maximum grade. 
	 * @return a string of the minimum grade and the student who got the maximum grade.  
	 */
	public String minimum() {
		Node ptr = head;
		Node min_node = head;// set the min_node to head
		double min = head.getData().getGrade();// min grade is initially set to first element
		while(ptr!=null) {
			if(((Student) ptr.getData()).getGrade()<min) {
				min =((Student)ptr.getData()).getGrade();
				min_node = ptr;
				System.out.println(min_node);
			}
			ptr = ptr.getLink();
		}                      // compute the min_node
		return "Minimum Grades : " +((Student) min_node.getData()).getGrade() +
				"\n"+ "Student Name : "+((Student)min_node.getData()).getName() + 
				"\n" + "Student ID : "+ ((Student)min_node.getData()).getID()+"\n";
	}
	
	/**
	 * Return average grade of the class.
	 * @return a string of the average grade of the class.
	 */
	public String average() {
		Node ptr = head;
		double average = 0;
		while(ptr!=null) {
			average += ((Student)ptr.getData()).getGrade();
			ptr = ptr.getLink();
		}           // calculate the sum of all the grades
		average /= noOfStudents; //  the average grade of the class
		return "Average Grade of the class: " + average ;
	}
	
	/**
     * this method reverse the order of the list.
	 * @param list list to be reversed
	 */
    public void reverse(StudentContainer list) {
		
		Node previous = null;
		Node next = null;
		Node ptr = list.head;
		while(ptr!=null) {
			next = ptr.getLink();      // next = ptr.link;
			ptr.setLink(previous);     // ptr = previous;
			previous = ptr;           
			ptr = next;
		}
		
		list.head = previous;           
    }
	
    /**
     * return the no. of students in the StudentContainer.
	 * @return the no. of students in the StudentContainer.
	 */
    public int size(){
		return noOfStudents;
	}
	
	/**
     * return the state of the StudentContainer.
	 * @return state of the StudentContainer object.
	 */
	public String toString() {
		String str = "";
		if(noOfStudents == 0) {
			str = "No record found";
		}
		Node ptr = head;
		while(ptr!=null) {
			str += ptr.getData();
			if(ptr.getLink()!=null) {
				str += "\n";
			}
			ptr = ptr.getLink();
		}
		str += "";
		return str;
	}
}
 