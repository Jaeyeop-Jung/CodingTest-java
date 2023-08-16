package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No14226 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int s = Integer.parseInt(br.readLine());
		int[][] visited = new int[2001][2001];
		Deque<Status> q = new ArrayDeque<>();
		visited[1][0] = 0;
		q.add(new Status(1, 0, 0));
		while (!q.isEmpty()) {
			Status status = q.pollFirst();
			if (status.cur == s) {
				break;
			}

			// 1
			if (visited[status.cur][status.cur] == 0) {
				q.add(new Status(status.cur, status.cur, status.cost + 1));
				visited[status.cur][status.cur] = status.cost + 1;
			}

			// 2
			if (status.copy != 0 && status.cur + status.copy < visited.length && visited[status.cur + status.copy][status.copy] == 0) {
				q.add(new Status(status.cur + status.copy, status.copy, status.cost + 1));
				visited[status.cur + status.copy][status.copy] = status.cost + 1;
			}

			// 3
			if (1 < status.cur && visited[status.cur - 1][status.copy] == 0) {
				q.add(new Status(status.cur - 1, status.copy, status.cost + 1));
				visited[status.cur - 1][status.copy] = status.cost + 1;
			}
		}
		System.out.println(Arrays.stream(visited[s]).filter(num -> num != 0).min().getAsInt());
	}
}

class Status {
	int cur, copy, cost;

	public Status(int cur, int copy, int cost) {
		this.cur = cur;
		this.copy = copy;
		this.cost = cost;
	}
}
