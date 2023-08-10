package 백준.경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3040 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void combinations(int[] arr, int idx, int cnt, int[] cur, int total) {
		if (cnt == 7) {
			if (total == 100) {
				for (int res : cur) {
					System.out.println(res);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			cur[cnt] = arr[i];
			combinations(arr, i + 1, cnt + 1, cur, total + arr[i]);
			cur[cnt] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combinations(arr, 0, 0, new int[7], 0);
	}
}
