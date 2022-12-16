package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 주차요금계산 {

	public int getMinute(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}

	public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> eachCost = new HashMap<>();
		Map<String, Integer> eachTime = new HashMap<>();
		Map<String, Integer> eachParked = new HashMap<>();

		// 23:59분전 타임 구하기
		for (String record : records) {
			String[] split = record.split(" ");
			int minute = getMinute(split[0]);
			if (split[2].startsWith("IN")) {
				eachParked.put(split[1], minute);
			} else {
				int parkedTime = minute - eachParked.get(split[1]);
				eachTime.put(split[1], eachTime.getOrDefault(split[1], 0) + parkedTime);
				eachParked.remove(split[1]);
			}
		}

		// 23:59까지 출차 안된 타임 구하기
		int minute = getMinute("23:59");
		for (String key : eachParked.keySet()) {
			int parkedTime = minute - eachParked.get(key);
			eachTime.put(key, eachTime.getOrDefault(key, 0) + parkedTime);
		}

		// 비용 계산하기
		for (String key : eachTime.keySet()) {
			Integer totalParkedTime = eachTime.get(key);
			if (totalParkedTime <= fees[0]) {
				eachCost.put(key, fees[1]);
				continue;
			}
			totalParkedTime -= fees[0];
			int totalCost = fees[1];
			totalCost += Math.ceil((double) totalParkedTime / fees[2]) * fees[3];
			eachCost.put(key, totalCost);
		}

		List<String> keys = eachCost.keySet().stream().sorted().collect(Collectors.toList());
		return keys.stream().map(key -> eachCost.get(key)).mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		주차요금계산 instacne = new 주차요금계산();
		int[] solution = instacne.solution(
			new int[] {1, 461, 1, 10},
			new String[] {"00:00 1234 IN"});
		Arrays.stream(solution)
			.forEach(System.out::println);
	}
}
