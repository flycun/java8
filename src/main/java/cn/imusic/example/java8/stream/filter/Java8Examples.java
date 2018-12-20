package cn.imusic.example.java8.stream.filter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Examples {

    public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

        //List<String> result = language.collect(Collectors.toList());

       // List<String> result = language.filter(x -> x!=null).collect(Collectors.toList());
        List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());

        result.forEach(System.out::println);


    }
}