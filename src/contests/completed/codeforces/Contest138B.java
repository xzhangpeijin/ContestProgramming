package contests.completed.codeforces;
import java.util.*;

public class Contest138B
{
	public Contest138B()
	{
		Scanner in = new Scanner(System.in);
		
		int length = in.nextInt();
		
		int desired = in.nextInt();
		
		int[] array = new int[length];
		
		int a = 0, b = length;
		
		HashSet<Integer> unique = new HashSet<Integer>();
		int totaldiff = 0;
		boolean complete = false;
		for(int x = 0; x < length; x++)
		{
			array[x] = in.nextInt();
			int size = unique.size();
			unique.add(new Integer(array[x]));
			if(unique.size() != size)
			{
				totaldiff++;
				if(x != 0 && a == 0)
					a = x;
			
				if(totaldiff == desired)
				{
					complete = true;
					b = x + 1;
					x = length;
				}
			}
		}
		if(a == 0)
			a = 1;
		
		if(!complete)
			System.out.println("-1 -1");
		else
			System.out.println(a + " " + b);
	}

	public static void main(String[] args)
	{
		new Contest138B();
	}
}
