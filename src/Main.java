import java1refresher.Book;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("PHP and MySQL", "Welling", true, 1000);
        Book book2 = new Book("Python", "Marc Hauschildt", false, 800);
        Book book3 = new Book("Java A Beginner's Guide", "Herbert", true, 688);
//        System.out.println(book1);
//        System.out.println(book2);
//        System.out.println(book3);
//        System.out.println(book3.getAuthor());
        //Book[] bookshelf = new Book[4];
        List<Book> bookshelf = new ArrayList<Book>();
//      OR:  List<Book> bookshelf = new LinkedList<>();
        bookshelf.add(book1);
        bookshelf.add(book2);
        bookshelf.add(book3);
        bookshelf.add(new Book("Java a Beginner's Guide", "Herbert Schildt", true, 720));
        Collections.sort(bookshelf);
        for (Book book: bookshelf) {
            System.out.println(book);
        }
        System.out.println("============================================================================");
        for (int i = 0; i < bookshelf.size(); i++) {
            System.out.println(bookshelf.get(i));
        }
        System.out.println();
        bookshelf.forEach(book -> System.out.println(book));
        System.out.println();
        bookshelf.forEach(System.out::println);
        System.out.println("Kirkwood".compareTo("Eagles"));
    }
}