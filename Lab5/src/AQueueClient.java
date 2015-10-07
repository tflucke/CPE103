import java.util.Scanner;

public class AQueueClient 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		AQueue<Float> floatArr =  new AQueue<Float>(5);

		while(input.hasNext())
		{
			if(input.hasNextFloat())
			{
				floatArr.enqueue(input.nextFloat());
			}
			else
			{
				input.next();
			}
		}
		
		while (!floatArr.isEmpty())
		{
			System.out.print(floatArr.dequeue() + " ");
		}
		
		System.out.println();
		
	}
}
