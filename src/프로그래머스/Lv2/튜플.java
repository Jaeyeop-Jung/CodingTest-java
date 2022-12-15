package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 튜플 {

	public static void main(String[] args) {
		튜플 instance = new 튜플();
		int[] solution = instance.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
		for (int i : solution) {
			System.out.print(i);
		}
	}

	public int[] solution(String s) {
		s = s.substring(1, s.length() - 1);
		String[] split = s.split("},");
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].substring(1, split[i].length());
		}
		split[split.length - 1] = split[split.length - 1].substring(0, split[split.length - 1].length() - 1);

		ArrayList<List<Integer>> list = new ArrayList<>();
		for (String str : split) {
			ArrayList<Integer> integers = new ArrayList<>();
			String[] temp = str.split(",");
			for (String integer : temp) {
				integers.add(Integer.parseInt(integer));
			}
			list.add(integers);
		}
		list.sort(Comparator.comparing(List::size));

		ArrayList<Integer> result = new ArrayList<>();
		for (List<Integer> integers : list) {
			for (Integer integer : integers) {
				if (!result.contains(integer)) {
					result.add(integer);
				}
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}
