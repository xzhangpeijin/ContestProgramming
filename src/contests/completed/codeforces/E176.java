package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class E176
{
	public static void main(String[] args)
	{
		new E176();
	}
	
	public E176()
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		
		if(n % 2 == 1)
			System.out.println("NO");
		else
		{
			int[] arr = new int[n];

			StringTokenizer st = new StringTokenizer(in.nextLine());

			for(int x = 0; x < n; x++)
				arr[x] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.nextLine());

			int t = Integer.parseInt(st.nextToken());
			boolean possible = true;
			int[] neg = new int[n];
			for(int x = 0; x < t; x++)
			{
				int index = Integer.parseInt(st.nextToken());
				neg[index - 1] = -1;
			}
			
			for(int x = 0; x < n; x++)
			{
				if(neg[x] == 0)
				{
					if(neg[x + 1] == -1)
						
					if(neg[x + 1] == 0)
						neg[x + 1] = -1;
					else if(x < n / 2 && neg[n - x - 1] == 0)
						neg[n - x - 1] = -1;
					else
					{
						possible = false;
						break;
					}
					neg[x] = 1;
				}
			}
			if(!possible)
				System.out.println("NO");
			else
			{
				System.out.println("YES");
				for(int x = 0; x < n; x++)
					System.out.print(arr[x] * neg[x] + " ");
			}
		}
	}
}
