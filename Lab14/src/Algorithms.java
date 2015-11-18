
public class Algorithms {

	public static void linearAlgorithm(long N)
	{
		for(long x = 1; x <= N; x++)
		{
			long i = 1;
		}
	}
	
	public static void quadraticAlgorithm(long N)
	{
		for(long i = 1; i <= N; i++)
		{
			for(long j = 1; j <= N; j++)
			{
				long x = 1;
			}
		}
	}
	
	public static void logarithmicAlgorithm(long N)
	{
		for (long i = N; i >= 1; i/=2)
		{
			long x = 1;
		}
	}
	
	public static void NlogNAlgorithm(long N)
	{
		for (long i = 1; i <= N; i++)
		{
			for(long j = N; j >= 1; j/=2)
			{
				long x = 1;
			}
		}
	}
	
}
