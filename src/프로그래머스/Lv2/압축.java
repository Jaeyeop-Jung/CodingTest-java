package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class 압축 {

	public static Map<String, Integer> dic = new HashMap<>();
	public static int cnt = 0;

	public void init() {
		IntStream.rangeClosed('A', 'Z')
			.mapToObj(var -> (char)var)
			.map(var -> var.toString())
			.forEach(var -> dic.put(var, cnt++));
	}

	public int[] solution(String msg) {
		init();
		List<Integer> result = new ArrayList<>();

		int idx = 0;
		while (idx < msg.length()) {
			int endIdx = idx + 1;
			boolean flag = false;
			while (endIdx <= msg.length()) {
				String substring = msg.substring(idx, endIdx);
				if (dic.containsKey(substring)) {
					endIdx++;
				} else {
					dic.put(substring, cnt++);
					endIdx--;
					result.add(dic.get(msg.substring(idx, endIdx)) + 1);
					idx = endIdx;
					flag = true;
					break;
				}
			}
			if (!flag) {
				result.add(dic.get(msg.substring(idx, endIdx - 1)) + 1);
				idx = endIdx;
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}


	public static void main(String[] args) {
		압축 instacne = new 압축();
		int[] kakaos = instacne.solution("KAKAO");
		Arrays.stream(kakaos).forEach(System.out::println);
	}
}
