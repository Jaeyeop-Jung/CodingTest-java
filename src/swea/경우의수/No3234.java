package swea.경우의수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3234 {
	static int[] weight;
	static int N, ans, whole;
	static boolean used[];
	static int[] factorial ={1,1,2,6,24,120,720,5040,40320,362880};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			used = new boolean[N];
			ans = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				whole += weight[i];
			}

			// func(0, 0, 0);
			for (int i = 1; i <= N; i++) {
				combinations(i, 0, 0, 0);
			}


			System.out.println("#"+tc+" "+ans);
		}
	}

	static void combinations(int n, int idx, int cnt, int left) {
		if (cnt == n) {
			if (whole - left <= left) {
				ans += factorial[N - n];
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			combinations(n, i, cnt + 1, left + weight[i]);
		}
	}

	// static void func(int cnt, int left, int right) {
	// 	if (cnt == N) {
	// 		ans++;
	// 		return;
	// 	}
	//
	// 	if(right + (whole - left - right) <= left){
	// 		ans += factorial[N-cnt] * (int)Math.pow(2, N-cnt);;
	// 		return;
	// 	}
	//
	//
	//
	// 	for (int i = 0; i < N; i++) {
	// 		if (used[i]) continue;
	// 		used[i] = true;
	// 		func(cnt + 1, left + weight[i], right);
	// 		if (left >= right + weight[i]) {
	// 			func(cnt + 1, left, right + weight[i]);
	// 		}
	// 		used[i] = false;
	// 	}
	// }

}
