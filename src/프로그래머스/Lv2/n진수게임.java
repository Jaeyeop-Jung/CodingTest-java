package 프로그래머스.Lv2;

public class n진수게임 {

	public String solution(int n, int t, int m, int p) {
		String total = "";
		for (int i = 0; i < t * 2; i++) {
			// if (n <= i) {
			// 	String[] split = String.valueOf(i).split("");
			// 	for (String str : split) {
			// 		total += Integer.toString(Integer.valueOf(str), n);
			// 	}
			// } else {
			// 	total += Integer.toString(i, n).toUpperCase();
			// }
			total += Integer.toString(i, n).toUpperCase();
		}

		String result = "";
		int idx = 0;
		int cnt = 0;
		while (result.length() < t) {
			if (idx == p - 1) {
				result += total.charAt(cnt);
			}
			idx++;
			idx %= m;
			cnt++;
		}

		return result;
	}

	public static void main(String[] args) {
		n진수게임 instance = new n진수게임();
		String solution = instance.solution(16	, 16, 2, 1);
		System.out.println("solution = " + solution);
	}
}
