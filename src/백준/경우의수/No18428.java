package 백준.경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No18428 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dR = {0, 1, 0, -1};
	static int[] dC = {1, 0, -1, 0};
	static boolean flag;
	static List<Pos> teachers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (arr[i][j].equals("T")) {
					teachers.add(new Pos(i, j));
				}
			}
		}

		combinations(arr, 0, 0, 0);
		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static void combinations(String[][] arr, int r, int c, int cnt) {
		if (cnt == 3) {
			simul(arr);
			return;
		}

		for (int curR = r; curR < arr.length; curR++) {
			for (int curC = c; curC < arr.length; curC++) {
				if (arr[curR][curC].equals("X")) {
					arr[curR][curC] = "O";
					if (curC == arr.length - 1) {
						combinations(arr, curR + 1, 0,cnt + 1);
					} else {
						combinations(arr, curR, curC + 1,cnt + 1);
					}
					arr[curR][curC] = "X";
				}
			}
			c = 0;
		}
	}

	static void simul(String[][] arr) {
		for (Pos teacher : teachers) {
			for (int d = 0; d < 4; d++) {
				int curR = teacher.r, curC = teacher.c;
				while (true) {
					int movedR = curR + dR[d], movedC = curC + dC[d];
					if (!(0 <= movedR && movedR < arr.length && 0 <= movedC && movedC < arr.length)) {
						break;
					}
					if (arr[movedR][movedC].equals("O")) {
						break;
					}
					if (arr[movedR][movedC].equals("S")) {
						return;
					}
					curR = movedR;
					curC = movedC;
				}
			}
		}
		flag = true;
	}
}

class Pos {
	int r, c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}