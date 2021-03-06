package contest.usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class USACO_2013_Goldilocks_And_The_N_Cows {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		int n = readInt();
		int x = readInt();
		int y = readInt();
		int z = readInt();
		int[] cold = new int[n + 1];
		int[] hot = new int[n + 1];
		cold[n] = Integer.MAX_VALUE;
		hot[n] = Integer.MAX_VALUE;
		for (int q = 0; q < n; q++) {
			cold[q] = readInt();
			hot[q] = readInt();
		}
		Arrays.sort(cold);
		Arrays.sort(hot);
		int max = 0;
		int total = n * x;
		int index1 = 0;
		int index2 = 0;
		while (index1 != n || index2 != n) {
			if (cold[index1] <= hot[index2]) {
				total += y - x;
				index1++;
			} else {
				total += z - y;
				index2++;
			}
			max = Math.max(max, total);
		}
		System.out.println(max);
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

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
