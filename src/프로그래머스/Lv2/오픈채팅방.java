package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
	public static void main(String[] args) {
		오픈채팅방 instance = new 오픈채팅방();
		String[] solution = instance.solution(
			new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan"});
		System.out.println("solution = " + solution);
	}

	public String[] solution(String[] record) {
		Map<String, String> nameMap = new HashMap<>();
		for (String message : record) {
			String[] split = message.split(" ");
			if (split[0].startsWith("E")) {
				nameMap.put(split[1], split[2]);
			} else if (split[0].startsWith("C")) {
				nameMap.put(split[1], split[2]);
			}
		}

		List<String> result = new ArrayList<>();
		for (String message : record) {
			String[] split = message.split(" ");
			if (split[0].startsWith("E")) {
				result.add(nameMap.get(split[1]) + "님이 들어왔습니다.");
			} else if (split[0].startsWith("L")) {
				result.add(nameMap.get(split[1]) + "님이 나갔습니다.");
			}
		}

		return result.toArray(new String[0]);
	}
}
