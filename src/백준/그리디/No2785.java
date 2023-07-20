package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No2785 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer sb = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(sb.nextToken());
		}

		List<Integer> list = Arrays.stream(arr)
				.sorted()
				.boxed()
				.collect(Collectors.toList());




		int res = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>(list);
		while (2 < q.size()) {
			res++;

			Integer first = q.pollFirst();
			Integer pop1 = q.pollLast();
			Integer pop2 = q.pollLast();
			q.addLast(pop1 + pop2);
			if (0 < first - 1) {
				q.addFirst(first - 1);
			}
		}

		if (q.size() == 2) {
			res++;
		}

		System.out.println(res);
	}
}
