/**
 * Driver program to allow command line user to interface with a MyStack instance.
 * 
 * Project 1
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/07
 * 
 * @see MyStack
 */
import java.util.EmptyStackException;
import java.util.Scanner;

public class StackTest
{
	/**
	 * Runs the program.
	 */
	public static void main(String... args)
	{
		Scanner in = new Scanner(System.in); // class to read from console
		MyStack<String> stack = new MyStack<String>(); // initializes stack to manipulate inputs onto
		System.out.println("Choose one of the following operations:");
		System.out.println("- push/add (enter the letter a)");
		System.out.println("- pop/delete (enter the letter d)");
		System.out.println("- peek (enter the letter p)");
		System.out.println("- check if the list is empty (enter the letter e)");
		System.out.println("- Quit (enter the letter q)");
		String line; // variable to store the read input by line
		System.out.println("Please insert a menu choice.");
		while (!(line = in.nextLine()).equals("q"))
		{
			if (line.length() != 1)
			{
				System.out.println("Invalid choice");
			}
			char option = line.charAt(0);; // stores option to be read in switch statement 
			try
			{
				switch (option)
				{
				case 'a':
					String pushed = in.nextLine(); // saves next input to be pushed onto the stack
					stack.push(pushed);
					System.out.println(pushed+" pushed in");
					break;
				case 'd':
					System.out.println(stack.pop()+" popped out");
					break;
				case 'p':
					System.out.println(stack.peek()+" on the top");
					break;
				case 'e':
					System.out.println(stack.isEmpty()? "empty":"not empty");
					break;
					default:
						System.out.println("Invalid choice");
				}
			}
			catch (EmptyStackException ese)
			{
				System.out.println("Invalid operation on an empty stack");	
			}
			System.out.println("Please insert a menu choice.");
		}
		System.out.println("quitting");
		in.close();
	}
}
