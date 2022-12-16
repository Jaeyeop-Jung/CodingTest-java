package 프로그래머스.Lv3;

import java.util.*;

public class 여행경로 {

	public List<List<String>> result = new ArrayList<>();

	public String[] solution(String[][] tickets) {
		Map<String, List<Ticket>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			List<Ticket> orDefault = map.getOrDefault(ticket[0], new ArrayList<>());
			orDefault.add(new Ticket(ticket[0], ticket[1], false));
			map.put(ticket[0], orDefault);
		}

		List<String> visited = new ArrayList<>();
		visited.add("ICN");
		dfs(map, tickets.length + 1, visited, "ICN");

		// System.out.println("result = " + result);
		if (result.size() == 1) {
			result.get(0).toArray(new String[0]);
		}
		result.sort(new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				for (int i = 0; i < o1.size(); i++) {

					int temp = o1.get(i).compareTo(o2.get(i));
					if (temp != 0) {
						return temp;
					}
				}
				return 0;
			}
		});
		return result.get(0).toArray(new String[0]);
	}

	public void dfs(Map<String, List<Ticket>> map, int n, List<String> visited, String cur) {
		if (n == visited.size()) {
			result.add(new ArrayList<>(visited));
			return;
		}

		if (!map.containsKey(cur)) {
			return;
		}
		for (int i = 0; i < map.get(cur).size(); i++) {
			Ticket ticket = map.get(cur).get(i);
			ticket.used = true;
			visited.add(ticket.to);
			dfs(map, n, visited, ticket.to);
			visited.remove(visited.size() - 1);
			ticket.used = false;
		}
	}

	public static void main(String[] args) {
		여행경로 instance = new 여행경로();
		String[] solution = instance.solution(new String[][] { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" } });
		Arrays.stream(solution).forEach(System.out::println);
	}
}

class Ticket {
	public String from;
	public String to;
	public boolean used;

	public Ticket(String from, String to, boolean used) {
		this.from = from;
		this.to = to;
		this.used = used;
	}
}
