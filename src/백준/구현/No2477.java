package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

public class No2477 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[6][];
		int maxIdx = -1;
		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			String[] temp = br.readLine().split(" ");
			int t1 = Integer.parseInt(temp[0]);
			int t2 = Integer.parseInt(temp[1]);
			arr[i] = new int[] {t1, t2};
			if (maxLength < t2) {
				maxIdx = i;
				maxLength = t2;
			}
		}

		int maxGaro = maxLength;
		int maxSeroIdx = 0;
		if (maxIdx - 1 < 0) {
			maxSeroIdx = 6 + maxIdx - 1;
		} else {
			maxSeroIdx = maxIdx - 1;
		}
		int maxSero = Math.max(arr[maxSeroIdx][1], arr[(maxIdx + 1) % 6][1]);

		int res = maxGaro * maxSero;
		int start = 0;
		for (int i = 0; i < 6; i++) {
			int next = (i + 1) % 6;
			if (arr[i][0] == arr[(i + 2) % 6][0] && arr[next][0] == arr[(next + 2) % 6][0]) {
				start = i;
				break;
			}
		}

		res -= arr[(start + 1) % 6][1] * arr[(start + 2) % 6][1];
		System.out.println(res * k);
	}
}
