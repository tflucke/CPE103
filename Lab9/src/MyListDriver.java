import java.util.Scanner;

public class MyListDriver 
{
	
	public static void main(String[] args)
	{
		MySortedList myList = new MySortedList();
		Scanner in = new Scanner(System.in);
		printHelp();
		boolean running = true;
		while (running)
		{   System.out.println("Enter a menu choice: ");
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
					System.out.println("Enter an integer to add.");
					if (in.hasNextInt())
					{
						int newVal = in.nextInt();
						myList.add(newVal);
						System.out.println(newVal+" added");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'd':
					System.out.println("Enter an integer to delete.");
					if (in.hasNextInt())
					{
						int newVal = in.nextInt();
						myList.delete(newVal);
						System.out.println(newVal+" delete");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'x':
					if (myList.isEmpty())
					{
						System.err.println("List is empty. No max found.");
						continue;
					}
					System.out.println("The max value is: " + myList.max());
					break;
				case 'm':
					if (myList.isEmpty())
					{
						System.err.println("List is empty. No min found.");
						continue;
					}
					System.out.println("The min value is: " + myList.min());
					break;
				case 'e':
					System.out.println(myList.isEmpty()? "Empty":"Not Empty");
					break;
				case 'p':
					myList.print();
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
	}
	
	public static void printHelp()
	{
		System.out.println("Options:");
		System.out.println("\"a\" -\tAdd to List");
		System.out.println("\"d\" -\tRemove from List");
		System.out.println("\"x\" -\tChecks for max");
		System.out.println("\"m\" -\tChecks for min");
		System.out.println("\"e\" -\tCheck if List is empty");
		System.out.println("\"p\" -\tPrint");
		System.out.println("\"q\" -\tQuit");
	}
		
}
