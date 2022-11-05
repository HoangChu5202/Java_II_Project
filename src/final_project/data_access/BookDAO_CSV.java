package final_project.data_access;

import final_project.MyException;
import java1refresher.Book;
import java1refresher.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO_CSV implements MyDAO<Book>{
    private static final String FILE_NAME = "src/main/resources/csv_file/book.csv";
    private ArrayList<Book> list;
    private int next_id = 0;
    @Override
    public void readInData() throws MyException {
        try(Scanner scanner = new Scanner(new File(FILE_NAME))) {
            list = new ArrayList<Book>();
            String line = "";
            int lineCount = 1;
            String[] fields;
            // id,title,author,read,numPages,datePublished,unitPrice
            int id;
            String title;
            String author;
            boolean isRead;
            int numPages;
            LocalDate datePublished;
            double unitPrice;
            line = scanner.nextLine(); // reads in header row
            while(scanner.hasNextLine()) {
                lineCount++;
                line = scanner.nextLine();
                fields = line.split(",");
                try {
                    id = Integer.parseInt(fields[0]);
                    title = fields[1];
                    String[] authorName = fields[2].split(" ");
                    isRead = Boolean.getBoolean(fields[3]);
                    numPages = Integer.parseInt(fields[4]);
                    datePublished = LocalDate.parse(fields[5]);
                    unitPrice = Double.parseDouble(fields[6]);
                } catch(NumberFormatException e) {
                    throw new MyException("Number error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                } catch(DateTimeParseException e) {
                    throw new MyException("Date error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                }
                Person person = new Person();
                Book book = new Book();
                for(Book b : list) {
                    if(b.getId() == id) {
                        throw new MyException("Duplicate id error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                    }
                }
//                book.setId(id);
//                book.setTitle(title);
//                book.setAuthor(author);
//
//                list.add(person);
//                if(id > next_id) {
//                    next_id = id;
//                }
            }

        } catch(FileNotFoundException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public void add(Book obj) throws MyException {

    }

    @Override
    public Book get(int id) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(String str) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return null;
    }

    @Override
    public void set(int id, Book obj) throws MyException {

    }

    @Override
    public boolean remove(Book obj) throws MyException {
        return false;
    }
}
