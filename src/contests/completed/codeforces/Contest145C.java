package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.*;

public class Contest145C
{
	public Contest145C() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		int days = Integer.valueOf(in.readLine());
		
		String[] temp = in.readLine().split(" ");
		
		ArrayList<Integer> temps = new ArrayList<Integer>();
		
		for(int x = 0; x < days; x++)
			temps.add(Integer.valueOf(temp[x]));
		
		boolean a = false;
		boolean b = false;
		if(temps.get(0) == 0)
			a = true;
		if(temps.get(temps.size() - 1) == 0)
			b = true;
		
		f.write(changeMe(temps, 0, a, b) + "\n");
		f.flush();
		f.close();
	}
	
	public int changeMe(ArrayList<Integer> a, int b, boolean c, boolean d)
	{
		if(a.size() == 0)
		{
			if(!c || !d)
				return b + 1;
			return b;
		}
		
		while(a.size() > 0 && a.get(0) < 0)
		{
			a.remove(0);
			c = true;
		}
		while(a.size() > 0 && a.get(a.size() - 1) > 0)
		{
			a.remove(a.size() - 1);
			d = true;
		}
		
		if(a.size() == 0)
		{
			if(!c || !d)
				return b + 1;
			return b;
		}
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int x = 0; x < a.size() - 1; x++)
			temp.add(a.get(x));
		
		a.remove(0);
		
		return Math.min(changeMe(a, b + 1, c, d), changeMe(temp, b + 1, c, d));
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest145C();
	}
}
