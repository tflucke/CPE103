/**
 * Driver program to allow command line user to interface with the Converter methods.
 * 
 * Project 1
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/07
 * 
 * @see Converter
 */
import java.util.EmptyStackException;
import java.util.Scanner;

public class ConTest
{
	/**
	 * Runs the program.
	 */
	public static void main(String... args)
	{
		Scanner in = new Scanner(System.in); // class to read from the console
		System.out.println("Choose one of the following operations:");
		System.out.println("- Infix to postfix conversion (enter the letter i)");
		//We removed the "," from p because none of the other options had it.
		System.out.println("- Postfix expression evaluation (enter the letter p)");
		System.out.println("- Arithmetic expression evaluation (enter the letter a)");
		System.out.println("- Quit the program (enter the letter q)");
		System.out.println("Please insert a menu choice.");
		String line; // variable to store the read input by line
		while (!(line = in.nextLine()).equals("q"))
		{
			if (line.length() != 1)
			{
				System.out.println("Invalid choice");
			}
			char option = line.charAt(0); // stores option to be read in switch statement 
			try
			{
				switch (option)
				{
				case 'i':
					System.out.println("Please enter the infix expression to be converted to postfix: ");
					System.out.println("the postfix expression is: "+Converter.infixToPostfix(in.nextLine()));
					break;
				case 'p':
					System.out.println("Please enter the postfix expression to be evaluated: ");
					System.out.println("the value of the postfix expression is: "+Converter.postfixValue(in.nextLine()));
					break;
				case 'a':
					System.out.println("Please enter the arithmetic expression to be evaluated: ");
					System.out.println("the value of the arithmetic expression is: "+Converter.postfixValue(Converter.infixToPostfix(in.nextLine())));
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
