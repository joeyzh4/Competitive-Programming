package contest.acm;

import java.util.*;
import java.io.*;

public class ACM_Mount_Allison_2017_A {

	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		//br = new BufferedReader(new FileReader("in.txt"));
		//out = new PrintWriter(new FileWriter("out.txt"));

		int N = readInt();
		
		for (int i = 0; i < N; i++) {
			String in = readLine();
			long ans = 0;
			long curr = 0;
			for (int j = 0; j < in.length(); j++) {
				if (in.charAt(j) == ',')  {
					ans = (ans * 60) + curr;
					curr = 0;
				} else {
					curr = (curr * 10 + in.charAt(j) - '0');
				}
			}
			ans = (ans * 60) + curr;
			out.println(ans);
		}
		
		out.close();
	}

	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}

