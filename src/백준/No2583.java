package 백준;

import java.util.*;

public class No2583 {
	public static Scanner sc = new Scanner(System.in);
	public static int[] dRow = new int[] {0, 1, 0, -1};
	public static int[] dColumn = new int[] {1, 0, -1, 0};
	public static int cnt = 1;
	public static int temp = 0;

	public static void main(String[] args) {
		String[] split = sc.nextLine().split(" ");
		int m = Integer.parseInt(split[0]); int n = Integer.parseInt(split[1]); int k = Integer.parseInt(split[2]);
		int[][] visited = new int[m][n];
		for (int i = 0; i < k; i++) {
			split = sc.nextLine().split(" ");
			int c1 = Integer.parseInt(split[0]);
			int r1 = Integer.parseInt(split[1]);
			int c2 = Integer.parseInt(split[2]);
			int r2 = Integer.parseInt(split[3]);
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					visited[r][c] = -1;
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (visited[r][c] == 0) {
					visited[r][c] = cnt;
					temp++;
					dfs(visited, r, c);
					cnt++;
					result.add(temp);
					temp = 0;
				}
			}
		}

		System.out.println(result.size());
		result.sort(Comparator.naturalOrder());
		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
	}

	public static void dfs(int[][] visited, int r, int c) {
		for (int i = 0; i < dRow.length; i++) {
			int movedR = r + dRow[i];
			int movedC = c + dColumn[i];
			if (!(0 <= movedR && movedR < visited.length) || !(0 <= movedC && movedC < visited[0].length)) {
				continue;
			}
			if (visited[movedR][movedC] != 0) {
				continue;
			}
			temp++;
			visited[movedR][movedC] = cnt;
			dfs(visited, movedR, movedC);
		}
	}
}
