package 백준;

import java.util.*;
import java.util.stream.Collectors;

public class No10825 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String[] split = s.split(" ");
			list.add(Arrays.asList(
				split[0],
				split[1],
				split[2],
				split[3]
			));
		}
		List<List<String>> collect = list.stream()
			.sorted(
				Comparator.comparing((List<String> temp) -> Integer.parseInt(temp.get(1))).reversed()
					.thenComparing((List<String> temp) -> Integer.parseInt(temp.get(2))).reversed()
					.thenComparing((List<String> temp) -> Integer.parseInt(temp.get(3))).reversed()
					.thenComparing((List<String> temp) -> temp.get(0))
			)
			.collect(Collectors.toList());

		// collect.stream()
		// 	.forEach(temp -> System.out.println(temp.get(0)));
		for (List<String> strings : collect) {
			System.out.println(strings.get(0));
		}
	}
}
