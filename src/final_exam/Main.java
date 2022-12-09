package final_exam;

import java1refresher.Book;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ParkingSpace<Car> carParkingSpace = new ParkingSpace<>();
        ParkingSpace<Motorcycle> motorcycleParkingSpace = new ParkingSpace<>();
//        ParkingSpace<Book> bookParkingSpace = new ParkingSpace<Book>();


        ResourceBundle messagesEN = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        ResourceBundle messagesFR = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
        ResourceBundle messagesVI = ResourceBundle.getBundle("messages", new Locale("vi", "VI"));

        System.out.println("English: " + messagesEN.getString("usa"));
        System.out.println("French: " + messagesFR.getString("usa"));
        System.out.println("Vietnamese: " + messagesVI.getString("usa"));
    }
}
