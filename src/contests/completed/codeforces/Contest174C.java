package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest174C
{
	public static void main(String[] args)
	{
		new Contest174C();
	}
	
	public Contest174C()
	{
		Scanner in = new Scanner(System.in);
		
		int operations = Integer.parseInt(in.nextLine());
		
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		sequence.add(new Integer(0));
		int total = 0;
		double[] results = new double[operations];
		
		for(int x = 0; x < operations; x++)
		{
			StringTokenizer st = new StringTokenizer(in.nextLine());
			
			int type = Integer.parseInt(st.nextToken());
			
			if(type == 1)
			{
				int num = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				for(int n = 0; n < num; n++)
					sequence.set(n, sequence.get(n) + val);
				total += num * val;
			}
			else if(type == 2)
			{
				sequence.add(Integer.valueOf(st.nextToken()));
				total += sequence.get(sequence.size() - 1);
			}
			else if(type == 3)
			{
				total -= sequence.remove(sequence.size() - 1);
			}
			results[x] = (double) total / (double) sequence.size();
		}
		for(int x = 0; x < operations; x++)
			System.out.println(results[x]);
	}
	

}
