package 싸피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p2029 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int [] dR = {0, 1, 0, -1};
	static int [] dC = {1, 0, -1, 0};

	// public static void main(String[] args) throws IOException {
	// 	int n = Integer.parseInt(br.readLine());
	// 	int[][] arr = new int[n][n];
	// 	for (int i = 0; i < n; i++) {
	// 		StringTokenizer sb = new StringTokenizer(br.readLine());
	// 		for (int j = 0; j < n; j++) {
	// 			arr[i][j] = Integer.parseInt(sb.nextToken());
	// 		}
	// 	}
	//
	// 	int res = 0;
	// 	for (int r = 0; r < n; r++) {
	// 		for (int c = 0; c < n; c++) {
	// 			if (arr[r][c] == 1) {
	// 				for (int d = 0; d < 4; d++) {
	// 					int temp = 1;
	// 					int movedR = r + dR[d], movedC = c + dC[d];
	// 					while ((0 <= movedR && movedR < n && 0 <= movedC && movedC < n) && arr[movedR][movedC] == 0) {
	// 						temp++;
	// 						movedR += dR[d];
	// 						movedC += dC[d];
	// 					}
	// 					res = Math.max(res, temp);
	// 				}
	// 			}
	// 		}
	// 	}
	//
	// 	System.out.println("res = " + res);
	// }
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];

		// 지도 정보 입력 받기
		for ( int r = 0 ; r < n ; r++ ) {
			for ( int c = 0 ; c < n ; c++ ) {
				map[r][c] = sc.nextInt();
			}
		}

		// 최대값 저장
		int maxDistance = 0;

		for ( int r = 0 ; r < n ; r++ ) {
			for ( int c = 0 ; c < n ; c++ ) {

				// 지금 위치가 섬인지 검사
				if ( map[r][c] == 1 ) {

					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장

					// 동쪽이 1인지 검사
					for (int d = 1; d < n ; d++) {
						if ( n <= c + d || map[r][c + d] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}

					// 서쪽이 1인지 검사
					for (int d = 1; d < n ; d++) {
						if ( c - d < 0 || map[r][c - d] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}

					// 북쪽이 1인지 검사
					for (int d = 1; d < n ; d++) {
						if ( r - d < 0 || map[r - d][c] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}

					// 남쪽이 1인지 검사
					for (int d = 1; d < n ; d++) {
						if ( n <= r + d || map[r + d][c] == 1 ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
				}
			}
		}

		System.out.println(maxDistance);

	}
}
