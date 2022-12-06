package final_project;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {
    private ResourceBundle messages;

    public Language() {
        messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        // messages = ResourceBundle.getBundle("messages", new Locale("is"));
        // messages = ResourceBundle.getBundle("messages", new Locale("es", "MX"));
    }

    public ResourceBundle getMessages() {
        return messages;
    }

    public void setMessages(Scanner scanner) {
        int choice = 0;
        while (true) {
            String menuTitle = this.messages.getString("languages-available");
            String prompt = this.messages.getString("select-language");
            String[] menuOptions = {
                    this.messages.getString("english"), this.messages.getString("french"),
                    this.messages.getString("vietnamese")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, this.messages);
            if(choice <= 0 || choice > menuOptions.length + 1) {
                continue;
            }
            else if(choice == menuOptions.length + 1) {
                System.out.println("\n" + this.messages.getString("language-canceled"));
                break;
            }
            else if(choice == 1) {
                this.messages = ResourceBundle.getBundle("messages", Locale.getDefault());
                System.out.println("\n" + this.messages.getString("language-changed"));
                break;
            }
            else if(choice == 2) {
                this.messages = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
                System.out.println("\n" + this.messages.getString("language-changed"));
                break;
            }
            else if(choice == 3) {
                this.messages = ResourceBundle.getBundle("messages", new Locale("vi", "VI"));
                System.out.println("\n" + this.messages.getString("language-changed"));
                break;
            }
        }
    }

}
