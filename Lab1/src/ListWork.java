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
		
		Scanner scannerRead = new Scanner(System.in);
		scannerRead.useDelimiter("\\s+");
		int index = 0;
		while (index < 10)
		{
			while (!scannerRead.hasNext());
			try
			{
				intArray[index] = Integer.parseInt(scannerRead.next());
		    	index ++;
			}
			catch (NumberFormatException nfe)
			{
				
			}
		}
			scannerRead.nextLine();
		
		System.out.println("Would you like to search through this array? (y/n)");
		while(true) //()
		{
			String input = scannerRead.next(); 
			if (input.equalsIgnoreCase("N"))
			{
				break;
			}
			else if (input.equalsIgnoreCase("Y"))
			{
				System.out.println("What would you like to search for?");

				try
				{
					boolean res = search(intArray, Integer.parseInt(scannerRead.next()));
					System.out.println(res? "Found":"Not Found");
				}
				catch (NumberFormatException nfe)
				{
					System.out.println("Not a valid entry");
				}
				System.out.println("Would you like to search through this array again? (y/n)");
				scannerRead.nextLine();
			}
			else
			{
				System.out.println("Invalid input, please try \"y\" or \"n\".");
			}
		}
		scannerRead.close();
		print(intArray);
	}
	
}
