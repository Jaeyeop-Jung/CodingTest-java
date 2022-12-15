// TODO 틀림

package 프로그래머스.Lv2;

import java.util.*;
import java.util.stream.Collectors;

import util.IterTools;

public class 혼자놀기의달인 {

	// public int result = 0;
	//
	// public int solution(int[] cards) {
	// 	List<Boolean> visited = new ArrayList<>();
	// 	for (int i = 0; i < cards.length; i++) {
	// 		visited.add(false);
	// 	}
	// 	dfs(cards, new ArrayList<List<Integer>>(), visited);
	// 	return result;
	// }
	//
	// public void dfs(int[] cards, List<List<Integer>> group, List<Boolean> visited) {
	// 	if (!visited.contains(false)) {
	// 		List<Integer> length = group.stream()
	// 			.map(temp -> temp.size())
	// 			.sorted(Comparator.reverseOrder())
	// 			.collect(Collectors.toList());
	// 		if (length.size() == 1) {
	// 			return;
	// 		}
	// 		result = Math.max(result, length.get(0) * length.get(1));
	// 		return;
	// 	}
	//
	// 	for (int i = 0; i < cards.length; i++) {
	// 		if (visited.get(i)) {
	// 			continue;
	// 		}
	// 		List<Integer> temp = new ArrayList<>();
	// 		int idx = i;
	// 		while (true) {
	// 			if (!visited.get(idx)) {
	// 				temp.add(idx);
	// 				visited.set(idx, true);
	// 				idx = cards[idx] - 1;
	// 			} else {
	// 				group.add(temp);
	// 				break;
	// 			}
	// 		}
	// 		dfs(cards, group, visited);
	// 		List<Integer> remove = group.remove(group.size() - 1);
	// 		for (Integer removeIdx : remove) {
	// 			visited.set(removeIdx, false);
	// 		}
	// 	}
	// }

	public int result = 0;

	public int solution(int[] cards) {
		List<Integer> cardList = Arrays.stream(cards).boxed().collect(Collectors.toList());
		IterTools<Integer> iterTools = new IterTools<>(cardList, 1);
		List<List<Integer>> combinations = iterTools.combinations();
		for (int i = 0; i < combinations.size(); i++) {
			List<Integer> copy = new ArrayList<>(cardList);
			List<Integer> group1 = new ArrayList<>();
			int idx = combinations.get(i).get(0) - 1;
			while (true) {
				if (copy.get(idx) != -1) {
					group1.add(idx);
					Integer temp = copy.get(idx) - 1;
					copy.set(idx, -1);
					idx = temp;
				} else {
					break;
				}
			}

			List<Integer> copy2 = copy.stream().filter(each -> each != -1).collect(Collectors.toList());
			IterTools<Integer> iterTools2 = new IterTools<>(copy2, 1);
			List<List<Integer>> combinations2 = iterTools2.combinations();
			List<Integer> group2 = new ArrayList<>();
			for (int j = 0; j < combinations2.size(); j++) {
				idx = combinations2.get(j).get(0) - 1;
				while (true) {
					if (copy.get(idx) != -1) {
						group2.add(idx);
						Integer temp = copy.get(idx) - 1;
						copy.set(idx, -1);
						idx = temp;
					} else {
						break;
					}
				}
				result = Math.max(result, group1.size() * group2.size());
			}

		}

		return result;
	}

	public static void main(String[] args) {
		혼자놀기의달인 instance = new 혼자놀기의달인();
		int solution = instance.solution(new int[] {8, 6, 3, 7, 2, 5, 1, 4});
		System.out.println("solution = " + solution);

	}
}
