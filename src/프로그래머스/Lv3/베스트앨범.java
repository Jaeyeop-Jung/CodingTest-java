package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 베스트앨범 {

	public int[] solution(String[] genres, int[] plays) {
		Map<String, Map<Integer, Integer>> map = new HashMap<>();
		Map<String, Integer> genrePlay = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				Map<Integer, Integer> temp = map.get(genres[i]);
				temp.put(i, temp.getOrDefault(i, 0) + plays[i]);
			} else {
				Map<Integer, Integer> temp = new HashMap<>();
				temp.put(i, plays[i]);
				map.put(genres[i], temp);
			}
			genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);
		}

		List<Integer> result = new ArrayList<>();
		List<Map.Entry<String, Integer>> genreRankings = genrePlay.entrySet().stream()
			.sorted(Comparator.comparing((Map.Entry<String, Integer> each) -> each.getValue()).reversed())
			.collect(Collectors.toList());
		for (Map.Entry<String, Integer> genreRanking : genreRankings) {
			String key = genreRanking.getKey();
			Map<Integer, Integer> eachSongs = map.get(key);
			List<List<Integer>> songRankings = eachSongs.entrySet().stream()
				.map(each -> Arrays.asList(each.getKey(), each.getValue()))
				.sorted(
					Comparator.comparing((List<Integer> each) -> each.get(1)).reversed()
						.thenComparing((List<Integer> each) -> each.get(0))
				)
				.collect(Collectors.toList());

			for (int i = 0; i < Math.min(songRankings.size(), 2); i++) {
				result.add(songRankings.get(i).get(0));
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		베스트앨범 instance = new 베스트앨범();
		int[] solution = instance.solution(new String[] {"classic", "pop", "classic", "classic", "pop"},
			new int[] {500, 600, 150, 800, 2500});
		Arrays.stream(solution).forEach(System.out::println);
	}
}
