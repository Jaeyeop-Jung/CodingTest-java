package 프로그래머스.Lv2;

import java.util.ArrayDeque;

public class 게임맵최단거리 {
	public static int[] dRow = new int[]{0, 1, 0, -1};
	public static int[] dColumn = new int[]{1, 0, -1, 0};

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[n][m];
		q.add(new int[]{0, 0, 1});
		visited[0][0] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for (int i = 0; i < 4; i++) {
				int movedR = cur[0] + dRow[i];
				int movedC = cur[1] + dColumn[i];
				if (!(0 <= movedR && movedR < n) || !(0 <= movedC && movedC < m)) {
					continue;
				}
				if (maps[movedR][movedC] == 0 || visited[movedR][movedC] != 0) {
					continue;
				}
				visited[movedR][movedC] = cur[2] + 1;
				q.add(new int[]{movedR, movedC, cur[2] + 1});
			}
		}
		if (visited[n - 1][m - 1] == 0) {
			return -1;
		}
		return visited[n - 1][m - 1];
	}

	public static void main(String[] args) {
		게임맵최단거리 instance = new 게임맵최단거리();
		int solution = instance.solution(
			new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
		System.out.println("solution = " + solution);
	}
}
