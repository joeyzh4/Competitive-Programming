package contest.usaco_other;

/*
ID: jeffrey40
LANG: JAVA
TASK: marathon
 */
import java.util.*;
import java.io.*;

public class marathon_bronze {
	static BufferedReader br;
	static PrintWriter pr;
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new FileReader("marathon.in"));
		// br = new BufferedReader(new InputStreamReader(System.in));
		pr = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		int n = readInt();
		Point[] p = new Point[n];
		for (int x = 0; x < n; x++)
			p[x] = new Point(readInt(), readInt());
		int maxDist = 0;
		int totalDist = 0;
		for (int x = 0; x < n - 2; x++) {
			maxDist = Math.max(maxDist, dist(p[x], p[x + 1]) + dist(p[x + 1], p[x + 2]) - dist(p[x], p[x + 2]));
		}
		for (int x = 0; x < n - 1; x++)
			totalDist += dist(p[x], p[x + 1]);
		pr.println(totalDist - maxDist);
		pr.close();
		System.exit(0);
	}

	private static int dist (Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static class Point {
		int x, y;

		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
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
