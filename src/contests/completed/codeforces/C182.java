package contests.completed.codeforces;
import java.util.*;


public class C182 {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int plus = 0, minus = 0;
		
		for (int i = 0; i < N; i++) {
			if (in.nextInt() == 1)
				plus++;
			else
				minus++;
		}
		int l, r, d;
		for (int i = 0; i < M; i++) {
			l = in.nextInt();
			r = in.nextInt();
			d = r - l + 1;
			
			
			if (d % 2 == 0 && plus >= d/2 && minus >= d/2)
				System.out.println(1);
			else
				System.out.println(0);
				
		}

	}

}
