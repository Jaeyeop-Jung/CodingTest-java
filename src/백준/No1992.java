package 백준;

import java.util.*;
public class No1992 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] board;
	public static String result = "";

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = Arrays.stream(sc.next().split("")).mapToInt(str -> Integer.parseInt(str)).toArray();
		}
		No1992.board = board;

		quadZip(0, 0, n);

		System.out.println(result);
	}

	public static void quadZip(int r, int c, int cur) {
		if (cur < 1) {
			return;
		}
		int temp = board[r][c];
		boolean flag = false;
		for (int curR = r; curR < r + cur; curR++) {
			for (int curC = c; curC < c + cur; curC++) {
				if (temp != board[curR][curC]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			result += temp;
			return;
		}

				result += "(";
		for (int curR = r; curR < r + cur; curR += cur / 2) {
			for (int curC = c; curC < c + cur; curC += cur / 2) {
				quadZip(curR, curC, cur / 2);
			}
		}
		result += ")";
	}
}
