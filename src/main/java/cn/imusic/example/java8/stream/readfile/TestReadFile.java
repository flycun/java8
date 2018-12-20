package cn.imusic.example.java8.stream.readfile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestReadFile {

	public static void main(String args[]) {

		String fileName = "D:/workspace/imusic/data-audit/areacode.csv";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName),Charset.forName("GBK"))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}