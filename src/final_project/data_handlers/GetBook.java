package final_project.data_handlers;

import final_project.MyException;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import java1refresher.Book;
import java1refresher.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GetBook implements MyDataHandler{

    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        // title,author,read,numPages,datePublished,unitPrice
        String userIn = UserInput.getString("Search for book by their id, author name," +
                "day published (YYYY-MM-DD)", scanner);
        try{
            // Search by id
            int id = Integer.parseInt(userIn);
            Book book = (Book) data_source.get(id);
            if(book == null) {
                System.out.println("No person found with id '" + id + "'.");
            } else {
                System.out.println("\nRetrieved:");
                System.out.println(book);
            }
        } catch(NumberFormatException e1){
            // Search by author name
            try{
                List<Book> list = (List<Book>)data_source.get(userIn);
                if(list.size() == 0) {
                    System.out.println("No person found with first or last name containing '" + userIn +"'.");
                } else {
                    System.out.println("Retrieved:");
                    for(Book book: list) {
                        System.out.println(book);
                    }
                }
            } catch(IllegalFormatException e2) {
                // Search by date published
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate datePublished = LocalDate.parse(userIn, formatterInput);
                List<Book> list = (List<Book>) data_source.get(datePublished);
                if (list.size() == 0) {
                    System.out.println("No book found with date published '" + datePublished + "'.");
                } else {
                    System.out.println("\nRetrieved:");
                    for (Book book : list) {
                        System.out.println(book);
                    }
                }
            }
        }
    }
}
