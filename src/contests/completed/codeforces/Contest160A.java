package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest160A
{
	public static void main(String[] args)
	{
		new Contest160A();
	}
	
	public Contest160A()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int num = Integer.parseInt(st.nextToken());
		int thres = Integer.parseInt(st.nextToken());
		int total = 0;
		
		st = new StringTokenizer(in.nextLine());
		
		for(int x = 0; x < num; x++)
		{
			if(checkTru(st.nextToken(), thres))
				total++;
		}
		
		System.out.println(total);
	}
	
	public boolean checkTru(String val, int thres)
	{
		int count = 0;
		for(int x = 0; x < val.length(); x++)
			if(val.charAt(x) == '4' || val.charAt(x) == '7')
				count++;
		
		return (count <= thres);
	}
}
