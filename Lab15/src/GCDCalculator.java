import java.util.Scanner;


public class GCDCalculator 
{
	public static int gcd(int x, int y)
	{
		if(x == y)
		{
			return x;
		}
		
		if(x > y)
		{
			return (gcd(x - y, y));
		}
		else
		{
			return(gcd(x, y-x));
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String running = "y";
		do
		{
			System.out.println("Please enter two inputs!");
			System.out.println("The gcd is:" + gcd(in.nextInt(), in.nextInt()));
			in.nextLine();
			System.out.println("Would you like to continue?(y/n)");
			running = in.next();
			in.nextLine();
		}
		while (running.equals("y"));
	}
}
