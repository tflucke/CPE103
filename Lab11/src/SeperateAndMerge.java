import java.util.Iterator;
import java.util.Scanner;


public class SeperateAndMerge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LList<Integer> listInt = new LList<Integer>();
		LList<Float> listFloat = new LList<Float>();
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			if (in.hasNextInt())
			{
				listInt.add(in.nextInt());
			}
			else if (in.hasNextFloat())
			{
				listFloat.add(in.nextFloat());
			}
			else
			{
				in.next();
			}
		}
		in.close();
		System.out.print("Inputted values:");
		Iterator<Integer> intIter = listInt.iterator();
		Iterator<Float> fltIter = listFloat.iterator();
		while (intIter.hasNext() && fltIter.hasNext())
		{
			System.out.print(" ");
			System.out.print(intIter.next());
			System.out.print(" ");
			System.out.print(fltIter.next());
		}
		while (intIter.hasNext())
		{
			System.out.print(" ");
			System.out.print(intIter.next());
		}
		while (fltIter.hasNext())
		{
			System.out.print(" ");
			System.out.print(fltIter.next());
		}
		System.out.println();
	}

}
