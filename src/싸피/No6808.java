package 싸피;

import java.util.Scanner;

class No6808 {

	static int win, lose;

	static int is인영Win(int[] 규영, int[] cur) {
		int 규영점수 = 0, 인영점수 = 0;
		for (int i = 0; i < 9; i++) {
			if (규영[i] < cur[i]) {
				인영점수 += cur[i] + 규영[i];
			} else if (cur[i] < 규영[i]) {
				규영점수 += cur[i] + 규영[i];
			}
		}
		return Integer.compare(인영점수, 규영점수);
	}

	static void permutations(int[] 규영, int[] 인영, int[] cur, boolean[] visited, int cnt) {
		if (cnt == 9) {
			int temp = is인영Win(규영, cur);
			if (0 < temp) {
				win++;
			} else if (temp < 0){
				lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			cur[cnt] = 인영[i];
			permutations(규영, 인영, cur, visited, cnt + 1);
			visited[i] = false;
			cur[cnt] = 0;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			win = 0;
			lose = 0;
			int[] 규영 = new int[9];
			for (int i = 0; i < 9; i++) {
				규영[i] = sc.nextInt();
			}
			int[] 인영 = new int[9];
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				boolean flag = true;
				for (int j = 0; j < 9; j++) {
					if (규영[j] == i) {
						flag = false;
					}
				}
				if (flag) {
					인영[idx++] = i;
				}
			}

			boolean[] visited = new boolean[9];
			permutations(규영, 인영, new int[9], new boolean[9], 0);
			System.out.printf("#%d %d %d\n", test_case, lose, win);
		}
	}
}