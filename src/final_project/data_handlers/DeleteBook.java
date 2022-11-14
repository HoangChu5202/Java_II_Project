package final_project.data_handlers;

import final_project.MyException;
import final_project.UIUtility;
import final_project.data_access.MyDAO;
import java1refresher.Book;
import java1refresher.Person;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DeleteBook implements MyDataHandler{
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Book> list = data_source.getAll();
        int choice = 0;
        while(true) {
            String menuTitle = "Delete Book";
            String prompt = "Select a book to delete";
            String[] menuOptions = new String[list.size()];
            for(int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getTitle();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if (choice == menuOptions.length + 1) {
                break;
            }
            Book book = list.get(choice - 1);
            if(data_source.remove(book)) {
                System.out.println("Book deleted");
            } else {
                System.out.println("Delete book failed");
            }
            break;
        }
    }
}
