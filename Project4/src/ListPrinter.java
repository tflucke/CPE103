/**
 * Reads student information from a file, ignoring invalid lines, and prints them in ascending order by id.
 * Inputs must be one-per-line, formatted as such: "[id] [last name]"
 * 
 * Project 2
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/22
 * 
 * @see Student
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class ListPrinter 
{
	/**
	 * Runs the program.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//Console input
		Scanner in = new Scanner(System.in);
	
		System.out.println("Salutations. Please enter the file name to be read.");

		//File input
		Scanner fileIn = new Scanner(new File(in.nextLine()));
		
		int N = fileIn.nextInt();
		HashTable table = new HashTable(N);
		fileIn.nextLine();
		
		while (N-- > 0)
		{
			Student newStud = readStudent(fileIn.nextLine());
			if (newStud != null)
			{
				table.insert(newStud);
			}
		}
		fileIn.close();
		
		System.out.println("Choose one of the following operations:");
		System.out.println("a - add the element");
		System.out.println("d - delete the element");
		System.out.println("f - find and retrieve the element");
		System.out.println("n - get the number of elements in the collection");
		System.out.println("e - check if the collection is empty");
		System.out.println("k - make the hash table empty");
		System.out.println("p - print the content of the hash table");
		System.out.println("o - output the elements of the collection");
		System.out.println("q - Quit the program");
		//Remains true as long as the user doesn't quit.
		boolean running = true;
		while (running)
		{
			System.out.println("Enter a menu choice: ");
			//The current line which should contain the command
			String line = in.nextLine();
			if (line.length() != 1)
			{
				System.out.println("Invalid choice");
				continue;
			}
			//The one character command inputed
			char command = line.charAt(0);
			switch (command)
			{
				case 'a':
					System.out.println("Enter two values representing the student record");
					String newVal = in.nextLine();
					Student newStud = readStudent(newVal);
					if(newStud == null)
					{
						System.out.println("Invalid Input");
					}
					else
					{
						table.insert(newStud);
					}
					break;
					
				case 'd':
					System.out.println("Enter ONE value to be deleted.(long, positivevalues)");
					long id;
					if(in.hasNextLong() && (id = in.nextLong()) > 0)
					{
						Student dummyStudent = new Student(id, "lastName");
						table.delete(dummyStudent);
						System.out.println(String.format("Student with id %d has been deleted", id));
					}
					else
					{
						System.out.println("Invalid Input");
					}
					break;
					
				case 'f':
					System.out.println("insert the id number to be found");
					long findId;
					if(in.hasNextLong() && (findId = in.nextLong()) > 0)
					{
						Student dummyStudent = new Student(findId, "lastName");
						table.find(dummyStudent);
						
						Student findStudent = (Student)table.find(dummyStudent);
						System.out.println(findStudent != null? String.format("Student with id %d has been found", findId):"Student not found");
						
					}
					else
					{
						System.out.println("Invalid Input");
					}
					break;
					
				case 'p':
					table.printTable();
					break;
					
				case 'o':
					@SuppressWarnings("rawtypes")
					Iterator tableIter = table.iterator();
					while(tableIter.hasNext())
					{
						System.out.println(tableIter.next());
					}
					break;
					
				case 'q':
					running = false;
					System.out.println("Farewell");
					break;
				default:
					System.out.println("Invalid Option.");
			}
		}
		in.close();
	}
	/**
	 * Helper method to determine whether or not the line inputted is a valid student
	 * @param line
	 * @return a student if valid or null if it is an invalid line
	 */
	private static Student readStudent(String line)
	{
		//Defines the format for what a (non-negative) long value looks like
		final String longFormat = "^\\+?\\d+$";
		
		//Breaks the input line into whitespace separated parts
		String[] inputLineParts = line.split("\\s");
		if(inputLineParts.length == 2 && inputLineParts[0].matches(longFormat))
		{
			return new Student(Long.parseLong(inputLineParts[0]), inputLineParts[1]);
		}
		return null;
	}
}
