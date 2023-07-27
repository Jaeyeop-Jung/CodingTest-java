package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class No12789 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		List<Integer> arr = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		ArrayDeque<Integer> q = new ArrayDeque<>(arr);
		Stack<Integer> stack = new Stack<>();
		int idx = 1;
		while (idx <= n) {
			// stack에 있을 때
			if (!stack.isEmpty() && stack.peek() == idx) {
				idx++;
				stack.pop();
				continue;
			}

			// q 에서 바로 나올 때
			while (!q.isEmpty() && q.peekFirst() != idx) {
				stack.add(q.pollFirst());
			}
			if (!q.isEmpty() && q.peekFirst() == idx) {
				q.pollFirst();
				idx++;
			} else {
				break;
			}
		}

		if (idx == n + 1) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
