/**
 * A class containing methods for manipulating postfix expressions.
 * 
 * Project 1
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/07
 */
import java.util.Scanner;

public class Converter
{
	/**
	 * Converts an infix expression to postfix notation
	 * @return The postfix expression as a space separated character string
	 */
	public static String infixToPostfix (String expression)
	{
		MyStack<Character> operatorStack = new MyStack<Character>(); // Creates stack in which to store operators
		Scanner in = new Scanner(expression); // class to read from console
		String output = new String(); // creates string to be used as output
		while (in.hasNext())
		{
			String num = in.next(); // used to print the number if it is not an operator
			char operator = num.charAt(0); // switchable operator
			if (operator == '+' || operator == '-' || operator == '(')
			{
				operatorStack.push(operator);
			}
			else if (operator == '*' || operator == '/')
			{
				char nextOperator = operatorStack.peek();
				while (!(nextOperator == '+' || nextOperator == '-' || nextOperator == '('))
				{
					output += operatorStack.pop() + " ";
				}
				operatorStack.push(operator);
			}
			else if (operator == ')')
			{
				while (operatorStack.peek() != '(')
				{
					output += operatorStack.pop() + " ";
				}
				operatorStack.pop();
			}
			else
			{
				output += num + " ";	
			}
		}
		in.close();
		while (!operatorStack.isEmpty())
		{
			output += operatorStack.pop() + " ";
		}
		return output.trim();
	}

	/**
	 * Evaluates a postfix expression into a double value.
	 * @return The double value derived from the postfix expression
	 */
	public static double postfixValue (String expression)
	{
		MyStack<Double> valueStack = new MyStack<Double>(); // create a stack in which to load doubles to be evaluated
		Scanner in = new Scanner(expression); // class to read from console
		while (in.hasNext())
		{
			if (in.hasNextDouble())
			{
				valueStack.push(in.nextDouble());
			}
			else
			{
				double tmp; // used for order-sensitive operations ( "-" & "/")
				switch (in.next().charAt(0))
				{
					case '+':
						valueStack.push(valueStack.pop() + valueStack.pop());
						break;
					case '-':
						tmp = valueStack.pop();
						valueStack.push(valueStack.pop() - tmp);
						break;
					case '*':
						valueStack.push(valueStack.pop() * valueStack.pop());
						break;
					case '/':
						tmp = valueStack.pop();
						valueStack.push(valueStack.pop() / tmp);
						break;
				}
			}
		}
		in.close();
		return valueStack.pop();
	}
}
