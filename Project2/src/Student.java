/**
 * Stores student id and last name in a sortable way.
 * 
 * Project 2
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/22
 */

public class Student implements Comparable<Student> 
{
	/**
	 * The student's id
	 */
	private long id;
	
	/**
	 * The student's last name
	 */
	private String lastName;
	
	/**
	 * Creates a new student object with he given id and last name
	 * @param id The student's id number
	 * @param lastName The student's last name
	 */
	public Student(long id, String lastName)
	{
		this.id = id;
		this.lastName = lastName;
	}
	
	/**
	 * Compares this student to another by id. 
	 * @return 1 if this student's id is greater, -1 if it is less, or 0 if they are equal
	 */
	public int compareTo(Student other)
	{
		if(this.id > other.id)
		{
			return 1;
		}
		else if (this.id < other.id)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Creates a string representation of the student object.
	 * The string will be in the format: "{ id: [id], name: [last name] }".
	 * @return The string representation of the student.
	 */
	@Override
	public String toString()
	{
		return String.format("{ id: %d, name: %s }", this.id, this.lastName);
	}

}
