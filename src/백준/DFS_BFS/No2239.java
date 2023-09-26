package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No2239 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[][] arr = new int[9][9];
	static List<Pos> emptyList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		for (int r = 0; r < 9; r++) {
			char[] chars = br.readLine().toCharArray();
			for (int c = 0; c < 9; c++) {
				arr[r][c] = chars[c] - '0';
				if (arr[r][c] == 0) {
					emptyList.add(new Pos(r, c));
				}
			}
		}

		sudoku(0);
	}

	static void sudoku(int idx) {
		if (idx == emptyList.size()) {
			for (int[] each : arr) {
				for (int num : each) {
					System.out.print(num);
				}
				System.out.println();
			}
			System.exit(0);
		}

		Set<Integer> available = makeOneToNineSet();
		Pos pos = emptyList.get(idx);
		for (int i = 0; i < 9; i++) {
			available.remove(arr[i][pos.c]);
			available.remove(arr[pos.r][i]);
		}
		int startR = pos.r / 3 * 3;
		int startC = pos.c / 3 * 3;
		for (int r = startR; r < startR + 3; r++) {
			for (int c = startC; c < startC + 3; c++) {
				available.remove(arr[r][c]);
			}
		}


		for (Integer num : available) {
			arr[pos.r][pos.c] = num;
			sudoku(idx + 1);
			arr[pos.r][pos.c] = 0;
		}
	}

	static Set<Integer> makeOneToNineSet() {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			set.add(i);
		}
		return set;
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}