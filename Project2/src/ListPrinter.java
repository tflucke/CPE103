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
import java.util.Scanner;

public class ListPrinter 
{
	/**
	 * Runs the program.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//Console input
		Scanner consoleIn = new Scanner(System.in);
		//Min heap to store the students
		BinHeap<Student> studentHeap = new BinHeap<Student>();
	
		System.out.println("Salutations. Please enter the file name to be read.");

		//File input
		Scanner fileIn = new Scanner(new File(consoleIn.nextLine()));
		
		consoleIn.close();
		
		//Defines the format for what a (non-negative) long value looks like
		final String longFormat = "^\\+?\\d+$";
		while (fileIn.hasNextLine())
		{
			//Breaks the input line into whitespace separated parts
			String[] inputLineParts = fileIn.nextLine().split("\\s");
			if(inputLineParts.length == 2 && inputLineParts[0].matches(longFormat))
			{
				studentHeap.insert(new Student(Long.parseLong(inputLineParts[0]), inputLineParts[1]));
			}
		}
		fileIn.close();
		System.out.println("Student List: ");

		//Tracks the current student's position in the list
		int lineNum = 0;
		while (!studentHeap.isEmpty())
		{
			System.out.println(++lineNum+". "+studentHeap.deleteMin());
		}
	}
}
