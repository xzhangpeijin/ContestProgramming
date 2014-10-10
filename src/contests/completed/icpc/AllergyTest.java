package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class AllergyTest
{	
	class State {
		public int[] remaining;
		public int total;
		public int gap;

		public State(int[] remaining, int total, int gap) {
			this.remaining = remaining;
			this.total = total;
			this.gap = gap;
		}

		public int hashCode() {
			int total = 0;
			int factor = 1;
			for (int x = 0; x < remaining.length; x++) {
				total += remaining[x] * factor;
				factor *= 21;
			}
			return total;
		}
		
		public int dpVal() {
			return total * 7 + gap;
		}
	}

	public void solve() throws IOException 
	{
		int k = nextInt();
		int tot = 0;
		int min = 0;
		int[] durations = new int[6];
		for(int x = 0; x < k; x++) {
			int duration = nextInt();
			if (duration == 1) {
				tot += 1;
			} else {
				durations[7 - duration]++;
			}
			min += duration;
		}

		State init = new State(durations, tot, 0);

		HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
		dp.put(init.hashCode(), 7 * init.total);
		dp.put(0, 7 * min);

		Queue<State> bfs = new LinkedList<State>();
		bfs.add(init);

		while(bfs.size() > 0) {
			//System.out.println(bfs.size());
			State state = bfs.poll();
			int total = state.total;
			int hash = state.hashCode();
			if (hash != 0 && dp.get(hash) == state.dpVal()) {
				int[] remain = state.remaining;
				int gap = state.gap;
				for (int x = 0; x < remain.length; x++) {
					if (remain[x] != 0) {
						int[] newremain = remain.clone();
						newremain[x]--;
						
						int newtotal, newgap;
						if (gap >= val(x)) {
							newtotal = total + 1;
							newgap = 0;
						} else {
							newtotal = total + val(x) - gap;
							newgap = val(x) - gap - 1;
						}
						State newstate = new State(newremain, newtotal, newgap);
						Integer dpmin = dp.get(newstate.hashCode());
						if (dpmin == null || newstate.dpVal() < dpmin) {
							dp.put(newstate.hashCode(), newstate.dpVal());
							bfs.add(newstate);
						}
					}
				}
			}
		}

		System.out.println(dp.get(0) / 7);
	}

	public int val(int x) {
		return 7 - x;
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
		new AllergyTest().run();
	}
}
