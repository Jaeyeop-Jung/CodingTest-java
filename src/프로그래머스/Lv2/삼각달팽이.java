package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
	public static int[] dRow = new int[] {1, 0, -1};
	public static int[] dColumn = new int[] {0, 1, -1};

	public int[] solution(int n) {
		List<List<Integer>> tempResult = new ArrayList<>();
		for (int i = 1; i < n + 1; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				temp.add(0);
			}
			tempResult.add(temp);
		}

		int dIdx = 0;
		int count = 1;
		int r = -1;
		int c = 0;
		for (int i = n; 0 < i; i--) {
			for (int j = 0; j < i; j++) {
				r += dRow[dIdx];
				c += dColumn[dIdx];
				tempResult.get(r).set(c, count++);
			}
			dIdx++;
			dIdx %= 3;
		}
		List<Integer> result = new ArrayList<>();
		tempResult.stream().forEach(result::addAll);
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		삼각달팽이 instance = new 삼각달팽이();
		System.out.println(instance.solution(4));;
		System.out.println(instance.solution(5));;
		System.out.println(instance.solution(6));;
	}
}
