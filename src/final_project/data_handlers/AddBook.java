package final_project.data_handlers;

import final_project.MyException;
import final_project.UIUtility;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import java1refresher.Book;
import java1refresher.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddBook implements MyBookDataHandler{
    @Override
    public void handleTask(MyDAO book_data_source, MyDAO person_data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        Book book = new Book();
        // title,author,read,numPages,datePublished,unitPrice
        // set title
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                String userIn = UserInput.getString("Enter Book's title", scanner);
                book.setTitle(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // set author
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                String userIn = UserInput.getString("Enter author's name", scanner);
                Person author = new Person();
                author.setFirstNameAndLastName(userIn);
                int id = person_data_source.getAll().size();
                author.setId(id);
                person_data_source.add(author);
                book.setAuthor(author);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // isRead
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                String[] possibleInput = new String[]{"yes", "no"};
                String userIn = UserInput.validateString("Did you read this book yet", possibleInput, scanner, messages);
                boolean isRead = userIn.equals("yes") ? true : false;
                book.setRead(isRead);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // set numPage
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                int userIn = UserInput.getIntInRange("How many page does this book have", 0, 10000, scanner, messages);
                book.setNumPages(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // set datePublished
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                LocalDate userIn = LocalDate.from(UserInput.getDate("What day this book published", scanner, messages));
                book.setDatePublished(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // set unitPrice
        for(;;) {
            try {
                // String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                Double userIn = UserInput.getDouble("How much does this book cost", scanner, messages);
                book.setUnitPrice(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        book_data_source.add(book);
        UIUtility.showSectionTitle("Book added");
    }
}
