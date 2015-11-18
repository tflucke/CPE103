import java.util.Scanner;


public class ArraySummer 
{
	
	public static int arraySum(int[] arr, int first)
	{
		if(first > arr.length - 1)
		{
			return 0;
		}
		return(arr[first] + arraySum(arr, ++first));
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
		
		System.out.println("The sum of the integers is:" + arraySum(arr, 0));
		
		
	}
	
}

