package cn.imusic.example.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lam3 {
	public int sumAll(List<Integer> numbers, Predicate<Integer> p) {
		int total = 0;
		for (int number : numbers) {
			if (p.test(number)) {
				total += number;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Lam3 lam3=new Lam3();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		lam3.sumAll(numbers, n -> true);
		lam3.sumAll(numbers, n -> n % 2 == 0);
		lam3.sumAll(numbers, n -> n > 3);
	}
}
