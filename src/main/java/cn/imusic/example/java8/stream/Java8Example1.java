package cn.imusic.example.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Java8Example1 {

    public static void main(String[] args) {

    	 List<String> lines = Arrays.asList("spring", "node", "mkyong","spring boot");

    	 lines.stream()                // convert list to stream
    	 		.distinct()
         		.filter(line -> !"mkyong".equals(line))     // we dont like mkyong
         		.sorted((s1,s2)->s1.length()-s2.length())
         		.map(line->line.toUpperCase())
         		.forEach(System.out::println);                //output : spring, node

//    Optional<String> longest=	 lines.stream().reduce((s1,s2)->s1.length()>=s2.length()?s1:s2);
    Optional<String> longest=	 lines.stream().max((s1,s2)->s1.length());
    System.out.println(longest.get());
    
    Integer lenSum=lines.stream().reduce(0, (sum,str)->sum+str.length(), (a,b)->a+b);
//    Integer lenSum=lines.stream().mapToInt(str->str.length()).sum();
    System.out.println(lenSum);
    
    lines.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式１
    lines.stream().collect(Collectors.toList());
    
    

    lines.stream().collect(Collectors.toSet());
    lines.stream().collect(Collectors.toMap(Function.identity(), String::length)).forEach((k,v)->System.out.println(k+" "+v));
    
    
    }
}