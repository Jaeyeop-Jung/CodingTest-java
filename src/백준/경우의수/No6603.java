package 백준.경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No6603 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<List<Integer>> res;

	static void combinations(int[] arr, int idx, int cnt, List<Integer> list) {
		if (cnt == 6) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (idx == arr.length) {
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			list.add(arr[i]);
			combinations(arr, i + 1, cnt + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			int[] arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			res = new ArrayList<>();
			combinations(arr, 0, 0, new ArrayList<Integer>());
			StringBuilder sb = new StringBuilder();
			for (List<Integer> re : res) {
				sb.append(
						re.toString()
							.replace("[", "")
							.replace("]", "")
							.replace(",", "") + "\n"
				);
			}
			System.out.println(sb);
		}
	}
}
