package contest.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prims_MST_Special_Subtree {

	static BufferedReader br;
	static PrintWriter pr;
	static StringTokenizer st;

	public static void main (String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pr = new PrintWriter(new OutputStreamWriter(System.out));
		//br = new BufferedReader(new FileReader("in.txt"));
		//pr = new PrintWriter(new FileWriter("out.txt"));

		int n = readInt();
		int m = readInt();
		ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();

		boolean[] v = new boolean[n];
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Edge>());
		for (int i = 0; i < m; i++) {
			int a = readInt() - 1;
			int b = readInt() - 1;
			int c = readInt();
			adj.get(a).add(new Edge(b, c));
			adj.get(b).add(new Edge(a, c));
		}
		int s = readInt() - 1;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(s, 0));
		int sum = 0;
		while (!q.isEmpty()) {
			Edge curr = q.poll();
			if (v[curr.dest])
				continue;
			v[curr.dest] = true;
			sum += curr.cost;
			for (Edge next : adj.get(curr.dest))
				if (!v[next.dest])
					q.offer(next);
		}
		pr.println(sum);

		pr.close();
	}

	static class Edge implements Comparable<Edge> {
		int dest, cost;

		Edge (int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo (Edge o) {
			return cost - o.cost;
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
