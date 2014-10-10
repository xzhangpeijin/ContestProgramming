package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest172C
{
	public static void main(String[] args)
	{
		new Contest172C();
	}
	
	public Contest172C()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int degree = Integer.parseInt(st.nextToken());
		if(degree > 90)
			degree = 180 - degree;
		double angle = (double) degree * Math.PI / (double) 180;
		double minang = Math.atan(h / w);
	
		if(degree != 0 && minang > angle)
		{
			double[] coeff1 = {Math.sin(angle), 1 + Math.cos(angle), h};
			double[] coeff2 = {1 + Math.cos(angle), Math.sin(angle), w};

			double factor = coeff2[0] / coeff1[0];
			for(int x = 0; x < 3; x++)
				coeff1[x] = coeff1[x] * factor;
			double side1, side2;
			side2 = (coeff2[2] - coeff1[2]) / (coeff2[1] - coeff1[1]);
			side1 = (coeff1[2] - coeff1[1] * side2) / coeff1[0];
			double result = w * h - (Math.pow(side1, 2) + Math.pow(side2, 2)) * Math.sin(angle) * Math.cos(angle);
			System.out.println(result);
		}
		else
			System.out.println(w * h);

	}
	
	

}
