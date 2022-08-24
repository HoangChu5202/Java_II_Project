import java1refresher.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Python", "Marc Hauschildt", false, 800);
        Book book3 = new Book("Java A Beginner's Guide", "Herbert", true, 688);
//        System.out.println(book1);
//        System.out.println(book2);
//        System.out.println(book3);
//        System.out.println(book3.getAuthor());
        Book[] bookself = new Book[4];
        bookself[0] = book1;
        bookself[1] = book2;
        bookself[2] = book3;

        for (Book book: bookself) {
            System.out.println(book);
        }

        for (int i = 0; i < Book.getBookCount(); i++) {
            System.out.println(bookself[i]);
        }
    }
}