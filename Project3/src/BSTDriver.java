/**
 * Driver program to allow command line user to interface with the BST class.
 * 
 * Project 3
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/11/02
 * 
 * @see BST
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BSTDriver
{
	/**
	 * Runs the program.
	 */
	public static void main(String...strings)
	{
		//Console input
		Scanner in = new Scanner(System.in);
		//Tree to store the inputs
		BST<Integer> tree = new BST<Integer>();
		System.out.println("Choose one of the following operations by entering provided letter:");
		System.out.println("a - add the element");
		System.out.println("d - delete the element");
		System.out.println("f - find the element");
		System.out.println("e - check if the tree is empty");
		System.out.println("k - make the tree empty");
		System.out.println("n - get the number of nodes (the size) of the tree");
		System.out.println("m - find the minimal element");
		System.out.println("x - find the maximal element");
		System.out.println("p - print the tree in preorder using iterator");
		System.out.println("i - print the tree in inorder using iterator");
		System.out.println("l - print the tree in levelorder using iterator");
		System.out.println("t - print the tree using printTree");
		System.out.println("o - output the tree using toString");
		System.out.println("q - Quit the program");
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
					// Value to be inserted into the tree
					int newVal = in.nextInt();
					tree.insert(newVal);
					System.out.println(newVal+" inserted");
					in.nextLine();
					break;
				case 'd':
					try
					{
						System.out.println("Enter a value:");
						// Value to be deleted from the tree
						int oldVal = in.nextInt();
						tree.delete(oldVal);
						System.out.println(oldVal+" deleted");
						in.nextLine();
					}
					catch (NoSuchElementException nsee)
					{
					}
					break;
				case 'f':
					System.out.println("Enter a value:");
					// Value to be found (or not) in the tree
					int findVal = in.nextInt();
					System.out.println(findVal+(tree.find(findVal)? " is in the tree":" is not in the tree"));
					in.nextLine();
					break;
				case 'e':
					System.out.println(tree.isEmpty()? "tree is empty":"tree is not empty");
					break;
				case 'k':
					tree.makeEmpty();
					System.out.println("tree is now empty");
					break;
				case 'n':
					System.out.println("there are "+tree.size()+" nodes in the tree");
					break;
				case 'm':
					try
					{
						System.out.println("the minimum element is "+tree.findMinimum());
					}
					catch (BST.MyException me)
					{
						System.out.println("Tree is empty");
					}
					break;
				case 'x':
					try
					{
						System.out.println("the maximum element is "+tree.findMaximum());
					}
					catch (BST.MyException me)
					{
						System.out.println("Tree is empty");
					}
					break;
				case 'p':
					// Iterator that gets each element in pre-order
					Iterator<Integer> preIter = tree.iteratorPre();
					while (preIter.hasNext())
					{
						System.out.print(preIter.next()+(preIter.hasNext()?" ":""));
					}
					System.out.println();
					break;
				case 'i':
					// Iterator that gets each element in in-order
					Iterator<Integer> inIter = tree.iteratorIn();
					while (inIter.hasNext())
					{
						System.out.print(inIter.next()+(inIter.hasNext()?" ":""));
					}
					System.out.println();
					break;
				case 'l':
					// Iterator that gets each element in level-order
					Iterator<Integer> lvlIter = tree.iteratorLevel();
					while (lvlIter.hasNext())
					{
						System.out.print(lvlIter.next()+(lvlIter.hasNext()?" ":""));
					}
					System.out.println();
					break;
				case 't':
					tree.printTree();
					break;
				case 'o':
					System.out.println(tree);
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
	}
}
