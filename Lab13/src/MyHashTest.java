import java.util.Iterator;
import java.util.Scanner;


public class MyHashTest
{
	public static void main(String... args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Give me a size for the hash table!");
		MyHashTable<Integer> table = new MyHashTable<Integer>(in.nextInt());
		in.nextLine();
		System.out.println("Options:");
		System.out.println("\"a\" -\tAdd to table");
		System.out.println("\"f\" -\tFind in table");
		System.out.println("\"d\" -\tDelete from table");
		System.out.println("\"e\" -\tIs table empty");
		System.out.println("\"p\" -\tPrint the table");
		System.out.println("\"k\" -\tMake table empty");
		System.out.println("\"s\" -\tPrint table size");
		System.out.println("\"o\" -\tOutput entire collection");
		System.out.println("\"q\" -\tQuit");
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
					System.out.println("Enter an integer to insert.");
					if (in.hasNextInt())
					{
						int newVal = in.nextInt();
						table.insert(newVal);
						System.out.println(newVal+" added");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'f':
					System.out.println("Enter an integer to find.");
					if (in.hasNextInt())
					{
						int val = in.nextInt();
						System.out.println(val+(table.find(val)? " found":" not found"));
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
						int val = in.nextInt();
						table.delete(val);
						System.out.println(val+" deleted");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'e':
					System.out.println(table.isEmpty()? "Empty":"Not Empty");
					break;
				case 'p':
					table.print();
					break;
				case 'k':
					table.makeEmpty();
					System.out.println("Table is now empty.");
					break;
				case 's':
					System.out.println(table.size()+" elements in collection");
					break;
				case 'o':
					Iterator<Integer> iter = table.iterator();
					while (iter.hasNext())
					{
						System.out.print(iter.next()+" ");
					}
					System.out.println();
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
}
