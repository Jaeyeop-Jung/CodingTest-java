package 백준.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1074 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int r, c;

	public static void main(String[] args) throws IOException {
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		r = Integer.parseInt(split[1]);
		c = Integer.parseInt(split[2]);

		findLocation((int)Math.pow(2, n) / 2, 0, 0, 0);
	}

	static void findLocation(int size, int sR, int sC, int cnt) {
		if (size == 0) {
			if (sR == r && sC == c) {
				System.out.println(cnt);
				System.exit(0);
			}
			return;
		}
		int nextR = sR + size;
		int nextC = sC + size;
		if (sR <= r && r < nextR && sC <= c && c < nextC) {
			findLocation(size / 2, sR, sC, cnt);
		} else if (sR <= r && r < nextR && nextC <= c && c < nextC + size) {
			findLocation(size / 2, sR, nextC, cnt + size * size);
		} else if (nextR <= r && r < nextR + size && sC <= c && c < nextC) {
			findLocation(size / 2, nextR, sC, cnt + size * size * 2);
		} else {
			findLocation(size / 2, nextR, nextC, cnt + size * size * 3);
		}
	}
}
