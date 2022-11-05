package java1refresher;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private Person author;
    private boolean read;
    private int numPages;
    private LocalDate datePublished;
    private double unitPrice;
    public static final String DEFAULT_TITLE = "Undefined";
    private static final LocalDate DEFAULT_DATE_PUBLISHED = LocalDate.now();
    private static final double DEFAULT_UNIT_PRICE = 1.00;
    public static int bookCount = 0;

    public Book() {
        title = DEFAULT_TITLE;
        author = new Person();
        read = false;
        numPages = 1;
        bookCount++;
        datePublished = DEFAULT_DATE_PUBLISHED;
        unitPrice =DEFAULT_UNIT_PRICE;
    }

    public Book(String title) {
        this.title = title;
        author = new Person();
        read = false;
        numPages = 1;
        bookCount++;
        datePublished = DEFAULT_DATE_PUBLISHED;
        unitPrice =DEFAULT_UNIT_PRICE;
    }

    public Book(String title, Person author, boolean read, int numPages) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        bookCount++;
        datePublished = DEFAULT_DATE_PUBLISHED;
        unitPrice = DEFAULT_UNIT_PRICE;
    }

    public Book(String title, Person author, boolean read, int numPages, LocalDate datePublished, double unitPrice) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        bookCount++;
        setDatePublished(datePublished);
        setUnitPrice(unitPrice);
    }

    public static int getBookCount() {
        return bookCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals("")) {
            throw new IllegalArgumentException("The title is required");
        } else {
            this.title = title;
        }
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        if (author==null) {
            throw new IllegalArgumentException("The author name is required");
        } else {
            this.author = author;
        }
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        if (numPages < 0) {
            throw new IllegalArgumentException("There must be at least one page.");
        } else {
            this.numPages = numPages;
        }
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        if (datePublished.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Date published can not be in the future");
        } else {
            this.datePublished = datePublished;
        }
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Price can not be negative");
        } else {
            this.unitPrice = Math.round(unitPrice*100.0)/100.0;
        }
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.title) * -1;
        if (result == 0) {
            result = (this.numPages - o.numPages) * -1;
        }
//        if (result == 0) {
//            result = (this.author.compareTo(o.author));
//        }
        if (result == 0) {
            result = (this.datePublished.compareTo(o.datePublished));
        }
        return result;
    }
}
