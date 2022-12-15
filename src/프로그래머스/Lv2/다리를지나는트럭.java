package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다리를지나는트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int second = 0;
		List<Integer> pass = new ArrayList<>();
		List<List<Integer>> cur = new ArrayList<>();
		int curTotalWeight = 0;

		int idx = 0;
		while (true) {
			if (pass.size() == truck_weights.length) {
				break;
			}
			second += 1;
			if (!cur.isEmpty() && cur.get(0).get(1) == second) {
				List<Integer> remove = cur.remove(0);
				pass.add(remove.get(0));
				curTotalWeight -= remove.get(0);
			}
			if (idx < truck_weights.length && curTotalWeight + truck_weights[idx] <= weight) {
				cur.add(Arrays.asList(truck_weights[idx], second + bridge_length));
				curTotalWeight += truck_weights[idx];
				idx += 1;
			}
		}

		return second;
	}

	public static void main(String[] args) {
		다리를지나는트럭 instance = new 다리를지나는트럭();
		int solution = instance.solution(2, 10, new int[] {7, 4, 5, 6});
		System.out.println("solution = " + solution);
	}
}
