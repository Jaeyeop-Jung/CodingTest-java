package 프로그래머스.Lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 더맵게 {
	public static void main(String[] args) {
		더맵게 instance = new 더맵게();
		int solution = instance.solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
		System.out.println("solution = " + solution);
	}


	public int solution(int[] scoville, int K) {
		List<Integer> scovileList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
		PriorityQueue<Integer> h = new PriorityQueue<>();
		int result = 0;
		h.addAll(scovileList);
		while (!h.isEmpty()) {
			if (K <= h.peek()) {
				return result;
			}
			if (h.size() == 1) {
				break;
			}
			h.add(h.poll() + h.poll() * 2);
			result += 1;
		}
		return -1;
	}
}
