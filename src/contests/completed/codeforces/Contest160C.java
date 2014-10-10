package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest160C
{
	public static void main(String[] args)
	{
		new Contest160C();
	}
	
	public Contest160C()
	{
		Scanner in = new Scanner(System.in);
		
		int disc = Integer.parseInt(in.nextLine());
		StringTokenizer st = new StringTokenizer(in.nextLine());
		int[] discounts = new int[disc];
		for(int x = 0; x < disc; x++)
			discounts[x] = Integer.parseInt(st.nextToken());
		
		int items = Integer.parseInt(in.nextLine());
		st = new StringTokenizer(in.nextLine());
		int[] prices = new int[items];
		for(int x = 0; x < items; x++)
			prices[x] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(discounts);
		Arrays.sort(prices);
		
		int index = items - 1;
		int total = 0;
		
		while(index >= discounts[0])
		{
			for(int x = 0; x < discounts[0]; x++)
				total += prices[index - x];
			index -= discounts[0] + 2;
		}
		
		for(int x = 0; x <= index; x++)
			total += prices[x];

		System.out.println(total);
	}
	

}
