package contests.completed.codeforces;
import java.util.*;

public class Contest138C
{
	public Contest138C()
	{
		Scanner in = new Scanner(System.in);

		String input = in.nextLine();
		String output =  "";
		int par = 0;
		int bra = 0;
		int num = 0;
		for(int x = 0; x < input.length(); x++)
		{
			output += input.charAt(x);
			if(input.charAt(x) == '[')
			{
				num++;
				bra++;
			}
			if(input.charAt(x) == '(')
				par++;
			if(input.charAt(x) == ']')
				bra--;
			if(input.charAt(x) == ')')
				par--;
		}

		if(par == 0 && bra == 0)
			System.out.println(num + "\n" + output);
		else
		{
			String result = "";
			while((par != 0 || bra != 0) && output != "" && result == "")
			{
				String temp = output;
				int temppar = par;
				int tempbra = bra;
				while((temppar != 0 || tempbra != 0) && temp != "" && result == "")
				{
					if(temp.charAt(temp.length() - 1) == '[')
						tempbra--;
					if(temp.charAt(temp.length() - 1) == '(')
						temppar--;
					if(temp.charAt(temp.length() - 1) == ']')
						tempbra++;
					if(temp.charAt(temp.length() - 1) == ')')
						temppar++;
					temp = temp.substring(0, temp.length() - 1);
				}
				if(temp.length() != 0)
				{
					result = temp;
				}
				if(output.charAt(0) == '[')
				{
					bra--;
					num--;
				}
				if(output.charAt(0) == '(')
					par--;
				if(output.charAt(0) == ']')
					bra++;
				if(output.charAt(0) == ')')
					par++;
				output = output.substring(1, output.length());
			}
			if(output.length() != 0 && result == "")
			{
				result = output;
			}
			if(output.length() == 0)
				System.out.println("0");
			else
				System.out.println(num + "\n" + result);
		}
	}

	public static void main(String[] args)
	{
		new Contest138C();
	}
}
