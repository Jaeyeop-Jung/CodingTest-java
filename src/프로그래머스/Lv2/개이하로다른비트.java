package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 개이하로다른비트 {
	public long[] solution(long[] numbers) {
		List<Long> result = new ArrayList<>();

		for (long number : numbers) {
			String binary = Long.toBinaryString(number);
			int index = binary.lastIndexOf("0");
			Long temp;
			if (index == -1) {
				temp = Long.parseLong("10" + binary.substring(1), 2);
			} else if (index == binary.length() - 1) {
				temp = Long.parseLong(binary.substring(0, index) + '1' + binary.substring(index + 1), 2);
			} else {
				temp = Long.parseLong(binary.substring(0, index) + "10" + binary.substring(index + 2), 2);
			}
			result.add(temp);
		}
		System.out.println("result = " + result);
		return result.stream().mapToLong(l -> l).toArray();
	}

	public static void main(String[] args) {
		개이하로다른비트 instance = new 개이하로다른비트();
		Long[] longs = {9L};
		long[] solution = instance.solution(Arrays.stream(longs).mapToLong(i -> i).toArray());
		System.out.println("solution = " + solution);
	}
}
