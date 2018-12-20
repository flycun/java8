package cn.imusic.example.java8.lambda;

import java.util.Arrays;
import java.util.List;

public final class Lam4 {
	public boolean isEven(int number) {
		System.out.println("isEven:"+number);
		return number % 2 == 0;
	}

	public int doubleIt(int number) {
		System.out.println("doubleIt:"+number);
		return number * 2;
	}

	public boolean isGreaterThan5(int number) {
		System.out.println("isGreaterThan5:"+number);
		return number > 5;
	}

	public static void main(String[] args) {
		Lam4 lam4=new Lam4();
		lam4.test2(lam4);
//		lam4.test();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(  
			    numbers.stream()  
			            .filter(lam4::isEven)  
			            .map(lam4::doubleIt)  
			            .filter(lam4::isGreaterThan5)  
			            .findFirst().get()
			); 
	}

	public boolean test() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		for (int number : numbers) {
			if (isEven(number)) {
				int n2 = doubleIt(number);
				if (isGreaterThan5(n2)) {
					System.out.println(n2);
					break;
				}
			}
		}
		
		
		return true;
	}
	public boolean test2(Lam4 lazy) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(  
			    numbers.stream()  
			            .filter(lazy::isEven)  
			            .map(lazy::doubleIt)  
			            .filter(lazy::isGreaterThan5)  
			            .findFirst()  
			); 
		return true;
	}
	
}
	