// TODO 틀림

package 싸피;

import java.util.Arrays;
import java.util.Scanner;

public class No14510 {
	public static void main(String[] args) {
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
			// int cnt = 0;
			// for (int i = 0; i < arr.length; i++) {
			// 	if (3 <= maxValue - arr[i]) {
			// 		int temp = (int) Math.floor((maxValue - arr[i]) / 3);
			// 		cnt += temp * 2;
			// 		arr[i] += temp * 3;
			// 	}
			// }
			//
			// // 1갯수, 2갯수 센다
			// // 1갯수, 2갯수 중에 작은거까지 *2 더하기
			// // 작은 개수 *2 더하기
			//
			// long cnt1 = Arrays.stream(arr).filter(value -> maxValue - value == 1).count();
			// long cnt2 = Arrays.stream(arr).filter(value -> maxValue - value == 2).count();
			//
			// if (cnt1 < cnt2) {
			// 	cnt += cnt1 * 2;
			// 	cnt2 -= cnt1;
			// 	if (1 == cnt2) {
			// 		cnt += 2;
			// 	} else {
			// 		cnt2 *= 2;
			// 		int cur = 1;
			// 		while (0 <= cnt2) {
			// 			if (cnt2 - cur == 0) {
			// 				cnt++;
			// 				break;
			// 			}
			// 			else if (cnt2 - cur < 0) {
			// 				cnt ++;
			// 				break;
			// 			} else {
			// 				cnt++;
			// 				cnt2 -= cur;
			// 			}
			// 			cur++;
			// 			if (cur == 3) {
			// 				cur = 1;
			// 			}
			// 		}
			// 	}
			// } else if (cnt2 < cnt1) {
			// 	cnt += cnt2 * 2;
			// 	cnt1 -= cnt2;
			// 	if (cnt1 == 1) {
			// 		cnt++;
			// 	} else {
			// 		cnt += 2 * cnt1 - 1;
			// 	}
			// } else {
			// 	cnt += cnt2 * 2;
			// }

			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = maxValue - arr[i];
			}

			for (int i = 0; i < arr.length; i++) {
				while (0 < arr[i]) {
					if (arr[i] == 1) {
						cnt1++;
						arr[i]--;
						break;
					}
					if (cnt1 < cnt2) {
						cnt1++;
						arr[i]--;
					} else {
						cnt2++;
						arr[i] -= 2;
					}
				}
			}

			if (cnt1 == cnt2) {
				System.out.printf("#%d %d\n", testCase, cnt2 * 2);
			} else if (cnt1 < cnt2) {
				int res = cnt1 * 2;
				cnt2 -= cnt1;
				cnt2 *= 2;
				int cur = 1;
				while (0 < cnt2) {
					if (cnt2 == 1) {
						res++;
						break;
					}
					cnt2 -= cur;
					cur++;
					res++;
					if (cur == 3) {
						cur = 1;
					}
				}
				System.out.printf("#%d %d\n", testCase, res);
			} else {
				System.out.printf("#%d %d\n", testCase, (cnt2 * 2 + (cnt1 - cnt2) * 2 - 1));
			}
		}
	}
}
