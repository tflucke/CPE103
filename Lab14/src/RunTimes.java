
public class RunTimes {

	
	public static void main(String args[])
	{
		long systemTime;
		System.out.println("Logarithmic algorithm\'s running times:");
		
		for(long N = 10000; N < 100000000; N *= 2)
		{
			systemTime = System.nanoTime()/100000;
			Algorithms.logarithmicAlgorithm(N);
			long systemUpdate = System.nanoTime()/100000;
			long runningTime = systemUpdate - systemTime;
			
			System.out.println("T(" + N + ") = " + runningTime);
		}
		System.out.println();
		
		System.out.println("Linear algorithm\'s running times:");
		
		for(long N = 10000; N < 100000000; N *= 2)
		{
			systemTime = System.nanoTime()/100000;
			Algorithms.linearAlgorithm(N);
			long systemUpdate = System.nanoTime()/100000;
			long runningTime = systemUpdate - systemTime;
			
			System.out.println("T(" + N + ") = " + runningTime);
		}
		System.out.println();
		
		System.out.println("NlogN algorithm\'s running times:");
		
		for(long N = 10000; N < 100000000; N *= 2)
		{
			systemTime = System.nanoTime()/100000;
			Algorithms.NlogNAlgorithm(N);
			long systemUpdate = System.nanoTime()/100000;
			long runningTime = systemUpdate - systemTime;
			
			System.out.println("T(" + N + ") = " + runningTime);
		}
		System.out.println();
		
		System.out.println("Quadratic algorithm\'s running times:");
		
		for(long N = 10000; N < 800000; N *= 2)
		{
			systemTime = System.nanoTime()/100000;
			Algorithms.quadraticAlgorithm(N);
			long systemUpdate = System.nanoTime()/100000;
			long runningTime = systemUpdate - systemTime;
			
			System.out.println("T(" + N + ") = " + runningTime);
		}
	
	}
	
}
