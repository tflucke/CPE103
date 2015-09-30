import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
	
public class AStackClient {
		public static void main(String[] args) throws FileNotFoundException {
			Scanner console = new Scanner(System.in);
			System.out.println("Enter file name:");
			String fileName = console.nextLine();
			console.close();
			Scanner in = new Scanner(new FileInputStream(fileName));
			in.useDelimiter("\\s+");
			final int n = 5;
			AStack<Integer> intStack = new AStack<Integer>(n);
			AStack<Float> fltStack = new AStack<Float>(n);
			AStack<String> strStack = new AStack<String>(n);
			while (in.hasNext())
			{
				if (in.hasNextFloat())
				{
					fltStack.push(in.nextFloat());
				}
				else if (in.hasNextInt())
				{
					intStack.push(in.nextInt());
				}
				else
				{
					strStack.push(in.next());
				}
			}
			in.close();
			System.out.println("Abort mission");
			
			System.out.print("Strings:");
			while (!strStack.isEmpty())
			{
				System.out.print(" " + strStack.pop());
			}
			System.out.print("\nFloats:");
			while (!fltStack.isEmpty())
			{
				System.out.print(" " + fltStack.pop());
			}
			System.out.print("\nIntegers:");
			while (!intStack.isEmpty())
			{
				System.out.print(" " + intStack.pop());
			}
			System.out.println();
		}
}
