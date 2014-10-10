package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest154D
{
	public Contest154D() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[height][width];
		
		for(int x = 0; x < height; x++)
			grid[x] = in.readLine().toCharArray();
		
		int total = 0;
		
		for(int a = 0; a < height - 1; a++)
		{
			for(int b = 0; b < width - 1; b++)
			{
				int cur = 0;
				char val = grid[a][b];
				if(val == 'a')
					cur++;
				for(int c = b + 1; c < width; c++)
				{
					if(grid[a][c] == 'a')
						cur++;
					if(cur > k)
						c = width;
					else if(grid[a][c] == val)
					{
						for(int d = a + 1; d < height; d++)
						{
							for(int e = b; e <= c; e++)
								if(grid[d][e] == 'a')
									cur++;
							if(cur > k)
								d = height;
							else if(grid[d][b] == val && grid[d][c] == val)
							{
								total++;
							}
						}
					}
				}
			}
		}
		
		f.write(String.valueOf(total));
		f.flush();
		f.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest154D();
	}
}
