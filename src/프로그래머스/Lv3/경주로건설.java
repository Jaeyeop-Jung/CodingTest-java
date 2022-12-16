package 프로그래머스.Lv3;

import java.util.*;

public class 경주로건설 {

	public static int[] dRow = new int[] {0, 1, 0, -1};
	public static int[] dColumn = new int[] {1, 0, -1, 0};

	public int solution(int[][] board) {
		int[][] dp = new int[board.length][board[0].length];
		for (int r = 0; r < dp.length; r++) {
			for (int c = 0; c < dp[r].length; c++) {
				dp[r][c] = Integer.MAX_VALUE;
			}
		}

		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0, 0, 100});
		q.add(new int[] {0, 0, 1, 100});
		dp[0][0] = 100;
		while (!q.isEmpty()) {
			int[] pop = q.pollFirst();
			int r = pop[0];
			int c = pop[1];
			int d = pop[2];
			int cost = pop[3];
			if (r == dp.length - 1 && c == dp[r].length - 1) {
				dp[r][c] = Math.min(dp[r][c], cost);
				continue;
			}
			if (dp[r][c] < cost) {
				continue;
			}
			for (int i = 0; i < dRow.length; i++) {
				int movedR = r + dRow[i];
				int movedC = c + dColumn[i];
				if (!(0 <= movedR && movedR < dp.length) || !(0 <= movedC && movedC < dp[r].length)) {
					continue;
				}
				if (board[movedR][movedC] == 1) {
					continue;
				}
				if (i == d) {
					if (dp[movedR][movedC] < cost + 100) {
						continue;
					}
					dp[movedR][movedC] = cost + 100;
					q.add(new int[] {movedR, movedC, i, cost + 100});
				} else {
					if (dp[movedR][movedC] < cost + 500) {
						continue;
					}
					dp[movedR][movedC] = cost + 500 + 100;
					q.add(new int[] {movedR, movedC, i, cost + 500 + 100});
				}
			}
		}

		for (int[] ints : dp) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
		return dp[dp.length - 1][dp[0].length - 1] - 100;
	}

	public static void main(String[] args) {
		경주로건설 instance = new 경주로건설();
		// int solution = instance.solution(
		// 	new int[][] {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0},
		// 		{0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0},
		// 		{1, 0, 0, 0, 0, 0, 0, 0}});
		int solution = instance.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		System.out.println("solution = " + solution);
	}
}
