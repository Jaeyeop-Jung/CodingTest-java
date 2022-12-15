package util;

import java.util.ArrayList;
import java.util.List;

public class IterTools<T> {
	private List<T> list;
	private List<Boolean> visited = new ArrayList<>();
	private int count;
	private List<List<T>> result = new ArrayList<>();

	public IterTools(List<T> list, int count) {
		this.list = list;
		this.count = count;
		for (int i = 0; i < list.size(); i++) {
			visited.add(false);
		}
	}

	public List<List<T>> permutations() {
		permuationsDfs(new ArrayList<>(), 0);
		return result;
	}

	private void permuationsDfs(List<T> tempResult, int count) {
		if (this.count == count) {
			result.add(new ArrayList<>(tempResult));
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (visited.get(i)) {
				continue;
			}
			tempResult.add(list.get(i));
			visited.set(i, true);
			permuationsDfs(tempResult, count + 1);
			tempResult.remove(tempResult.size() - 1);
			visited.set(i, false);
		}
	}

	public List<List<T>> permuationsReplacement() {
		List<T> tempResult = new ArrayList<>();
		permuationsReplacementDfs(tempResult, 0);
		return result;
	}

	private void permuationsReplacementDfs(List<T> tempResult, int count) {
		if (this.count == count) {
			result.add(new ArrayList<>(tempResult));
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			tempResult.add(list.get(i));
			permuationsReplacementDfs(tempResult, count + 1);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	public List<List<T>> combinations() {
		combinationsDfs(new ArrayList<T>(), 0, 0);
		return result;
	}

	private void combinationsDfs(List<T> tempResult, int start, int count) {
		if (this.count == count) {
			result.add(new ArrayList<>(tempResult));
			return;
		}

		for (int i = start; i < list.size(); i++) {
			visited.set(i, true);
			tempResult.add(list.get(i));
			combinationsDfs(tempResult, i + 1, count + 1);
			visited.set(i, false);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	public List<List<T>> combinationsReplacement() {
		combinationsReplacementDfs(new ArrayList<T>(), 0, 0);
		return result;
	}

	private void combinationsReplacementDfs(List<T> tempResult, int count, int idx) {
		if (this.count == count) {
			result.add(new ArrayList<>(tempResult));
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			tempResult.add(list.get(i));
			combinationsReplacementDfs(tempResult, count + 1, i);
			tempResult.remove(tempResult.size() - 1);
		}
	}
}
