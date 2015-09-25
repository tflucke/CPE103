//import java.util.Arrays;
import java.util.Scanner;


public class Separator {
	

	public static void main(String[] args) 
	{
		int n = 5;
		
		int[] intArray = new int[n];
		float[] floatArray = new float[n];
		
		System.out.println("Please input values here:");
		
		Scanner scannerRead = new Scanner(System.in);
		scannerRead.useDelimiter("\\s+");
		
		int intIndex = 0;
		int floatIndex = 0;
		
		boolean runLoop = true;
		
		while(runLoop)
		{
			if (scannerRead.hasNextInt())
			{
				if (intIndex >= n)
				{
					runLoop = false;
				}
				else
				{
					intArray[intIndex] = scannerRead.nextInt();
					intIndex++;
				}
			}
			else if (scannerRead.hasNextFloat())
			{
				if (floatIndex >= n)
				{
					runLoop = false;
				}
				else
				{
					floatArray[floatIndex] = scannerRead.nextFloat();
					floatIndex++;
				}
			}
			else
			{
				runLoop = false;
			}
			
		}
		scannerRead.close();
		System.out.println("Abort mission");
		
		System.out.print("Integers:");
		for(int x = 0; x < intIndex; x++)
		{
			System.out.print(" " + intArray[x]);
		}
		System.out.print("\nFloats:");
		for(int x = 0; x < floatIndex; x++)
		{
			System.out.print(" " + floatArray[x]);
		}		
		
	}

}
