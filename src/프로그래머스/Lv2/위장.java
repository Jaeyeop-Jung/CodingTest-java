package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 위장 {


	public static void main(String[] args) {
		위장 instance = new 위장();
		instance.solution(
			new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
	}

	public int solution(String[][] clothes) {
		Map<String, List<String>> kind = new HashMap<>();
		for (String[] cloth : clothes) {
			if (!kind.containsKey(cloth[1])) {
				ArrayList<String> strings = new ArrayList<>();
				strings.add(cloth[0]);
				kind.put(cloth[1], strings);
			} else {
				kind.get(cloth[1]).add(cloth[0]);
			}
		}
		for (String key : kind.keySet()) {
			kind.get(key).add("-");
		}

		int result = 1;
		for (String key : kind.keySet()) {
			result *= kind.get(key).size();
		}
		return result - 1;
	}
}
