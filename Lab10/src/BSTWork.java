import java.util.Scanner;


public class BSTWork {
	public static void main(String... args)
	{
		BasicBST tree = new BasicBST();
		System.out.println("Options:");
		System.out.println("\"a\" -\tAdd to Tree");
		System.out.println("\"o\" -\tCount number of odds");
		System.out.println("\"e\" -\tHeight of tree");
		System.out.println("\"t\" -\tCount Leaves");
		System.out.println("\"c\" -\tOne Child Nodes");
		System.out.println("\"q\" -\tQuit");
		Scanner in = new Scanner(System.in);
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
						tree.insert(newVal);
						System.out.println(newVal+" added");
					}
					else
					{
						System.out.println("Not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'o':
					System.out.println("Tree has "+tree.countOdds()+" odd integers.");
					break;
				case 'h':
					System.out.println("Tree has "+tree.height()+" levels.");
					break;
				case 'l':
					System.out.println("Tree has "+tree.countLeaves()+" leaves.");
					break;
				case 'c':
					System.out.println("Tree has "+tree.countOneChildParents()+" parents with one child.");
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
