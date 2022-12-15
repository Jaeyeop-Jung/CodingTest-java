package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {
	public static void main(String[] args) {
		배달 instance = new 배달();
		int solution = instance.solution(5,
			new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
		System.out.println("solution = " + solution);
	}

	public int solution(int N, int[][] road, int K) {
		List<List<List<Integer>>> graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] each : road) {
			graph.get(each[0] - 1).add(Arrays.asList(each[1] - 1, each[2]));
			graph.get(each[1] - 1).add(Arrays.asList(each[0] - 1, each[2]));
		}

		int[] distance = new int[N];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[0] = 0;
		PriorityQueue<Node> h = new PriorityQueue<>();
		h.add(new Node(0, 0));
		while (!h.isEmpty()) {
			Node pop = h.poll();
			if (distance[pop.location] < pop.distance) {
				continue;
			}
			for (List<Integer> next : graph.get(pop.location)) {
				int totalDistance = pop.distance + next.get(1);
				if (distance[next.get(0)] < totalDistance) {
					continue;
				}
				distance[next.get(0)] = totalDistance;
				h.add(new Node(next.get(0), totalDistance));
			}
		}

		return (int) Arrays.stream(distance).filter(each -> each <= K).count();
	}

}

class Node implements Comparable<Node> {
	public int location;
	public int distance;

	public Node(int location, int distance) {
		this.location = location;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(distance, o.distance);
	}

	@Override
	public String toString() {
		return "Node{" +
			"location=" + location +
			", distance=" + distance +
			'}';
	}
}