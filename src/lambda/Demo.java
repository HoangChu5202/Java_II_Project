package lambda;

import final_project.MyException;
import final_project.data_access.MyDAO;
import final_project.data_access.MyDAOFactory;
import java1refresher.Book;
import java1refresher.Person;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class Demo {
    public static void main(String[] args) throws MyException
    {
        String data_source = "csv";
        MyDAO<Person> personMyDAO = MyDAOFactory.getMyDAO(data_source);
        if(personMyDAO == null) {
            System.out.println("Person object not found");
            return;
        }
        try {
            personMyDAO.readInData();
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return;
        }
        List<Person> people = personMyDAO.getAll();
//        ContainsAnalyzer contains = new ContainsAnalyzer();
        MyAnalyzer<String> startWith = ((search, target) -> target.startsWith(search));
        Consumer<String> namesLength = (name) -> System.out.println(name + " " + name.length());
        for (Person person : people) {
//            if (startWith.analyzer("g", person.getFirstName().toLowerCase())) {
//                System.out.println("Match: " + person.getFirstName() + " " + person.getLastName());
//            }
            namesLength.accept(person.getFirstName());
        }

        Supplier<String> today = () -> {
            DateTimeFormatter df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
            return df.format(ZonedDateTime.now());
        };
        System.out.println(today.get());

        Supplier<Integer> diceRoll = () -> ThreadLocalRandom.current().nextInt(1, 7 );
        for (int i = 0; i < 10; i++) {
            System.out.println("Roll #" + i + ": " + diceRoll.get());
        }

        Supplier<LocalDate> randomBirthday = () -> LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        for (int i = 0; i < 10; i++) {
            System.out.println(randomBirthday.get());
        }

        Supplier<Book> bs = Book::new; // equivalent to () -> new Book();
        Book book = bs.get();
        book.setTitle("I love my lambdas");
        book.setAuthor(people.get(40));
        System.out.println(book);

        Consumer<Integer> factorial = (num) -> {
            int result = 1;
            for (int i = 2; i <= num; i++) {
                result *= i;
            }
            System.out.println("The factorial of " + num + " is " + result);
        };
        factorial.accept(10);
        factorial.accept(5);

        Consumer<String> yell = (str) -> System.out.println(str.toUpperCase() + "!");
        yell.accept("i love lambdas");

        Consumer<LocalDate> dayAfter = (date) -> {
            DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            System.out.println(df.format(date.plusDays(1)));
        };

        Consumer<Book> bookTitle  = (b) -> System.out.println("\"" + b.getTitle() + "\", " + b.getAuthor().toString());

        bookTitle.accept(book);
    }
}
