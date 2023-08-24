package 백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class No2252 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);

		int[] degree = new int[n];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);

			degree[b - 1]++;
			graph.get(a - 1).add(b - 1);
		}

		int[] res = new int[n];
		int idx = 0;
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (degree[i] == 0) {
				res[idx++] = i + 1;
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			Integer cur = q.pollFirst();
			for (Integer next : graph.get(cur)) {
				degree[next]--;
				if (degree[next] == 0) {
					q.add(next);
					res[idx++] = next + 1;
				}
			}
		}

		System.out.println(
				Arrays.toString(res)
						.replace(",", "")
						.replace("[", "")
						.replace("]", "")
		);
	}
}