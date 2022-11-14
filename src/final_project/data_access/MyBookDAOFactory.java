package final_project.data_access;

import final_project.data_access.MyDAO;
import java1refresher.Book;
import java1refresher.Person;

public class MyBookDAOFactory {
    public static MyDAO getMyDAO(String book_dao_source) {
        MyDAO<Book> dao = null;
        switch (book_dao_source.toUpperCase()) {
            case "CSV":
                dao = new BookDAO_CSV();
                break;
            case "XML":
                //dao = new PersonDAO_XML();
                break;
            case "MYSQL":
                //dao = new PersonDAO_MySQL();
                break;
        }
        return dao;
    }
}
