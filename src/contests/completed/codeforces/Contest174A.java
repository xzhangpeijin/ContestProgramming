package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest174A
{
	public static void main(String[] args)
	{
		new Contest174A();
	}
	
	public Contest174A()
	{
		Scanner in = new Scanner(System.in);
		
		int p = Integer.parseInt(in.nextLine());
		int count = 0;
		
		for(int x = 1; x < p; x++)
		{
			boolean valid = true;
			int prod = 1;
			for(int n = 1; n < p - 1; n++)
			{
				prod = (prod * x) % p;
				if(prod == 1)
				{
					valid = false;
					break;
				}
			}
			prod = (prod * x) % p;
			if(prod == 1 && valid)
				count++;
		}
		
		System.out.println(count);
	}
	

}
