import java.io.InputStreamReader;
import java.util.Scanner;


public class ListWork 
{
	
	public static <T> boolean search(T[] arr, T target)
	{
		for (T x: arr)
		{
			if(x.equals(target))
			{
				return true;
			}
		}
		return false;
	}
	
	public static <T> void print (T[] arr)
	{
		for(T x: arr)
		{
			System.out.println(x);
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] intArray = new Integer[10];
		
		System.out.println("Please input values (at least 10 integers) for this lab project!");
		
		Scanner scannerRead = new Scanner(new InputStreamReader(System.in));
		int index = 0;
		while (index < 10)
		{
			while (!scannerRead.hasNext("\\s"));
			try
			{
				intArray[index] = Integer.parseInt(scannerRead.next("\\s"));
		    	index ++;
			}
			catch (NumberFormatException nfe)
			{
				
			}
		}
		if (scannerRead.hasNextLine())
		{
			scannerRead.nextLine();
		}
		
		System.out.println("Would you like to search through this array? (y/n)");
		while (scannerRead.nextLine().equalsIgnoreCase("Y"))
		{
			System.out.println("What would you like to search for?");

			try
			{
				boolean res = search(intArray, Integer.parseInt(scannerRead.next("\\s")));
				System.out.println(res? "Found":"Not Found");
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Not a valid entry");
			}
			System.out.println("Would you like to search through this array again? (y/n)");
		}
		scannerRead.close();
		print(intArray);
	}
	
}
