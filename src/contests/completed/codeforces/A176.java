package contests.completed.codeforces;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A176
{
	public static void main(String[] args)
	{
		new A176();
	}
	
	public A176()
	{
		Scanner in = new Scanner(System.in);
		
		int wires = Integer.parseInt(in.nextLine());
		int[] birds = new int[wires];
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		for(int x = 0; x < wires; x++)
			birds[x] = Integer.parseInt(st.nextToken());
		
		int shots = Integer.parseInt(in.nextLine());
		
		for(int x = 0; x < shots; x++)
		{
			st = new StringTokenizer(in.nextLine());
			int wire = Integer.parseInt(st.nextToken());
			int bird = Integer.parseInt(st.nextToken());
			int numbirds = birds[wire - 1];
			birds[wire - 1] = 0;
			
			if(wire != 1)
				birds[wire - 2] += bird - 1;
			if(wire != wires)
				birds[wire] += numbirds - bird;
		}
		
		for(int x = 0; x < wires; x++)
			System.out.println(birds[x]);
	}
	
}
