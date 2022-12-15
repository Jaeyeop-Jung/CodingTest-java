package 프로그래머스.Lv3;

import java.util.*;

public class 가장먼노드 {

	public int solution(int n, int[][] edge) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] each : edge) {
			graph.get(each[0] - 1).add(each[1] - 1);
			graph.get(each[1] - 1).add(each[0] - 1);
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[] result = new int[graph.size()];
		result[0] = -1;
		q.add(new int[] {0, 0});
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			int idx = cur[0];
			int cnt = cur[1];
			for (Integer nextIdx : graph.get(idx)) {
				if (result[nextIdx] != 0) {
					continue;
				}
				result[nextIdx] = cnt + 1;
				q.add(new int[] {nextIdx, cnt + 1});
			}
		}
		int maxValue = Arrays.stream(result).max().getAsInt();
		return (int) Arrays.stream(result).filter(i ->  i == maxValue).count();
	}

	public static void main(String[] args) {
		가장먼노드 instance = new 가장먼노드();
		int solution = instance.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		System.out.println("solution = " + solution);
	}
}
