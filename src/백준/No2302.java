// TODO 틀림
package 백준;

import java.util.Scanner;

public class No2302 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		int m = Integer.parseInt(sc.nextLine());
		int[] ints = new int[m];
		for (int i = 0; i < m; i++) {
			ints[i] = Integer.parseInt(sc.nextLine());
		}
		int result = 1;

		if (m == 0) {
			System.out.println(n + 1);
			System.exit(0);
		}
		int idx = 0;
		int cnt = 0;
		for (int i = 1; i < n + 1; i++) {
			if (ints[idx] == i) {
				result *= cnt;
				cnt = 0;
				if (idx + 1 < ints.length) {
					idx++;
				}
				continue;
			}
			cnt++;
		}
		if (cnt != 0) {
			result *= cnt;
		}
		System.out.println(result);
	}
}
