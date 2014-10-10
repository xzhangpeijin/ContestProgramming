package contests.completed.icpc;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class EasyTask
{	
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	class Problem {
		public final char id;
		public int accepted = 0;
		// Team -> Time
		public HashMap<String, Integer> solved = new HashMap<String, Integer>();
		// Team -> Submissions
		public HashMap<String, Integer> submissions = new HashMap<String, Integer>();

		public Problem(char id) {
			this.id = id;
		}

		public String getAvgSubmissions() {
			double total = 0;
			double count = 0;
			for (String team : solved.keySet()) {
				total += submissions.get(team);
				count++;
			}
			String result = String.valueOf(round(total / count, 2));
			while (result.indexOf(".") >= result.length() - 2) {
				result += "0";
			}
			return result;
		}

		public String getAvgTime() {
			double total = 0;
			double count = 0;
			for (String team : solved.keySet()) {
				total += solved.get(team);
				count++;
			}
			String result = String.valueOf(round(total / count, 2));
			while (result.indexOf(".") >= result.length() - 2) {
				result += "0";
			}
			return result;
		}
	}

	public void solve() throws IOException 
	{
		int n = nextInt();
		Problem[] problems = new Problem[9];
		for (int x = 0; x < 9; x++) {
			problems[x] = new Problem((char)(x + 65));
		}

		for (int x = 0; x < n; x++) {
			int time = nextInt();
			String team = nextToken();
			String probid = nextToken();
			String result = nextToken();

			Problem problem = problems[probid.charAt(0) - 65];
			if (problem.solved.get(team) == null) { 
				Integer numsubs = problem.submissions.get(team);
				if (numsubs == null) {
					problem.submissions.put(team, 1);
				} else {
					problem.submissions.put(team, numsubs + 1);
				}

				if (result.equals("A")) {
					problem.accepted++;
					problem.solved.put(team, time);
				}
			}
		}

		for(int x = 0; x < 9; x++) {
			Problem problem = problems[x];
			System.out.print(problem.id + " ");
			System.out.print(problem.accepted);
			if (problem.accepted > 0) {
				System.out.print(" " + problem.getAvgSubmissions());
				System.out.print(" " + problem.getAvgTime());
			}
			System.out.println();
		}

	}

	public BufferedReader br;
	public StringTokenizer st;
	public PrintWriter out;

	public String nextToken() throws IOException {
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}

		return st.nextToken();
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws  IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void run() throws IOException 
	{	
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		oj = true;
		br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt")));
		out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt"));
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException 
	{
		new EasyTask().run();
	}
}
