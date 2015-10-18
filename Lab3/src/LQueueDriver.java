import java.util.Scanner;

public class LQueueDriver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LQueue<Integer> queue = new LQueue<Integer>();
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
						queue.enqueue(newVal);
						System.out.println(newVal+" enqueued");
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
						System.out.println(queue.dequeue() +" dequeued");
					}
					catch (LQueue.MyException me)
					{
						System.out.println("Invalid operation.  Queue is empty.");
					}
					break;
				case 'e':
					System.out.println(queue.isEmpty()? "Empty":"Not Empty");
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
		while (!queue.isEmpty())
		{
			System.out.print(queue.dequeue()+" ");
		}
		System.out.println();
	}
	
	public static void printHelp()
	{
		System.out.println("Options:");
		System.out.println("\"a\" -\tAdd to Queue");
		System.out.println("\"d\" -\tRemove from Queue");
		System.out.println("\"e\" -\tCheck if Queue is empty");
		System.out.println("\"q\" -\tQuit");
	}

}
