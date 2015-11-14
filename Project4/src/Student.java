/**
 * Stores student id and last name in a sortable way.
 * 
 * Project 4
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/11/12
 */

public class Student
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
	
	@Override
	public boolean equals(Object other)
	{
		return other instanceof Student && id == ((Student) other).id;
	}
	/**
	 * Creates a hashcode representation for the student object.
	 * The hashcode will be taken from the student's ID number.
	 * @return long type student id
	 */
	@Override
	public int hashCode()
	{
		return new Long(id).hashCode();
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
