package 백준;

import java.util.*;

public class No1238 {
	public static Scanner sc = new Scanner(System.in);

	public static int[] dijkstra(int n, List<List<City>> graph, int start) {
		PriorityQueue<City> q = new PriorityQueue<>();
		q.add(new City(start, 0));
		int[] targetToOtherDistance = new int[n];
		for (int i = 0; i < n; i++) {
			targetToOtherDistance[i] = Integer.MAX_VALUE;
		}
		targetToOtherDistance[start] = 0;
		while (!q.isEmpty()) {
			City pop = q.poll();
			if (targetToOtherDistance[pop.location] < pop.distance) {
				continue;
			}
			for (City nextCity : graph.get(pop.location)) {
				int totalCost = pop.distance + nextCity.distance;
				if (targetToOtherDistance[nextCity.location] < totalCost) {
					continue;
				}
				q.add(new City(nextCity.location, totalCost));
				targetToOtherDistance[nextCity.location] = totalCost;
			}
		}
		return targetToOtherDistance;
	}

	public static void main(String[] args) {
		String[] split = sc.nextLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int target = Integer.parseInt(split[2]);
		List<List<City>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			split = sc.nextLine().split(" ");
			graph.get(Integer.parseInt(split[0]) - 1).add(new City(Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2])));
		}

		int[] targetToOther = dijkstra(n, graph, target - 1);
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (i == target - 1) {
				continue;
			}
			int[] otherToTarget = dijkstra(n, graph, i);
			result = Math.max(result, otherToTarget[target - 1] + targetToOther[i]);
		}

		System.out.println(result);
	}
}

class City implements Comparable<City> {
	public int location;
	public int distance;

	public City(int location, int distance) {
		this.location = location;
		this.distance = distance;
	}

	@Override
	public int compareTo(City o) {
		return Integer.compare(distance, o.distance);
	}
}
