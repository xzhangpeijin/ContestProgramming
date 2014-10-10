package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest154C
{
	public Contest154C() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		int lines = Integer.parseInt(in.readLine());
		
		int[] lengths = new int[lines];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int x = 0; x < lines; x++)
			lengths[x] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		f.write(String.valueOf(numKeys(lengths, r1, c1, r2, c2, 0, false, false)));
		f.flush();
		f.close();
	}
	
	public int numKeys(int[] lengths, int r1, int c1, int r2, int c2, int total, boolean rev1, boolean rev2)
	{
		if(r1 == r2)
			return Math.abs(c2 - c1) + total;
		if(c1 <= c2 || (rev1 && rev2))
		{
			if(r1 > r2)
				r1--;
			else
				r1++;

			c1 = Math.min(c1, lengths[r1 - 1] + 1);
			total++;
			return numKeys(lengths, r1, c1, r2, c2, total, rev1, rev2);
		}
		else if(r1 == 1 || r1 == lengths.length)
		{
			total += c1 - c2;
			c1 = c2;
			return numKeys(lengths, r1, c1, r2, c2, total, rev1, rev2);
		}
		else
		{
			c1 = Math.min(c1, lengths[r1 - 1] + 1);
			if(r1 > r2)
			{
//				return Math.min(numKeys(lengths, r1, c1, r2, c2, total, true, rev2));
			}
		}
		return 0;
	}
	public static void main(String[] args) throws Exception
	{
		new Contest154C();
	}
}
