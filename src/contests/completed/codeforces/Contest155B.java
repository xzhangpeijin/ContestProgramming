package contests.completed.codeforces;
import java.util.*;
import java.io.*;

public class Contest155B
{
	public Contest155B() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		int[][] days = new int[12][];
		days[0] = new int[31];
		days[1] = new int[28];
		days[2] = new int[31];
		days[3] = new int[30];
		days[4] = new int[31];
		days[5] = new int[30];
		days[6] = new int[31];
		days[7] = new int[31];
		days[8] = new int[30];
		days[9] = new int[31];
		days[10] = new int[30];
		days[11] = new int[31];
		
		for(int x = 0; x < 12; x++)
			for(int y = 0; y < days[x].length; y++)
				days[x][y] = 0;
		
		int olys = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		for(int x = 0; x < olys; x++)
		{
			st = new StringTokenizer(in.readLine());
			int mon = Integer.parseInt(st.nextToken()) - 1;
			int day = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());
			int dur = Integer.parseInt(st.nextToken());
			
			for(int y = 0; y < dur; y++)
			{
				//System.out.println(mon + " " + day);
				
				day--;
				if(day < 0)
				{
					mon--;
					if(mon < 0)
						mon = 11;
					day = days[mon].length - 1;
				}
				days[mon][day] += val;
			}
		}
		
		int min = 0;
		for(int x = 0; x < 12; x++)
			for(int y = 0; y < days[x].length; y++)
				min = Math.max(days[x][y], min);
		
		//System.out.println(min);
		f.write(String.valueOf(min));
		f.flush();
		f.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest155B();
	}
}
