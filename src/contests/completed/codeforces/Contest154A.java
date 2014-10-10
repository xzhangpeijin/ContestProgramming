package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest154A
{
	public Contest154A() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int boy = Integer.valueOf(st.nextToken());
		int girl = Integer.valueOf(st.nextToken());
		
		String output = "";
		
		if(boy >= girl)
		{
			for(int x = 0; x < girl; x++)
			{
				output += "BG";
			}
			for(int x = 0; x < boy - girl; x++)
			{
				output += "B";
			}
		}
		if(girl > boy)
		{
			for(int x = 0; x < boy; x++)
			{
				output += "GB";
			}
			for(int x = 0; x < girl - boy; x++)
			{
				output += "G";
			}
		}
		f.write(output);
		f.flush();
		f.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest154A();
	}
}
