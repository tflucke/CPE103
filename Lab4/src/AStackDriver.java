import java.util.Scanner;

public class AStackDriver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AStack<Integer> stack = new AStack<Integer>(5);
		printHelp();
		boolean running = true;
		while (running)
		{
			String line = in.nextLine();
			if (line.length() != 1)
			{
				System.out.println("Invalid Option.");
				//printHelp();
				continue;
			}
			char command = line.charAt(0);
			switch (command)
			{
				case 'a':
					System.out.println("Enter an integer.");
					if (in.hasNextInt())
					{
						int newVal = in.nextInt();
						stack.push(newVal);
						System.out.println(newVal+" Pushed");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'd':
					try
					{
						System.out.println(stack.pop() +" Poped");
					}
					catch (AStack.MyException me)
					{
						System.out.println("Invalid operation.  Stack is empty.");
					}
					break;
				case 'p':
					try
					{
						System.out.println(stack.peek() +" Peeked");
					}
					catch (AStack.MyException me)
					{
						System.out.println("Invalid operation.  Stack is empty.");
					}
					break;
				case 'e':
					System.out.println(stack.isEmpty()? "Empty":"Not Empty");
					break;
				case 'q':
					running = false;
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Invalid Option.");
					//printHelp();
			}
		}
		while (!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
	
	public static void printHelp()
	{
		System.out.println("Options:");
		System.out.println("\"a\" -\tPush to Stack");
		System.out.println("\"d\" -\tPop from Stack");
		System.out.println("\"p\" -\tPeek");
		System.out.println("\"e\" -\tCheck if Stack is empty");
		System.out.println("\"q\" -\tQuit");
	}

}
