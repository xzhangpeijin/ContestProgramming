package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ResistorCircuits
{	
	public void solve() throws IOException 
	{
		int n;
		while ((n = nextInt()) != 0) {
			ArrayList<Double>[][] counts = new ArrayList[26][26];
			int[] out = new int[26];
			for (int x = 0; x < 26; x++) {
				for (int y = x + 1; y < 26; y++) {
					counts[x][y] = new ArrayList<Double>();
				}
			}
			for (int x = 0; x < n; x++) {
				int start = nextToken().charAt(0) - 65;
				int end = nextToken().charAt(0) - 65;
				double val = nextDouble();
				counts[Math.min(start, end)][Math.max(start, end)].add(val);
				out[start]++;
				out[end]++;
			}

			boolean mademove = true;
			while (mademove) {
				mademove = false;
				outer : {
					for (int x = 0; x < 26; x++) {
						for (int y = x + 1; y < 26; y++) {
							if (counts[x][y].size() > 1) {
								double sum = 0;
								for (int z = 0; z < counts[x][y].size(); z++) {
									sum += (double) 1.0 / counts[x][y].get(z);
								}
								out[x] -= counts[x][y].size();
								out[y] -= counts[x][y].size();
								counts[x][y].clear();
								counts[x][y].add((double) 1.0 / sum);
								mademove = true;
								out[x]++;
								out[y]++;
								//System.out.println("Parallel: " + (char)(x + 65) + " " + (char)(y + 65));
								break outer;
							}
						}
						if (x != 0 && x != 25 && out[x] == 2) {
							int start = -1;
							int end = -1;
							for (int y = 0; y < 26; y++) {
								if (y != x && counts[Math.min(x, y)][Math.max(x, y)].size() == 1) {
									if (start == -1) {
										start = y;
									} else {
										end = y;
										break;
									}
								}
							}
							double newval = counts[Math.min(start, x)][Math.max(start, x)].get(0) + 
									counts[Math.min(end, x)][Math.max(end, x)].get(0);
							out[x] = 0;
							counts[Math.min(start, x)][Math.max(start, x)].clear();
							counts[Math.min(end, x)][Math.max(end, x)].clear();
							counts[start][end].add(newval);
							//System.out.println("Series: " + (char)(start + 65) + " " + (char)(x + 65) + " " + (char)(end + 65));
							mademove = true;
							break outer;
						}
					}
				}
			}

			boolean fail = false;
			for (int x = 0; x < 26; x++) {
				if (x != 0 && x != 25 && out[x] != 0) {
					System.out.println("-1.000");
					fail = true;
					break;
				}
			}
			if (!fail) {
				if (out[0] == 1 && out[25] == 1) {
					double val = (double)Math.round(counts[0][25].get(0) * 1000) / 1000;
					System.out.println(String.format("%.3f", val));
				} else {
					System.out.println("-1.000");
				}
			}
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
		new ResistorCircuits().run();
	}
}
