package final_project;

import final_project.data_access.MyBookDAOFactory;
import final_project.data_access.MyDAO;
import final_project.data_access.MyDAOFactory;
import final_project.data_handlers.*;
import java1refresher.Book;
import java1refresher.Person;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data_source = "MYSQL";
        MyDAO<Person> personDAO = MyDAOFactory.getMyDAO(data_source);
        MyDAO<Book> bookDAO = MyBookDAOFactory.getMyDAO(data_source);
        if(personDAO == null) {
            System.out.println("Person data object not found");
            return;
        }
        try {
            personDAO.readInData();
        } catch(MyException e) {
            System.out.println(e.getMessage());
            return;
        }

        if(bookDAO == null) {
            System.out.println("Book data object not found");
            return;
        }
        try {
            bookDAO.readInData();
        } catch(MyException e) {
            System.out.println(e.getMessage());
            return;
        }

        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(true) {
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    messages.getString("add-person")
                    , messages.getString("get-person")
                    , messages.getString("update-person")
                    , messages.getString("delete-person")
                    , "Add Book"
                    , "Get Book"
                    , "Update Book"
                    , "Delete Book"
                    , messages.getString("change-language")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if(choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle(menuOptions[choice - 1]);
            try {
                switch (choice) {
                    case 1:
                        new AddPerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 2:
                        new GetPerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 3:
                        new UpdatePerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 4:
                        new DeletePerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 5:
                        new AddBook().handleTask(bookDAO, personDAO, scanner, messages);
                        break;
                    case 6:
                        new GetBook().handleTask(bookDAO, scanner, messages);
                        break;
                    case 7:
                        new UpdateBook().handleTask(bookDAO, personDAO, scanner, messages);
                        break;
                    case 8:
                        new DeleteBook().handleTask(bookDAO, personDAO, scanner, messages);
                        break;
                    case 9:
                        language.setMessages(scanner);
                        messages = language.getMessages();
                        break;
                }
            } catch (MyException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end"));
        scanner.close();
    }
}
