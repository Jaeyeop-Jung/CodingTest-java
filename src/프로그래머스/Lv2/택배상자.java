package 프로그래머스.Lv2;

import java.util.*;

public class 택배상자 {

	public int solution(int[] order) {
		int n = order.length;
		Stack<Integer> stack = new Stack<>();
		Deque<Integer> q = new ArrayDeque<>();

		int postIdx = 1;
		int orderIdx = 0;
		while (postIdx < n + 1) {
			if (postIdx == order[orderIdx]) {
				q.add(postIdx++);
				orderIdx++;
			} else {
				if (!stack.isEmpty() && stack.peek() == order[orderIdx]) {
					q.add(stack.pop());
					orderIdx++;
				} else {
					stack.add(postIdx);
					postIdx++;
				}
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == order[orderIdx]) {
				q.add(stack.pop());
				orderIdx++;
			} else {
				break;
			}
		}

		return q.size();
	}

	public static void main(String[] args) {
		택배상자 instance = new 택배상자();
		// int solution = instance.solution(new int[] {4, 3, 1, 2, 5});
		// int solution = instance.solution(new int[] {5, 4, 3, 2, 1});
		int solution = instance.solution(new int[] {1, 3, 2, 4, 5});
		System.out.println("solution = " + solution);
	}
}
