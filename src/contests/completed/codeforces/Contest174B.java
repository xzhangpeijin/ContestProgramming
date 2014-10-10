package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest174B
{
	public static void main(String[] args)
	{
		new Contest174B();
	}
	
	public Contest174B()
	{
		Scanner in = new Scanner(System.in);
		
		int length = Integer.parseInt(in.nextLine());
		char[] players = in.nextLine().toCharArray();
		
		int incow = 0;
		int allcow = 0;
		for(int x = 0; x < players.length; x++)
		{
			if(players[x] == 'I')
				incow++;
			else if(players[x] == 'A')
				allcow++;
		}
		int ans;
		if(incow == 1)
			ans = 1;
		else if(incow > 1)
			ans = 0;
		else
			ans = allcow;
		
		System.out.println(ans);
	}
	

}
