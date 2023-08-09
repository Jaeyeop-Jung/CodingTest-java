package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2563 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			r--;
			c--;
			for (int curR = r; curR < r + 10; curR++) {
				for (int curC = c; curC < c + 10; curC++) {
					visited[curR][curC] = true;
				}
			}
		}
		int res = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (visited[r][c]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
