package final_project.data_handlers;

import final_project.MyException;
import final_project.data_access.MyDAO;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface MyBookDataHandler {
    void handleTask(MyDAO book_data_source, MyDAO person_data_source, Scanner scanner, ResourceBundle messages) throws MyException;
}
