package 프로그래머스.Lv3;

public class 가장긴팰린드롬 {
	public int solution(String s) {
		char[] chars = s.toCharArray();
		for (int i = chars.length; 0 < i; i--) {
			for (int j = 0; j < chars.length; j++) {
				if (chars.length < i + j) {
					break;
				}

				int reverseIdx = j + i - 1;
				boolean flag = false;
				for (int start = j; start < (j + i) / 2; start++) {
					if (chars[start] != chars[reverseIdx--]) {
						flag = true;
						break;
					}
				}
				if (flag) {
					continue;
				}
				return i;
					
				// String substring = s.substring(j, i + j);
				// String reverse = new StringBuilder(substring).reverse().toString();
				// if (substring.equals(reverse)) {
				// 	return i;
				// }
				// int reverseIdx = substring.length() - 1;
				// boolean flag = false;
				// for (int idx = 0; idx < substring.length() / 2; idx++) {
				// 	if (substring.charAt(idx) != substring.charAt(reverseIdx--)) {
				// 		flag = true;
				// 		break;
				// 	}
				// }
				// if (flag) {
				// 	continue;
				// }
				// return i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		가장긴팰린드롬 instance = new 가장긴팰린드롬();
		int solution = instance.solution("abcdcba");
		System.out.println("solution = " + solution);
	}
}
