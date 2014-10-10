package contests.completed.codeforces;
import java.util.*;

public class Contest136A
{
	public Contest136A()
	{
		Scanner in = new Scanner(System.in);
		
		Integer length = Integer.valueOf(in.nextLine());
		
		String result = String.valueOf(length);
		
		for(int x = 1; x < length; x++)
			result += " " + String.valueOf(x);
			
		System.out.println(result);
	}
	
	public static void main(String[] args)
	{
		new Contest136A();
	}
}
