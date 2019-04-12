package cn.imusic.example.java8.lambda;

import java.io.File;
import java.io.FileFilter;

public class Lam1 {
	public static void main(String[] args) {
		File dir = new File("D:\\data\\applogs");
		
		File[] list=dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		/*
		
		FileFilter fileFilter=f->f.isDirectory();*/
		
		/*File[] files=dir.listFiles(f->f.isDirectory());
		List<File> stream=Stream.of(files).filter(file->file.getName().equals("boss")).collect(Collectors.toList());
		stream.forEach(item->{
			System.out.println(item.getName());
			
		});*/
	}
	
	
}
