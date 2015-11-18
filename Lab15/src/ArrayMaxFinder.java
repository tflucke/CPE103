import java.util.Scanner;


public class ArrayMaxFinder 
{
	public static int arrayMax(int[] arr, int first)
	{
		if(first == arr.length - 1)
		{
			return first;
		}
		
		else 
		{
			int index =  arrayMax(arr, first + 1);
			if(arr[first] > arr[index])
			{
				return first;
			}
			else
			{
				return index;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
				
		System.out.println("Please enter 10 integers! (:");
		int[] arr = new int[10];
		int n = 0;
		while(in.hasNextInt())
		{
			arr[n] = in.nextInt();
			n++;
		}
		
		System.out.println("The maximum value is:" + arr[arrayMax(arr, 0)]);
	}

}
