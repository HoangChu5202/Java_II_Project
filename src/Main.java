import java1refresher.Book;
import java1refresher.Person;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 8, 9, 1, 10, 7, 4);
        list.addAll(Arrays.asList(8, 9, 2, 1, 6, 7));
        list.forEach(System.out::println);
        Collections.fill(list, 0); // Fill all object in the list with 0

        List<String> stuff = new ArrayList<>(Collections.nCopies(5, "Java"));
        stuff.add("Python");
        Collections.replaceAll(stuff, "Java", "JavaScript");
        stuff.forEach(System.out::println);

        List<String> otherStuff = Arrays.asList("Monday", "Tuesday");
        //OR: ArrayList<String> otherStuff = ArrayList<String>(Arrays.asList("Monday", "Tuesday"));
        Collections.copy(stuff, otherStuff); // First list must be bigger than second list
        stuff.forEach(System.out::println);
    }
}