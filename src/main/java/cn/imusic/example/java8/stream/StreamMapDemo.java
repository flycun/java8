package cn.imusic.example.java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapDemo {

	public static void main(String[] args) {

       test3();

    }



    private static void test3() {
         List<Staff> staff = Arrays.asList(
                 new Staff("mkyong", 30, new BigDecimal(10000)),
                 new Staff("jack", 27, new BigDecimal(20000)),
                 new Staff("lawrence", 33, new BigDecimal(30000))
         );

 		// convert inside the map() method directly.
         List<StaffPublic> result = staff.stream().map(temp -> {
             StaffPublic obj = new StaffPublic();
             obj.setName(temp.getName());
             obj.setAge(temp.getAge());
             if ("mkyong".equals(temp.getName())) {
                 obj.setExtra("this field is for mkyong only!");
             }
             return obj;
         })
         
         .collect(Collectors.toList());

         System.out.println(result);

    }
	private static void test2() {
		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20), new Person("lawrence",
				40));

		String name = persons.stream()
				.filter(x -> "jack".equals(x.getName()))
				.map(Person::getName) // convert stream to
				.findAny()
				.orElse("");

		System.out.println("name : " + name);

		List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());

		collect.forEach(System.out::println);

	}

	private static void test1() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");

		// Before Java8
		List<String> alphaUpper = new ArrayList<>();
		for (String s : alpha) {
			alphaUpper.add(s.toUpperCase());
		}

		System.out.println(alpha); // [a, b, c, d]
		System.out.println(alphaUpper); // [A, B, C, D]

		// Java 8
		List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect); // [A, B, C, D]

		// Extra, streams apply to any data type.
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(collect1); // [2, 4, 6, 8, 10]
	}
	
	

}