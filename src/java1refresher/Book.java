package java1refresher;

public class Book implements Comparable<Book>{
    private String title;
    private Person author;
    private boolean read;
    private int numPages;
    private static final String DEFAULT_TITLE = "Undefined";
    private static int bookCount = 0;

    public Book() {
        title = DEFAULT_TITLE;
        author = new Person();
        read = false;
        numPages = 1;
        bookCount++;
    }

    public Book(String title, Person author, boolean read, int numPages) {
        setTitle(title);
        setAuthor(author);
        setRead(read);
        setNumPages(numPages);
        bookCount++;
    }

    public static int getBookCount() {
        return bookCount;
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
        if (author.equals("")) {
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", read=" + read +
                ", numPages=" + numPages +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.title) * -1;
        if (result==0) {
            result = (this.numPages - o.numPages) * -1;
        }
        return result;
    }
}
