package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import util.IterTools;

public class 메뉴리뉴얼 {
	public String[] solution(String[] orders, int[] course) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			// 글자별 Combination 객체를 담을 맵
			Map<String, Combination> map = new HashMap<>();
			for (int j = 0; j < orders.length; j++) {

				// orders를 글자수별로 끊는 조합을 가져옴
				IterTools<String> iterTools = new IterTools<>(Arrays.stream(orders[j].split("")).collect(Collectors.toList()), course[i]);
				List<List<String>> combinations = iterTools.combinations();

				// 구한 글자수별 조합으로 Combination 객체를 생성하여 count를 늘림
				for (List<String> combination : combinations) {
					StringBuilder sb = new StringBuilder();
					for (String s : combination) {
						sb.append(s);
					}
					String toString = Arrays.stream(sb.toString().split(""))
						.sorted()
						.collect(Collectors.joining());
					Combination orDefault = map.getOrDefault(toString, new Combination(toString, 0));
					orDefault.count++;
					map.put(toString, orDefault);
				}
			}

			// 글자수로 끊은 글자별 카운트를 갖는 객체 리스트를 구함
			List<Combination> combinations = map.entrySet().stream()
				.map(entry -> entry.getValue())
				.sorted()
				.collect(Collectors.toList());

			if (combinations.size() == 0) {
				continue;
			}
			int maxCount = combinations.get(combinations.size() - 1).count;
			for (Combination combination : combinations) {
				if (combination.count == maxCount && 2 <= combination.count) {
					result.add(combination.combination);
				}
			}
		}
		System.out.println("result = " + result);
		return result.stream().sorted().toArray(String[]::new);
	}

	public static void main(String[] args) {
		메뉴리뉴얼 instance = new 메뉴리뉴얼();
		String[] solution = instance.solution(new String[] {"XYZ", "XWY", "WXA"},
			new int[] {2, 3, 4});
		System.out.println("solution = " + solution);
	}
}

class Combination implements Comparable<Combination> {
	public String combination;
	public int count;

	public Combination(String combination, int count) {
		this.combination = combination;
		this.count = count;
	}

	@Override
	public int compareTo(Combination o) {
		return Integer.compare(count, o.count);
	}

	@Override
	public String toString() {
		return "Combination{" +
			"combination='" + combination + '\'' +
			", count=" + count +
			'}';
	}
}
