package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class A182
{
	public static void main(String[] args)
	{
		new A182();
	}
	
	public A182()
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		int[] data = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		for(int x = 0; x < 2 * n - 1; x++)
			data[x] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(data);

	}
	
}
