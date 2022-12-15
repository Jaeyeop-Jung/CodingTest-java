package 프로그래머스.Lv2;

import java.util.*;

public class 캐시 {
	public static void main(String[] args) {
		캐시 instance = new 캐시();
		int solution = instance.solution(
			2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}
		);
		System.out.println("solution = " + solution);
	}

	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		cities = Arrays.stream(cities).map(city -> city.toLowerCase()).toArray(String[]::new);
		int result = 0;
		List<String> cache = new ArrayList<>();
		for (String city : cities) {
			if (cache.isEmpty()) {
				cache.add(city);
				result += 5;
				continue;
			}

			if (cache.size() < cacheSize) {
				if (cache.contains(city)) {
					cache.remove(city);
					cache.add(city);
					result += 1;
				} else {
					cache.add(city);
					result += 5;
				}
			} else {
				if (cache.contains(city)) {
					cache.remove(city);
					cache.add(city);
					result += 1;
				} else {
					cache.remove(0);
					cache.add(city);
					result += 5;
				}
			}
		}
		return result;
	}
}
