package cn.imusic.example.java8.stream;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestJava8 {

    public static void main(String[] args) {

        


    }
    
    
    private static void test () {
    	 String[] array = {"a", "b", "c", "d", "e"};
         Stream<String> stream = Arrays.stream(array);

         // loop a stream
         stream.forEach(x -> System.out.println(x));

         // reuse it to filter again! throws IllegalStateException
         long count = stream.filter(x -> "b".equals(x)).count();
         System.out.println(count);
         
         //get another new stream
    }
    
    private static void test2 () {
    	String[] array = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);
		
	}

}