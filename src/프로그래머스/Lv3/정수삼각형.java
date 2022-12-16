package 프로그래머스.Lv3;

import java.util.Arrays;

public class 정수삼각형 {

	public static int[] dRow = new int[] {1, 1};
	public static int[] dColumn = new int[] {0, 1};

	public int solution(int[][] triangle) {
		int[][] result = new int[triangle.length][];
		for (int i = 0; i < triangle.length; i++) {
			result[i] = new int[i + 1];
		}

		result[0][0] = triangle[0][0];
		for (int r = 0; r < triangle.length - 1; r++) {
			for (int c = 0; c < triangle[r].length; c++) {
				for (int i = 0; i < dRow.length; i++) {
					int movedR = r + dRow[i];
					int movedC = c + dColumn[i];
					result[movedR][movedC] = Math.max(result[movedR][movedC], result[r][c] + triangle[movedR][movedC]);
				}
			}
		}

		int max = 0;
		for (int[] each : result) {
			for (int i : each) {
				max = Math.max(max, i);
			}
		}
		return max;
	}


	public static void main(String[] args) {
		정수삼각형 instance = new 정수삼각형();
		int solution = instance.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
		System.out.println("solution = " + solution);
	}
}
