package 프로그래머스.Lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 기능개발 {
	public static void main(String[] args) {
		기능개발 instance = new 기능개발();
		// int[] solution = instance.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		int[] solution = instance.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});
		System.out.println("solution = " + solution);
	}


	public int[] solution(int[] progresses, int[] speeds) {
		if (progresses.length <= 1) {
			return new int[] {1};
		}

		int[] temp = new int[progresses.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
		}
		ArrayList<Integer> result = new ArrayList<>();
		List<Integer> q = Arrays.stream(temp).boxed().collect(Collectors.toList());
		int maxi = q.get(0);
		int cnt = 1;
		for (int i = 1; i < q.size(); i++) {
			Integer pop = q.get(i);
			if (maxi < pop) {
				maxi = pop;
				result.add(cnt);
				cnt = 1;
			} else {
				cnt += 1;
			}
		}
		if (q.get(q.size() - 2) <= q.get(q.size() - 1) || cnt != 1) {
			result.add(cnt);
		}
		return result.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
