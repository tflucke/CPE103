
public class DIGraphAM
{
	private int[][] adjTable;
	
	public DIGraphAM(int N)
	{
		adjTable = new int[N][N];
	}
	
	public void addEdge(int from, int to)
	{
		adjTable[from][to] = 1;
	}
	
	public void deleteEdge(int from, int to)
	{
		adjTable[from][to] = 0;
	}
	
	public int edgeCount()
	{
		int count = 0;
		for (int[] links : adjTable)
		{
			for (int i : links)
			{
				count += i;
			}
		}
		return count;
	}
	
	public int vertexCount()
	{
		return adjTable.length;
	}
	
	public void print()
	{
		for (int from = 0; from < adjTable.length; from++)
		{
			System.out.print(from+" is connected to:");
			for (int to = 0; to < adjTable.length; to++)
			{
				if (adjTable[from][to] == 1)
				{
					System.out.print(" "+to);
				}
			}
			System.out.println();
		}
	}
	
	private int[] indegrees()
	{
		int[] result = new int[adjTable.length];
		for (int from = 0; from < adjTable.length; from++)
		{
			for (int to = 0; to < adjTable.length; to++)
			{
				result[to] += adjTable[from][to];
			}
		}
		return result;
	}
	
	public int[] topSort() throws Exception
	{
		int[] result = new int[adjTable.length];
		int i = 0;
		LQueue<Integer> noNeighbors = new LQueue<Integer>();
		int[] neighborCount = indegrees();
		for (int j = 0; j < neighborCount.length; j++)
		{
			if (neighborCount[j] == 0)
			{
				noNeighbors.enqueue(j);
			}
		}
		while (!noNeighbors.isEmpty())
		{
			int v = noNeighbors.dequeue();
			result[i++] = v;
			for (int from = 0; from < adjTable.length; from++)
			{
				if (adjTable[v][from] == 1 && --neighborCount[from] == 0)
				{
					noNeighbors.enqueue(from);
				}
			}
		}
		if (i != result.length)
		{
			throw new Exception();
		}
		return result;
	}
}
