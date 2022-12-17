package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.IterTools;

public class 양궁대회 {

	public int[] solution(int n, int[] info) {
		List<Score> result = new ArrayList<>();
		List<Integer> scoreList = new ArrayList<>();
		for (int i = 10; -1 < i; i--) {
			scoreList.add(i);
		}
		IterTools<Integer> iterTools = new IterTools<>(scoreList, n);
		List<List<Integer>> combinationsReplacement = iterTools.combinationsReplacement();
		for (List<Integer> eachCase : combinationsReplacement) {
			int ryanScore = 0;
			int apeachScore = 0;

			// 각 점수별 개수 구하기
			for (int i = 0; i < info.length; i++) {
				int ryanNumTarget = 0;
				for (Integer integer : eachCase) {
					if (i == 10 - integer) {
						ryanNumTarget++;
					}
				}
				if (ryanNumTarget == 0 && info[i] == 0) {
					continue;
				} else if (ryanNumTarget <= info[i]) {
					apeachScore += 10 - i;
				} else {
					ryanScore += 10 - i;
				}
			}

			if (apeachScore < ryanScore) {
				result.add(new Score(ryanScore - apeachScore, eachCase));
			}
		}

		if (result.size() == 0) {
			return new int[] {-1};
		}
		Collections.sort(result);
		return result.get(0).scoreList.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		양궁대회 instance = new 양궁대회();
		int[] solution = instance.solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
		Arrays.stream(solution).forEach(System.out::println);
	}
}

class Score implements Comparable<Score> {
	public int totalDiffScore;
	public List<Integer> scoreList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

	public Score(int totalDiffScore, List<Integer> scoreList) {
		this.totalDiffScore = totalDiffScore;
		for (Integer integer : scoreList) {
			this.scoreList.set(10 - integer, this.scoreList.get(10 - integer) + 1);
		}
	}

	@Override
	public String toString() {
		return "Score{" +
			"totalScore=" + totalDiffScore +
			", scoreList=" + scoreList +
			'}';
	}

	@Override
	public int compareTo(Score o) {
		if (totalDiffScore != o.totalDiffScore) {
			return Integer.compare(o.totalDiffScore, totalDiffScore);
		}
		for (int i = scoreList.size() - 1; -1 < i; i--) {
			if (scoreList.get(i) != o.scoreList.get(i)) {
				return Integer.compare(o.scoreList.get(i), scoreList.get(i));
			}
		}
		return 0;
	}
}