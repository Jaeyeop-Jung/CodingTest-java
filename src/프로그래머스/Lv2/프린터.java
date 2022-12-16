package 프로그래머스.Lv2;

import java.util.*;

public class 프린터 {

	public int solution(int[] priorities, int location) {
		List<List<Integer>> waits = new ArrayList<>();
		for (int i = 0; i < priorities.length; i++) {
			waits.add(Arrays.asList(i, priorities[i]));
		}

		List<Integer> finish = new ArrayList<>();
		Deque<List<Integer>> q = new ArrayDeque<>(waits);
		while (!q.isEmpty()) {
			List<Integer> pop = q.pollFirst();
			int max = 0;
			if (!q.isEmpty()) {
				max = q.stream().mapToInt(temp -> temp.get(1)).max().getAsInt();
			}
			if (pop.get(1) < max) {
				q.add(pop);
			} else {
				finish.add(pop.get(0));
			}
		}
		return finish.indexOf(location) + 1;
	}

	public static void main(String[] args) {
		프린터 instance = new 프린터();
		int solution = instance.solution(new int[] {2, 1, 3, 2}, 2);
		System.out.println("solution = " + solution);
	}
}
