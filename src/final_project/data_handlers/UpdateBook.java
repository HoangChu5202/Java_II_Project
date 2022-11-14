package final_project.data_handlers;

import final_project.MyException;
import final_project.UIUtility;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import java1refresher.Book;
import java1refresher.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UpdateBook implements MyBookDataHandler{
    @Override
    public void handleTask(MyDAO book_data_source, MyDAO person_data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Book> list = book_data_source.getAll();
        int choice = 0;
        while(true) {
            String menuTitle = "Update Book";
            String prompt = "Select a book to update";
            String[] menuOptions = new String[list.size()];
            for(int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getTitle();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if(choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle("Updating " + menuOptions[choice - 1] + "...");
            Book book = list.get(choice - 1);
            updateBook(book_data_source, person_data_source, book, choice - 1, scanner, messages);
            break;
        }
    }

    public void updateBook(MyDAO book_data_source, MyDAO person_data_source, Book book, int choice, Scanner scanner, ResourceBundle messages) throws MyException {
        // title,author,read,numPages,datePublished,unitPrice
        String keep = "(Press Enter to keep the current value)";
        System.out.println("Title name: " + book.getTitle());
        for(;;) {
            try {
                String userIn = UserInput.getString("New title name " + keep, scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setTitle(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Author name: " + book.getAuthor());
        for(;;) {
            try {
                String userIn = UserInput.getString("New author name " + keep, scanner);
                if (userIn.equals("")) {
                    break;
                }
                Person author = new Person();
                author.setFirstNameAndLastName(userIn);
                book.setAuthor(author);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Is Read: " + book.isRead());
        for(;;) {
            try {
                String[] possibleValues = {"yes", "no"};
                String userIn = UserInput.validateString("Did you read it " + keep, possibleValues, scanner, messages);
                if (userIn.equals("")) {
                    break;
                }
                boolean isRead = userIn.equalsIgnoreCase("yes") ? true :false;
                book.setRead(isRead);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Number of pages: " + book.getNumPages());
        for(;;) {
            try {
                String userIn = UserInput.getString("New numPage " + keep, scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setNumPages(Integer.parseInt(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Date published: " + book.getDatePublished());
        for(;;) {
            try {
                String userIn = UserInput.getString("New date published" + keep, scanner);
                if(userIn.equals("")) {
                    break;
                }
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(userIn, formatterInput);
                book.setDatePublished(date);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            } catch(DateTimeParseException e) {
                UIUtility.showErrorMessage("Invalid date", scanner, messages);
            }
        }
        System.out.println("This book cost: " + book.getUnitPrice());
        for(;;) {
            try {
                String userIn = UserInput.getString("New price " + keep, scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setUnitPrice(Double.parseDouble(userIn));
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        book_data_source.set(choice, book);
        System.out.println("\nBook updated");
    }
}
