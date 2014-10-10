package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest154B
{
	public Contest154B() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		int num = Integer.parseInt(in.readLine());
		
		int[] measure = new int[num];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int x = 0; x < num; x++)
		{
			measure[x] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(measure);
		f.write(String.valueOf(minRemove(measure, 0, measure.length - 1)));
		f.flush();
		f.close();
	}
	
	public int minRemove(int[] measure, int start, int end)
	{
		int remaining = end - start + 1;
		if(2 * measure[start] >= measure[end])
			return measure.length - remaining;
		
		int a = 0;
		int b = 0;
		double large = (double) measure[end] / 2;
		double small = (double) measure[start] * 2;
		
		for(int x = start; x <= end; x++)
		{
			if(large > measure[x])
				a++;
			if(small < measure[x])
				b++;
		}
		
		System.out.println(start + " " + end + " " + a + " " + b);
		
		if(a > b)
			return minRemove(measure, start, end - 1);
		else
			return minRemove(measure, start + 1, end);
		
			
//		double average = total / remaining;
//		System.out.println((double)( measure[end] / 2 - average) + " " + (average - (double) measure[start] * 2));
//		
//		if((double) measure[end] / 2 - average > average - (double) measure[start] * 2)
//			return minRemove(measure, start, end - 1, total - measure[end]);
//		else if((double) measure[end] / 2 - average > average - (double) measure[start] * 2)
//			return minRemove(measure, start + 1, end, total - measure[start]);
//		else
//			return Math.min(minRemove(measure, start + 1, end, total - measure[start]), minRemove(measure, start, end - 1, total - measure[end]));
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest154B();
	}
}
