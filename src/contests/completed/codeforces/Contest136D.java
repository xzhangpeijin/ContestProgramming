package contests.completed.codeforces;
import java.util.*;

public class Contest136D
{
	public Contest136D()
	{
		Scanner in = new Scanner(System.in);
		
		int length = in.nextInt();
		int queries = in.nextInt();
		
		int[] array = new int[length];
		
		for(int x = 0; x < length; x++)
			array[x] = in.nextInt();
		
		int[][] sums = new int[length + 1][length];
		
		for(int x = 0; x < length; x++)
		{
			sums[0][x] = 0;
		}
		
		for(int x = 1; x <= length; x++)
		{
			sums[x] = (int[])sums[x - 1].clone();
			sums[x][array[x - 1] - 1]++;
		}
		
		for(int x = 0; x < queries; x++)
		{
			int start = in.nextInt() - 1;
			int end = in.nextInt();
			int total = 0;
			
			for(int a = 0; a < length; a++)
			{
				if(sums[end][a] - sums[start][a] == a + 1)
					total++;
			}
			
			System.out.println(total);
		}
	}
	
	
	public static void main(String[] args)
	{
		new Contest136D();
	}
}
