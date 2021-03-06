package contest.bloomberg;

import java.util.*;
import java.io.*;

public class Bloomberg_Qualifier_2017_C {

	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		//br = new BufferedReader(new FileReader("in.txt"));
		//out = new PrintWriter(new FileWriter("out.txt"));

		int n = readInt();
		int[] num = new int[n + 1];
		int[] solution = new int[n + 1];
		int largest = 0;
		for (int x = 1; x <= n; x++) {
			num[x] = readInt();
			solution[x] = num[x];
			for (int y = 1; y < x; y++)
				if (num[y] <= num[x] && solution[y] + num[x] > solution[x])
					solution[x] = solution[y] + num[x];
			largest = Math.max(largest, solution[x]);
		}
		out.println(largest);

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
