package cn.imusic.example.java8.lambda;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lam1 {
	public static void main(String[] args) {
		File dir = new File("D:\\data\\applogs");
		/*FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		
		File[] list=dir.listFiles(directoryFilter);
		
		FileFilter fileFilter=f->f.isDirectory();*/
		
		File[] files=dir.listFiles(f->f.isDirectory());
		List<File> stream=Stream.of(files).filter(file->file.getName().equals("boss")).collect(Collectors.toList());
		stream.forEach(item->{
			System.out.println(item.getName());
			
		});
	}
}
