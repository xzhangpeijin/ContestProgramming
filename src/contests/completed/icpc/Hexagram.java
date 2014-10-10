package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class Hexagram
{	
	public void solve() throws IOException 
	{
		while (true) {
			int sum = 0;
			ArrayList<Integer> input = new ArrayList<Integer>();
			for (int x = 0; x < 12; x++) {
				int next = nextInt();
				input.add(next);
				sum += 2 * next;
			}
			if (sum == 0) {
				break;
			}
			if (sum % 6 != 0) {
				System.out.println(0);
				continue;
			}

			int count = 0;

			sum /= 6;
			HashSet<Integer> used = new HashSet<Integer>();
			for (int a = 0; a < 12; a++) {
				used.add(input.get(a));
				for(int b = 0; b < 12; b++) {
					if (!used.contains(input.get(b))) {
						used.add(input.get(b));
						for (int c = 0; c < 12; c++) {
							if (!used.contains(input.get(c))) {
								used.add(input.get(c));
								int topright = sum - input.get(a) - input.get(b) - input.get(c);
								if (input.contains(topright) && !used.contains(topright)) {
									used.add(topright);
									for (int e = 0; e < 12; e++) {
										if (!used.contains(input.get(e))) {
											used.add(input.get(e));
											for (int f = 0; f < 12; f++) {
												if (!used.contains(input.get(f))) {
													used.add(input.get(f));
													int botleft = sum - input.get(b) - input.get(e) - input.get(f);
													if (input.contains(botleft) && !used.contains(botleft)) {
														used.add(botleft);
														for (int g = 0; g < 12; g++) {
															if (!used.contains(input.get(g))) {
																int botright = sum - input.get(c) - input.get(e) - input.get(g);
																if (input.contains(botright) && !used.contains(botright)) {
																	used.add(botright);
																	for(int h = 0; h < 12; h++) {
																		if (!used.contains(input.get(h))) {
																			used.add(input.get(h));
																			int bot = sum - input.get(a) - input.get(f) - input.get(h);
																			if (input.contains(bot) && !used.contains(bot)) {
																				used.add(bot);
																				int mid = sum - input.get(h) - botleft - botright;
																				if (input.contains(mid) && !used.contains(mid) &&
																						sum == mid + input.get(g) + bot + topright) {
																					count++;
																				}
																				used.remove(bot);
																			}
																			used.remove(input.get(h));
																		}
																	}
																	used.remove(botright);
																}
															}
														}
														used.remove(botleft);
													}
													used.remove(input.get(f));
												}
											}
											used.remove(input.get(e));
										}
									}
									used.remove(topright);
								}
								used.remove(input.get(c));
							}
						}
						used.remove(input.get(b));
					}
				}
				used.remove(input.get(a));
			}
			//System.out.println(count);
			System.out.println(count / 12);
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
		new Hexagram().run();
	}
}
