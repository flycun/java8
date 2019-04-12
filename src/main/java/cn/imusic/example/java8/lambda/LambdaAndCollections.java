package cn.imusic.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaAndCollections {

	public static void main(String[] args) {
		List<String> alist = new ArrayList<>(Arrays.asList("I", "love", "you"));
		/*alist.forEach(new Consumer<String>() {
			@Override
			public void accept(String str) {
				if (str.length() > 3) {
					System.out.println(str);
				}
			}
		});*/

		alist.forEach(str -> {
			if (str.length() > 3) {
				System.out.println(str);
			}

		});
		
		/*alist.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String str) {
				return str.length()>3;
			}
		});*/
		
		alist.removeIf(str->str.length()>3);
		
		alist.replaceAll(str->{
			if (str.length()>3) {
				return str.toUpperCase();
			}
			return str;
		});
		
		alist.sort((s1,s2)->s1.length()-s2.length());
		
		
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.forEach((k,v)->System.out.println(k+":"+v));
		
		
		map.getOrDefault(4, "default");
		
		
	}

}
