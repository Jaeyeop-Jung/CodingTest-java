package 싸피;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class No1861 {
	static int[] dR = {0, 1, 0, -1};
	static int[] dC = {1, 0, -1, 0};
	static int resCnt = 0, resMin = Integer.MAX_VALUE;

	static void dfs(int[][] arr, int min, int cnt, int r, int c) {
		if (resCnt < cnt) {
			resCnt = cnt;
			resMin = min;
		} else if (resCnt == cnt) {
			resMin = Math.min(resMin, min);
		}

		for (int i = 0; i < 4; i++) {
			int movedR = r + dR[i], movedC = c + dC[i];
			if (!(0 <= movedR && movedR < arr.length && 0 <= movedC && movedC < arr.length)) {
				continue;
			}
			if (arr[movedR][movedC] - arr[r][c] != 1) {
				continue;
			}
			dfs(arr, Math.min(min, arr[movedR][movedC]), cnt + 1, movedR, movedC);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			resCnt = 0;
			resMin = Integer.MAX_VALUE;
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					dfs(arr, arr[r][c], 1, r, c);
				}
			}
			System.out.printf("#%d %d %d\n", test_case, resMin, resCnt);
		}
	}

	// public static void main(String[] args) {
	// 	Scanner sc = new Scanner(System.in);
	// 	int T;
	// 	T=sc.nextInt();
	//
	// 	for(int test_case = 1; test_case <= T; test_case++) {
	// 		int n = sc.nextInt();
	// 		int[][] arr = new int[n][n];
	// 		for (int r = 0; r < n; r++) {
	// 			for (int c = 0; c < n; c++) {
	// 				arr[r][c] = sc.nextInt();
	// 			}
	// 		}
	//
	// 		int[][] visited = new int[n][n];
	// 		int cnt = 1;
	// 		for (int r = 0; r < n; r++) {
	// 			for (int c = 0; c < n; c++) {
	// 				if (visited[r][c] == 0) {
	// 					visited[r][c] = cnt;
	// 					Deque<int[]> q = new ArrayDeque<>();
	// 					q.add(new int[] {r, c});
	// 					while (!q.isEmpty()) {
	// 						int[] pop = q.pollFirst();
	// 						for (int d = 0; d < dR.length; d++) {
	// 							int movedR = pop[0] + dR[d], movedC = pop[1] + dC[d];
	// 							if (!(0 <= movedR && movedR < n && 0 <= movedC && movedC < n)) {
	// 								continue;
	// 							}
	// 							if (visited[movedR][movedC] != 0 || Math.abs(arr[movedR][movedC] - arr[pop[0]][pop[1]]) != 1) {
	// 								continue;
	// 							}
	// 							q.add(new int[] {movedR, movedC});
	// 							visited[movedR][movedC] = cnt;
	// 						}
	// 					}
	// 				}
	// 				cnt++;
	// 			}
	// 		}
	//
	// 		int[] startArr = new int[cnt];
	// 		Arrays.fill(startArr, Integer.MAX_VALUE);
	// 		int[] cntArr = new int[cnt];
	// 		for (int r = 0; r < n; r++) {
	// 			for (int c = 0; c < n; c++) {
	// 				int cur = visited[r][c];
	// 				cntArr[cur] ++;
	// 				startArr[cur] = Math.min(startArr[cur], arr[r][c]);
	// 			}
	// 		}
	// 		int resStart = Integer.MAX_VALUE;
	// 		int resCnt = -1;
	// 		for (int i = 0; i < cnt; i++) {
	// 			if (resCnt < cntArr[i]) {
	// 				if (i == 0) {
	// 					resCnt = 0;
	// 				} else {
	// 					resCnt = cntArr[i];
	// 				}
	// 				resStart = startArr[i];
	// 			} else if (resCnt == cntArr[i]) {
	// 				resStart = Math.min(startArr[i], resStart);
	// 			}
	// 		}
	//
	// 		System.out.printf("#%d %d %d\n", test_case, resStart, resCnt);
	// 	}
	// }
}
