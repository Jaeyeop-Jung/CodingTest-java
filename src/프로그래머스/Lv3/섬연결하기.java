package 프로그래머스.Lv3;

import java.util.*;

public class 섬연결하기 {
	public static void main(String[] args) {
		섬연결하기 instance = new 섬연결하기();
		int solution = instance.solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
		System.out.println("solution = " + solution);
	}

	public int findParent(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}

	public void unionParent(int[] parent, int x, int y) {
		int a = findParent(parent, x);
		int b = findParent(parent, y);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	public int solution(int n, int[][] costs) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		PriorityQueue<Node> graph = new PriorityQueue<>();
		for (int i = 0; i < costs.length; i++) {
			graph.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
			graph.add(new Node(costs[i][1], costs[i][0], costs[i][2]));
		}

		int result = 0;
		while (!graph.isEmpty()) {
			Node pop = graph.poll();
			if (findParent(parent, pop.from) != findParent(parent, pop.to)) {
				unionParent(parent, pop.from, pop.to);
				result += pop.cost;
			}
		}
		return result;
	}
}

class Node implements Comparable<Node> {
	public int from;
	public int to;
	public int cost;

	public Node(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(cost, o.cost);
	}
}
