package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class No1926 {

	static int[] dR = {0, 1, 0, -1};
	static int[] dC = {1, 0, -1, 0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static int[][] arr;
	static int res;
	static int resCnt;

	public static int dfs(boolean[][] visited, int r, int c, int width) {
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int movedR = r + dR[i], movedC = c + dC[i];
			if (!(0 <= movedR && movedR < n && 0 <= movedC && movedC < m)) {
				continue;
			}
			if (visited[movedR][movedC] || arr[movedR][movedC] == 0) {
				continue;
			}
			visited[movedR][movedC] = true;
			cnt += dfs(visited, movedR, movedC, width + 1);
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(sb.nextToken());
			}
		}

		boolean[][] visited = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (arr[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					resCnt++;
					res = Math.max(res, dfs(visited, r, c, 1));
				}
			}
		}
		System.out.println(resCnt);
		System.out.println(res);
	}
}
