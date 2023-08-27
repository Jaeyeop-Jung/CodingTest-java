package 싸피.B형_특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 중위순회 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			Map<Integer, Node> tree = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] split = br.readLine().split(" ");
				if (split.length == 2) {
					tree.put(Integer.parseInt(split[0]), new Node(split[1], -1, -1));
				} else if (split.length == 3) {
					tree.put(Integer.parseInt(split[0]), new Node(split[1], Integer.parseInt(split[2]), -1));
				} else {
					tree.put(Integer.parseInt(split[0]), new Node(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3])));
				}
			}

			StringBuilder sb = new StringBuilder();
			order(tree, 1, sb);
			System.out.printf("#%d %s\n", tc, sb);
		}
	}

	static void order(Map<Integer, Node> tree, int cur, StringBuilder sb) {
		if (cur == -1) {
			return;
		}
		order(tree, tree.get(cur).left, sb);
		sb.append(tree.get(cur).cur);
		order(tree, tree.get(cur).right, sb);
	}
}

class Node {
	String cur;
	int left, right;

	public Node(String cur, int left, int right) {
		this.cur = cur;
		this.left = left;
		this.right = right;
	}
}