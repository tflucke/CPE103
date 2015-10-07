import java.util.Scanner;



public class StringChecker 
{

	public static boolean isBalanced(String input)
	{
		AStack<Character> charStack = new AStack<Character>(5);
		try
		{
			for (int i = 0; i < input.length(); i++)
			{
				char c = input.charAt(i);
				
				switch(c)
				{
					case '{':
					case '(':
					case '[':
						charStack.push(c);
						break;
					case '}':
						if (charStack.pop() != '{')
						{
							return false;
						}
						break;
					case ')':
						if (charStack.pop() != '(')
						{
							return false;
						}
						break;
					case ']':
						if (charStack.pop() != '[')
						{
							return false;
						}
						break;
				}
			}
		}
		catch (AStack.MyException me)
		{
			return false;
		}
		return charStack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		System.out.println("Hey baby. Can you please give me a string to check? :)");
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine())
		{
			System.out.println(isBalanced(in.nextLine())? "Congrats, your string is indeed balanced (:" : 
														  "I'm sorry, but you suck at balancing strings ):");
		}
		
	}
}
