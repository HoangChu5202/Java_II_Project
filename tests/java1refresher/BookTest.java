package java1refresher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;
    private Person author = new Person("John", "Doe");
    @BeforeEach
    void setUp() {
        book = new Book();
    }

    @Test
    void getTitle() {
        assertEquals(Book.DEFAULT_TITLE, book.getTitle());
    }

    @Test
    void setTitle() {
        //good test
        book.setTitle("Java the beginning guide");
        assertEquals("Java the beginning guide", book.getTitle());

        //bad test
        Exception e = assertThrows(IllegalArgumentException.class, () -> book.setTitle(""));
        assertEquals("The title is required", e.getMessage());
    }

    @Test
    void getAuthor() {
       // assertEquals(author, book.getAuthor());
        assertEquals(author.getFirstName(), book.getAuthor().getFirstName());
        assertEquals(author.getLastName(), book.getAuthor().getLastName());
    }

    @Test
    void setAuthor() {
        //good test
        Person goodTestAuthor = new Person("Hoang", "Chu");
        book.setAuthor(goodTestAuthor);
        assertEquals("Hoang", book.getAuthor().getFirstName());
        assertEquals("Chu", book.getAuthor().getLastName());
        //bad test
        //Person badTestAuthor1 = new Person("", "");
        //Exception e = assertThrows(IllegalArgumentException.class, () -> book.setAuthor(badTestAuthor1));
        //assertEquals("The author name is required", e.getMessage());
    }

    @Test
    void isRead() {
        assertEquals(false, book.isRead());
    }

    @Test
    void setRead() {
        book.setRead(true);
        assertEquals(true, book.isRead());
    }

    @Test
    void getNumPages() {
        assertEquals(1, book.getNumPages());
    }

    @Test
    void setNumPages() {
        //good code
        book.setNumPages(20);
        assertEquals(20, book.getNumPages());
        //bad code
        Exception e = assertThrows(IllegalArgumentException.class, () -> book.setNumPages(-6));
        assertEquals("There must be at least one page.", e.getMessage());
    }

    @Test
    void getDatePublished() {
        assertEquals(LocalDate.now(), book.getDatePublished());
    }

    @Test
    void setDatePublished() {
        // good test
        LocalDate goodTest = LocalDate.of(2022, 2, 12);
        book.setDatePublished(LocalDate.of(2022, 2, 12));
        assertEquals(goodTest, book.getDatePublished());
        //bad test
        LocalDate badTest = LocalDate.of(2023,2,12);
        Exception e = assertThrows(IllegalArgumentException.class, () -> book.setDatePublished(badTest));
        assertEquals("Date published can not be in the future", e.getMessage());
    }

    @Test
    void getUnitPrice() {
        assertEquals(1.0, book.getUnitPrice());
    }

    @Test
    void setUnitPrice() {
        //good test
        book.setUnitPrice(99.99999);
        assertEquals(100.00, book.getUnitPrice());
        //bad test
        Exception e = assertThrows(IllegalArgumentException.class, () -> book.setUnitPrice(-6.2));
        assertEquals("Price can not be negative", e.getMessage());
    }

    @Test
    void testToString() {
        assertEquals("Book{" +
                "title='" + Book.DEFAULT_TITLE + '\'' +
                ", author=" + Person.DEFAULT_FIRST_NAME + " " + Person.DEFAULT_LAST_NAME +
                ", read=" + false +
                ", numPages=" + 1 +
                ", datePublished=" + LocalDate.now() +
                ", unitPrice=" + 1.00 +
                '}', book.toString());
    }

    @Test
    void testCompareTo() {
        Person person1 = new Person("Amy", "Hauschildt");
        Person person2 = new Person("Marc", "Hauschildt");
        Person person3 = new Person("Jane", "Doe");
        Book book1 = new Book("Java The Beginning Guide", person1, false, 100);
        Book book2 = new Book("C# The Beginning Guide", person2, false, 100);
        Book book5 = new Book("C# The Beginning Guide", person3, false, 100);
        Book book3 = new Book("My SQL", person3, true, 200);
        Book book4 = new Book("My SQL", person3, true, 200, LocalDate.of(2022, 8, 19), 13.657);

        assertTrue(book1.compareTo(book2) < 0); // Java to C#
        assertTrue(book3.compareTo(book4) > 0); // Today day to 8/19/2022
        assertTrue(book2.compareTo(book5) > 0); // Marc Hauschildt to Jane Doe
    }
}