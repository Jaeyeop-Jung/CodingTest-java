package naver;

import java.util.*;

public class No3 {

	public int result = 0;

	public int solution(int[][] games) {
		List<Game> gameList = new ArrayList<>();
		for (int[] game : games) {
			gameList.add(new Game(game[0], game[1], game[2]));
		}
		//
		// dfs(gameList, 0, 0, 0);
		//
		// return new int[] {result};
		Collections.sort(gameList);
		Set<Integer> notDay = new HashSet<>();
		for (Game game : gameList) {
			notDay.add(game.discountDay);
		}
		int notDiscountCnt = notDay.stream().max(Comparator.naturalOrder()).get() + 1 - notDay.size();
		int idx = 0;
		for (int i = 0; i < notDiscountCnt; i++) {
			Game game = gameList.get(idx++);
			result += game.originalPrice;
			game.buy = true;
		}
		for (Game game : gameList) {
			if (!game.buy) {
				result += game.discountPrice;
			}
		}


		return result;
	}

	public void dfs(List<Game> gameList, int numOfBuy, int cur, int price) {
		if (numOfBuy == gameList.size()) {
			result = Math.min(result, price);
			return;
		}
		for (int i = 0; i < gameList.size(); i++) {
			Game game = gameList.get(i);
			if (game.buy) {
				continue;
			}

			if (game.discountDay == cur) {
				game.buy = true;
				dfs(gameList, numOfBuy + 1, cur + 1, price + game.discountPrice);
				game.buy = false;

				game.buy = true;
				dfs(gameList, numOfBuy + 1, cur, price + game.discountPrice);
				game.buy = false;
			}
			game.buy = true;
			// } else {
				dfs(gameList, numOfBuy + 1, cur + 1, price + game.originalPrice);
			// }
			game.buy = false;
		}
	}


	public static void main(String[] args) {
		No3 instance = new No3();
		// int solution = instance.solution(new int[][] {{66000, 0, 50}, {16000, 2, 10}, {84500, 3, 20}, {5500, 2, 75}});
		// int[] solution = instance.solution(new int[][] {{100, 0, 50}, {1000, 0, 50}, {10000, 0, 50}});
		int solution = instance.solution(new int[][] {{100, 2, 50}, {100, 2, 50}, {1000, 4, 50}, {1000, 4, 50}, {1000, 4, 50}});
		// int[] solution = instance.solution(new int[][] {{100, 0, 50}, {100, 0, 50}, {100, 0, 50}, {10000, 3, 50}});
		// Arrays.stream(solution).forEach(System.out::println);
		System.out.println("solution = " + solution);
	}
}

class Game implements Comparable<Game> {
	public boolean buy = false;
	public int originalPrice;
	public int discountDay;
	public int discountPer;
	public int discountPrice;

	public Game(int originalPrice, int discountDay, int discountPer) {
		this.originalPrice = originalPrice;
		this.discountDay = discountDay;
		this.discountPer = discountPer;
		this.discountPrice = (int) originalPrice * (100 - discountPer) / 100;
	}

	@Override
	public int compareTo(Game o) {
		// return Integer.compare(originalPrice - discountPrice, o.originalPrice - o.discountPrice);
		return Integer.compare(discountPrice, o.discountPrice);
	}

	@Override
	public String toString() {
		return "Game{" +
			"originalPrice=" + originalPrice +
			", discountDay=" + discountDay +
			", discountPer=" + discountPer +
			", discountPrice=" + discountPrice +
			'}';
	}
}