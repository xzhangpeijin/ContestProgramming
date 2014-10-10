package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class C180
{
	public static void main(String[] args)
	{
		new C180();
	}
	
	public C180()
	{
		Scanner in = new Scanner(System.in);
		
		String a = in.nextLine();
		String b = in.nextLine();
		
		int count = 0;
		for(int x = 0; x < a.length(); x++)
			if(a.charAt(x) == '1')
				count += 1;
		
		LinkedList<State> queue = new LinkedList<State>();
		
		System.out.println(a);
	}
	
	public class State
	{
		public String a;
		public String b;
		public int count;
		
		public State(String a, String b, int count)
		{
			//a
		}
	}
}
