package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No2212 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		if (n <= k) {
			System.out.println(0);
			return;
		}
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(each -> Integer.parseInt(each))
				.sorted()
				.toArray();
		int[] diff = new int[arr.length - 1];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}
		System.out.println(
				Arrays.stream(diff)
						.sorted()
						.limit(n - k)
						.sum()
		);
	}
}
