/**
 * Reads words from a file, ignoring duplicates, and prints them in ascending lexicographical order.
 * Inputs must be whitespace seperated
 * 
 * Project 3
 * 
 * @author Thomas Flucke tflucke
 * @author Lara Luu ljluu
 * 
 * @since 2015/11/2
 * 
 * @see BST
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class DictionaryMaker
{
	/**
	 * Runs the program.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//Console input
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Salutations. Please enter the file name to be read.");
		// Reads the file from the filename provided in the commnd line
		Scanner fileIn = new Scanner(new File(consoleIn.nextLine()));
		System.out.println("Please enter the file name to be outputed.");
		//Creates the file with the completed dictionary
		PrintWriter fileOut = new PrintWriter(consoleIn.nextLine());
		consoleIn.close();

		//Tree to store the words
		BST<String> wordTree = new BST<String>();
		
		while (fileIn.hasNext())
		{
			//Store the next word from the input file
			String word = fileIn.next();
			if (!wordTree.find(word))
			{
				wordTree.insert(word);
			}
		}
		fileIn.close();
		//Iteratorates over each word in lexigraphical order
		Iterator<String> wordSorted = wordTree.iteratorIn();
		while (wordSorted.hasNext())
		{
			fileOut.println(wordSorted.next());
		}
		fileOut.close();
	}
}
