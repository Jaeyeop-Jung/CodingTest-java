package 프로그래머스.Lv2;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new int[] {0, 3, 9, 10, 20});
		System.out.println("solution1 = " + solution1);
	}
}

class Solution {
	public int solution(int[] citations) {
		citations = Arrays.stream(citations).sorted().toArray();
		int result = 0;
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;
			if (citations[i] <= h) {
				h = Math.min(h, citations[i]);
			}
			result = Math.max(result, h);
		}
		return result;
	}
}