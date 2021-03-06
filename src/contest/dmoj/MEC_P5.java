package contest.dmoj;

import java.util.*;
import java.io.*;

public class MEC_P5 {

	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;

	static int N;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		//br = new BufferedReader(new FileReader("in.txt"));
		//out = new PrintWriter(new FileWriter("out.txt"));

		N = readInt();

		Point[] points = new Point[N + 2];

		int first = 0;
		int last = 0;

		for (int x = 0; x < N; x++) {
			points[x] = new Point(readInt(), x);
			if (x == 0)
				first = points[x].x;
			if (x == N - 1)
				last = points[x].x;
		}

		points[N] = new Point(0, 0);
		points[N + 1] = new Point(0, N - 1);

		ArrayList<Point> u = new ArrayList<Point>();
		ArrayList<Point> l = new ArrayList<Point>();

		Arrays.sort(points);

		for (int x = 0; x < N + 1; x++) {
			int i = l.size();
			while (i >= 2 && ccw(l.get(i - 2), l.get(i - 1), points[x]) <= 0) {
				l.remove(i - 1);
				i = l.size();
			}
			l.add(points[x]);
		}
		for (int x = N + 1; x >= 0; x--) {
			int i = u.size();
			while (i >= 2 && ccw(u.get(i - 2), u.get(i - 1), points[x]) <= 0) {
				u.remove(i - 1);
				i = u.size();
			}
			u.add(points[x]);
		}
		u.remove(u.size() - 1);
		l.remove(l.size() - 1);
		l.addAll(u);

		double length = 0;

		int j = l.size() - 1;
		for (int i = 0; i < l.size(); i++) {
			length += getDist(l.get(j).x, l.get(j).y, l.get(i).x, l.get(i).y);
			j = i;
		}

		out.printf("%.1f\n", length - first - last - N + 1);
		out.close();
	}

	static double getDist (int x1, int y1, int x2, int y2) {
		double x = x1 - x2;
		double y = y1 - y2;
		return Math.sqrt(x * x + y * y);
	}

	//CCW > 0 counter clockwise
	static int ccw (Point p1, Point p2, Point p3) {
		return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
	}

	static class Point implements Comparable<Point> {
		int x, y;

		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo (Point o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
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

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
