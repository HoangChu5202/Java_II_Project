package final_project;

import java1refresher.Person;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        String data_source = "csv";
        MyDAO<Person> personDAO = MyDAOFactory.getMyDAO(data_source);
        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    messages.getString("add-person")
                    , messages.getString("get-person")
                    , messages.getString("update-person")
                    , messages.getString("delete-person")
                    , messages.getString("change-language")
            };

            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);

            if(choice <= 0 || choice > menuOptions.length + 1) {
                continue;
            }
            if(choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle(menuOptions[choice - 1]);
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    language.setMessages(scanner, messages);
                    messages = language.getMessages();
                    break;
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end"));
        scanner.close();
    }
}
