package 백준.구현;

import java.io.*;
import java.util.*;

public class No17281 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;

	static void swap(int[] cur) {
		int a = cur[3];
		int b = cur[cur.length - 1];
		cur[3] = b;
		cur[cur.length - 1] = a;
	}

	static void permutations(List<int[]> res, boolean[] visited, int cnt, int[] cur) {
		if (cnt == 8) {
			swap(cur);
			res.add(Arrays.copyOf(cur, cur.length));
			swap(cur);
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				cur[cnt] = i;
				visited[i] = true;
				permutations(res, visited, cnt + 1, cur);
				cur[cnt] = 0;
				visited[i] = false;
			}
		}
	}

	static Queue<Boolean> makeBase() {
		Queue<Boolean> base = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			base.add(false);
		}
		return base;
	}

	// static int getScore(int[] each) {
	// 	int score = 0;
	// 	int hitter = 0;
	// 	for (int inning = 0; inning < arr.length; inning++) {
	// 		Queue<Boolean> base = makeBase();
	// 		int out = 0;
	// 		while (out < 3) {
	// 			hitter %= 9;
	// 			int go = arr[inning][each[hitter++]];
	// 			if (go == 0) {
	// 				out++;
	// 				continue;
	// 			}
	// 			base.add(true);
	// 			for (int i = 0; i < go; i++) {
	// 				if (base.poll()) {
	// 					score++;
	// 				}
	// 			}
	// 			for (int i = 0; i < go - 1; i++) {
	// 				base.add(false);
	// 			}
	// 		}
	// 	}
	// 	return score;
	// }

	static int getScore(int[] each) {
		int score = 0;
		int hitter = 0;
		for (int inning = 0; inning < arr.length; inning++) {
			int out = 0;
			boolean[] base = new boolean[3];
			while (out < 3) {
				hitter %= 9;
				int go = arr[inning][each[hitter++]];
				if (go == 0) {
					out++;
					continue;
				} else if (go == 1) {
					if (base[2]) {
						score++;
					}
					for (int i = 2; 0 < i; i--) {
						base[i] = base[i - 1];
					}
					base[0] = true;
				} else if (go == 2) {
					for (int i = 2; 1 <= i; i--) {
						if (base[i]) {
							score++;
						}
					}
					base[2] = base[0];
					base[1] = true;
					base[0] = false;
				} else if (go == 3) {
					for (int i = 0; i < 3; i++) {
						if (base[i]) {
							score++;
						}
						base[i] = false;
					}
					base[2] = true;
				} else {
					score++;
					for (int i = 0; i < 3; i++) {
						if (base[i]) {
							score++;
						}
					}
					base = new boolean[3];
				}

			}
		}
		return score;
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer sb = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(sb.nextToken());
			}
		}

		boolean[] visited = new boolean[9];
		int[] cur = new int[9];

		List<int[]> permutation = new ArrayList<>();
		permutations(permutation, visited, 0, cur);
		int res = 0;
		for (int[] each : permutation) {
			res = Math.max(res, getScore(each));
		}
		System.out.println(res);
	}
}