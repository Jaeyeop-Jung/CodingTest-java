package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class No5014 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int f;

	public static void main(String[] args) throws IOException {
		String[] split = br.readLine().split(" ");
		f = Integer.parseInt(split[0]);
		int s = Integer.parseInt(split[1]);
		int g = Integer.parseInt(split[2]);
		int u = Integer.parseInt(split[3]);
		int d = Integer.parseInt(split[4]);

		int[] visited = new int[f + 1];
		Arrays.setAll(visited, num -> Integer.MAX_VALUE);
		ArrayDeque<Move> q = new ArrayDeque<>();
		q.add(new Move(s, 0));
		visited[s] = 0;

		while (!q.isEmpty()) {
			Move cur = q.pollFirst();
			if (inRange(cur.floor)) {
				if (inRange(cur.floor + u) && visited[cur.floor + u] == Integer.MAX_VALUE) {
					q.add(new Move(cur.floor + u, cur.cost + 1));
					visited[cur.floor + u] = cur.cost + 1;
				}
				if (inRange(cur.floor - d) && visited[cur.floor - d] == Integer.MAX_VALUE) {
					q.add(new Move(cur.floor - d, cur.cost + 1));
					visited[cur.floor - d] = cur.cost + 1;
				}
			}
		}

		if (visited[g] != Integer.MAX_VALUE) {
			System.out.println(visited[g]);
		} else {
			System.out.println("use the stairs");
		}
	}

	static boolean inRange(int cur) {
		if (1 <= cur && cur <= f) {
			return true;
		}
		return false;
	}
}
class Move {
	int floor;
	int cost;

	public Move(int floor, int cost) {
		this.floor = floor;
		this.cost = cost;
	}
}