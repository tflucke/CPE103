import java.util.Arrays;
import java.util.Scanner;


public class DIGraphTest
{
	public static void main(String... args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Vertex Count:");
		DIGraphAM graph = new DIGraphAM(in.nextInt());
		in.nextLine();
		System.out.println("Options:");
		System.out.println("\"a\" -\tAdd Edge");
		System.out.println("\"d\" -\tRemove Edge");
		System.out.println("\"e\" -\tCount Edges");
		System.out.println("\"V\" -\tCount Verticies");
		System.out.println("\"p\" -\tPrint");
		System.out.println("\"t\" -\tTopological Sort");
		System.out.println("\"q\" -\tQuit");
		boolean running = true;
		while (running)
		{
			System.out.print("Command: ");
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
					System.out.println("Enter two integers:");
					if (in.hasNextInt())
					{
						int from = in.nextInt();
						if (in.hasNextInt())
						{
							int to = in.nextInt();
							graph.addEdge(from, to);
							System.out.println(from+" linked to "+to);
						}
						else
						{
							System.out.println("Second value not an integer.  No action taken.");
						}
					}
					else
					{
						System.out.println("First value not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'd':
					System.out.println("Enter two integers:");
					if (in.hasNextInt())
					{
						int from = in.nextInt();
						if (in.hasNextInt())
						{
							int to = in.nextInt();
							graph.deleteEdge(from, to);
							System.out.println(from+" unlinked to "+to);
						}
						else
						{
							System.out.println("Second value not an integer.  No action taken.");
						}
					}
					else
					{
						System.out.println("First value not an integer.  No action taken.");
					}
					in.nextLine();
					break;
				case 'e':
					System.out.println("Edge Count: "+graph.edgeCount());
					break;
				case 'v':
					System.out.println("Vertex Count: "+graph.vertexCount());
					break;
				case 'p':
					graph.print();
					break;
				case 't':
					try
					{
						System.out.println(Arrays.toString(graph.topSort()));
					}
					catch (Exception e)
					{
						System.out.println("Cyclic Graph");
					}
					break;
				case 'q':
					running = false;
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Invalid Option.");
			}
		}
		System.out.println();
	}
}
