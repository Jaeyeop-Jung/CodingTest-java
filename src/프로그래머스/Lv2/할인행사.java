package 프로그래머스.Lv2;

import java.util.*;

public class 할인행사 {
	public static Map<String, Integer> map = new HashMap<>();

	public boolean check(String[] want, int[] number) {
		for (int i = 0; i < want.length; i++) {
			if (!map.containsKey(want[i]) || map.get(want[i]) < number[i]) {
				return false;
			}
		}
		return true;
	}

	public int solution(String[] want, int[] number, String[] discount) {
		int result = 0;
		for (int i = 0; i < 10; i++) {
			map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
		}

		for (int i = 0; i < discount.length - 10; i++) {
			if (check(want, number)) {
				result += 1;
			}
			map.put(discount[i], map.get(discount[i]) - 1);
			if (map.get(discount[i]) <= 0) {
				map.remove(discount[i]);
			}
			map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
		}

		for (int i = discount.length - 10; i < discount.length; i++) {
			if (check(want, number)) {
				result += 1;
			}
			if (map.containsKey(discount[i])) {
				map.put(discount[i], map.get(discount[i]) - 1);
				if (map.get(discount[i]) <= 0) {
					map.remove(discount[i]);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		할인행사 instance = new 할인행사();
		int solution = instance.solution(
			new String[] {"banana", "apple", "rice", "pork", "pot"},
			new int[] {3, 2, 2, 2, 1},
			new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot",
				"banana", "apple", "banana"}
		);
		System.out.println(solution);
	}
}
