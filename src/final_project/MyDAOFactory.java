package final_project;

import java1refresher.Person;

public class MyDAOFactory {

    public static MyDAO getMyDAO(String dao_source) {
        MyDAO<Person> dao = null;
        switch (dao_source.toUpperCase()) {
            case "CSV":
//                dao = new MyDAO_CSV();
                break;
            case "XML":
                // dao = new MyDAO_XML();
                break;
            case "MYSQL":
                // dao = new MyDAO_MySQL();
                break;
        }
        return dao;
    }
}
