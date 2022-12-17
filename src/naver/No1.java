package naver;

import java.util.*;

public class No1 {
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] result = new int[2];

		List<Integer> paymentList = new ArrayList<>();
		for (int[] payment : payments) {
			paymentList.add(Arrays.stream(payment).sum());
		}

		// for (int i = 0; i < periods.length; i++) {
		// 	if (periods[i] < 23) {
		// 		continue;
		// 	}
		//
		// 	if (periods[i] == 23) {
		// 		boolean beforeVip = isVip(periods[i], paymentList.get(i));
		// 		paymentList.set(i, paymentList.get(i) - payments[i][payments[i].length - 1]);
		// 		boolean afterVip = isVip(periods[i] + 1, paymentList.get(i));
		// 		if (!beforeVip && afterVip) {
		// 			result[0]++;
		// 		}
		//
		// 	} else if (23 < periods[i] && periods[i] < 59) {
		// 		boolean beforeVip = isVip(periods[i], paymentList.get(i));
		// 		boolean afterVip = isVip(periods[i] + 1, paymentList.get(i));
		// 		if (!beforeVip && afterVip) {
		// 			result[0]++;
		// 		} else if (beforeVip && !afterVip) {
		// 			result[1]++;
		// 		}
		//
		// 	} else if (periods[i] == 59) {
		// 		boolean beforeVip = isVip(periods[i], paymentList.get(i));
		// 		paymentList.set(i, paymentList.get(i) - payments[i][payments[i].length - 1]);
		// 		boolean afterVip = isVip(periods[i] + 1, paymentList.get(i));
		// 		if (!beforeVip && afterVip) {
		// 			result[0]++;
		// 		} else if (beforeVip && !afterVip) {
		// 			result[1]++;
		// 		}
		// 	} else {
		// 		boolean beforeVip = isVip(periods[i], paymentList.get(i));
		// 		paymentList.set(i, paymentList.get(i) - payments[i][payments[i].length - 1]);
		// 		boolean afterVip = isVip(periods[i] + 1, paymentList.get(i));
		// 		if (!beforeVip && afterVip) {
		// 			result[0]++;
		// 		} else if (beforeVip && !afterVip) {
		// 			result[1]++;
		// 		}
		// 	}
		// }

		for (int i = 0; i < periods.length; i++) {
			if (periods[i] < 23) {
				continue;
			}
			boolean beforeVip = isVip(periods[i], paymentList.get(i));
			paymentList.set(i, paymentList.get(i) - payments[i][0] + estimates[i]);
			boolean afterVip = isVip(periods[i] + 1, paymentList.get(i));

			if (!beforeVip && afterVip) {
				result[0] ++;
			} else if (beforeVip && !afterVip) {
				result[1] ++;
			}
		}

		return result;
	}

	public boolean isVip(int period, int payment) {
		if (period < 24) {
			return false;
		} else if (24 <= period && period < 60) {
			if (900000 <= payment) {
				return true;
			}
			return false;
		} else {
			if (600000 <= payment) {
				return true;
			}
			return false;
		}
	}


	public static void main(String[] args) {
		No1 instance = new No1();
		int[] solution = instance.solution(
			new int[] {24, 59, 59, 60},
			new int[][]{{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}},
			new int[] {350000, 50000, 40000, 50000}
		);
		System.out.println(solution[0] + " " + solution[1]);
	}
}
