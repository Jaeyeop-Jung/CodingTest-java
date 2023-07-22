// TODO 틀림

package 싸피;

import java.util.Arrays;
import java.util.Scanner;

public class No14510 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int testCase = 1; testCase <= T; testCase++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			int maxValue = Arrays.stream(arr).max().getAsInt();

			for (int i = 0; i < arr.length; i++) {
				arr[i] = maxValue - arr[i];
			}

			int day = 0;
			int cur = 1;
			int rest = Arrays.stream(arr).sum();

			while (0 < rest) {
				if (cur == 1 && rest == 2) {
					boolean final2 = false;
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] == 2) {
							day += 2;
							final2 = true;
							break;
						}
					}
					if (!final2) {
						day += 3;
					}
					break;
				}

				boolean use1 = false;
				boolean use2 = false;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == 0) {
						continue;
					}
					if (cur == 1 && arr[i] % 2 == 1) {
						arr[i]--;
						rest--;
						use1 = true;
						break;
					} else if (cur == 2 && arr[i] % 2 == 0) {
						arr[i] -= 2;
						rest -= 2;
						use2 = true;
						break;
					}
				}
				if (use1 == false && cur == 1 && 3 <= rest) {
					for (int i = 0; i < arr.length; i++) {
						if (3 <= arr[i]) {
							arr[i] --;
							rest--;
							break;
						}
					}
				}
				if (use2 == false && cur == 2) {
					for (int i = 0; i < arr.length; i++) {
						if (3 <= arr[i]) {
							arr[i] -= 2;
							rest -= 2;
							break;
						}
					}
				}
				day++;
				cur++;
				if (cur == 3) {
					cur = 1;
				}
			}

			System.out.printf("#%d %d\n", testCase, day);
		}
	}
}
