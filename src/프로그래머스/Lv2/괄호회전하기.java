package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 괄호회전하기 {
	public boolean isCorrect(List<String> list) {
		Stack<String> stack = new Stack<>();
		for (String s : list) {
			if (stack.isEmpty() && (s.equals(")") || s.equals("]") || s.equals("}"))) {
				return false;
			} else if (s.equals("(") || s.equals("[") || s.equals("{")) {
				stack.push(s);
			} else if (s.equals(")")) {
				if (!stack.peek().equals("(")) {
					return false;
				}
				stack.pop();
			} else if (s.equals("}")) {
				if (!stack.peek().equals("{")) {
					return false;
				}
				stack.pop();
			} else if (s.equals("]")) {
				if (!stack.peek().equals("[")) {
					return false;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	public int solution(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			List<String> collect = Arrays.stream(s.split("")).collect(Collectors.toList());
			Collections.rotate(collect, i);
			if (isCorrect(collect)) {
				result += 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		괄호회전하기 괄호회전하기 = new 괄호회전하기();
		int solution = 괄호회전하기.solution("(");
		System.out.println("solution = " + solution);
	}
}
