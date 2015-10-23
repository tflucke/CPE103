/**
 * Driver program to allow command line user to interface with the BinHeap class.
 * 
 * Project 2
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/10/21
 * 
 * @see BinHeap
 */
import java.util.Scanner;

public class HeapTest
{
	/**
	 * Runs the program.
	 */
	public static void main(String[] args)
	{
		//Console input
		Scanner in = new Scanner(System.in);
		System.out.println("Enter heap size: ");
		//Heap to store the inputs
		BinHeap<String> heap = new BinHeap<String>(in.nextInt());
		in.nextLine();
	
		System.out.println("Choose one of the following operations:");
		System.out.println("- add an element (enter the letter a)");
		System.out.println("- delete the smallest element (enter the letter d)");
		System.out.println("- is the heap empty (enter the letter e)");
		System.out.println("- size of the collection (enter the letter s)");
		System.out.println("- Quit (enter the letter q)");
		//Remains true as long as the user doesn't quit.
		boolean running = true;
		while (running)
		{
			System.out.println("Enter a menu choice: ");
			//The current line which should contain the command
			String line = in.nextLine();
			if (line.length() != 1)
			{
				System.out.println("Invalid choice");
				continue;
			}
			//The one character command inputed
			char command = line.charAt(0);
			switch (command)
			{
				case 'a':
					System.out.println("Enter a value:");
					String newVal = in.nextLine();
					heap.insert(newVal);
					System.out.println(newVal+" inserted");
					break;
				case 'd':
					try
					{
						System.out.println(heap.deleteMin() +" deleted");
					}
					catch (BinHeap.MyException me)
					{
						System.out.println("Invalid operation on an empty heap");
					}
					break;
				case 'e':
					System.out.println(heap.isEmpty()? "heap is empty":"heap is not empty");
					break;
				case 's':
					System.out.println("the size is "+heap.size());
					break;
				case 'p':
					System.out.println(heap);
					break;
				case 'q':
					running = false;
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Invalid Option.");
			}
		}
		in.close();
		if (!heap.isEmpty())
		{
			System.out.print(heap.deleteMin());
		}
		while (!heap.isEmpty())
		{
			System.out.print(" "+heap.deleteMin());
		}
		System.out.println();
	}

}
