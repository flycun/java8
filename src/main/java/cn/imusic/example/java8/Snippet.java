package cn.imusic.example.java8;

public class Snippet {
	public static void main(String[] args) {
		try {
		  // do something
			System.out.println("bb");
		  System.exit(1);
		} finally{
		  System.out.println("aa");
		}
		
	}
}

