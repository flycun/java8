package cn.imusic.example.java8.stream;

import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {

        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<Book> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));

        List<StudentAndBook> collect1 = list.stream()
                .map(x -> x.getBook().stream()
                                    .map(t -> new StudentAndBook(x.getName(), t.getBookName()))
                                    .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);


    }

    public static class StudentAndBook {
        String name;
        String book;

        public StudentAndBook(String name, String book) {
            this.name = name;
            this.book = book;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", StudentAndBook.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("book='" + book + "'")
                    .toString();
        }
    }

    public static class Student {

        private String name;
        private Set<Book> book;

        public void addBook(String book) {
            if (this.book == null) {
                this.book = new HashSet<>();
            }
            this.book.add(new Book(book));
        }
        //getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Book> getBook() {
            return book;
        }


    }

    public static class Book {
        String bookName;

        public String getBookName() {
            return bookName;
        }

        public Book(String bookName) {
            this.bookName = bookName;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                    .add("bookName='" + bookName + "'")
                    .toString();
        }
    }

}
