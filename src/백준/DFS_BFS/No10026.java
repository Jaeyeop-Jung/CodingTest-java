package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No10026 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dR = {0, 1, 0, -1};
	static int[] dC = {1, 0, -1, 0};
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().split("");
		}

		int colorful = bfs(arr);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (arr[r][c].equals("R")) {
					arr[r][c] = "G";
				}
			}
		}
		int colorLess = bfs(arr);
		System.out.println(colorful + " " + colorLess);
	}

	static int bfs(String[][] arr) {
		int group = 0;
		boolean[][] visited = new boolean[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (!visited[r][c]) {
					visited[r][c] = true;
					Deque<Pos> q = new ArrayDeque<>();
					q.add(new Pos(r, c));
					while (!q.isEmpty()) {
						Pos cur = q.pollFirst();
						for (int d = 0; d < dR.length; d++) {
							int movedR = cur.r + dR[d], movedC = cur.c + dC[d];
							if (!(0 <= movedR && movedR < n && 0 <= movedC && movedC < n)) {
								continue;
							}
							if (!arr[movedR][movedC].equals(arr[r][c]) || visited[movedR][movedC]) {
								continue;
							}
							visited[movedR][movedC] = true;
							q.add(new Pos(movedR, movedC));
						}
					}
					group++;
				}
			}
		}
		return group;
	}
}

class Pos {
	int r, c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
