package cn.imusic.example.java8.lambda.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	 public static void main(String[] args) {
		 List<String> lines = Arrays.asList("spring", "node", "mkyong");
	     List<String> lines2 = Arrays.asList("spring", "node");

	     List<String> result = lines.stream()                // convert list to stream
	             .filter(line -> !lines2.contains(line))     // we dont like mkyong
	             .collect(Collectors.toList());              // collect the output and convert streams to a List

	     result.forEach(System.out::println);                //output : spring, node
	}
}
