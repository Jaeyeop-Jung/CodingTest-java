package 프로그래머스.Lv3;

import java.util.*;

public class 이중우선순위큐 {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> h = new PriorityQueue<>();
		for (String operation : operations) {
			String[] split = operation.split(" ");
			if (split[0].equals("I")) {
				h.add(Integer.parseInt(split[1]));
			} else {
				if (h.isEmpty()) {
					continue;
				}

				if (split[1].equals("1")) {
					int asInt = h.stream().mapToInt(i -> i).max().getAsInt();
					h.remove(asInt);
				} else {
					h.poll();
				}
			}
		}

		if (h.isEmpty()) {
			return new int[]{0, 0};
		}
		return new int[]{
			h.stream().mapToInt(i -> i).max().getAsInt(),
			h.poll(),
		};
	}

	public static void main(String[] args) {
		이중우선순위큐 instance = new 이중우선순위큐();
		int[] solution = instance.solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
		Arrays.stream(solution)
			.forEach(System.out::println);
	}
}
