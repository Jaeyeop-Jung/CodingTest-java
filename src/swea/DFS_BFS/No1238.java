package swea.DFS_BFS;

import java.util.*;

public class No1238 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int start = sc.nextInt();
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int i = 0; i < n; i += 2) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if (!graph.containsKey(u)) {
					graph.put(u, new ArrayList<>());
				}
				graph.get(u).add(v);
			}

			int res = -1;
			int depth = 0;
			boolean[] visited = new boolean[101];
			visited[start] = true;
			Deque<Status> q = new ArrayDeque<>();
			q.add(new Status(start, 1));
			while (!q.isEmpty()) {
				int curDepth = q.size();
				int tempRes = -1;
				for (int i = 0; i < curDepth; i++) {
					Status cur = q.pollFirst();
					tempRes = Math.max(tempRes, cur.cur);
					if (!graph.containsKey(cur.cur)) {
						continue;
					} else {
						for (Integer next : graph.get(cur.cur)) {
							if (!visited[next]) {
								visited[next] = true;
								q.add(new Status(next, cur.depth + 1));
							}
						}
					}
				}
				res = tempRes;
			}

			System.out.printf("#%d %d\n", tc, res);
		}
	}
}

class Status {
	int cur, depth;

	public Status(int cur, int depth) {
		this.cur = cur;
		this.depth = depth;
	}
}