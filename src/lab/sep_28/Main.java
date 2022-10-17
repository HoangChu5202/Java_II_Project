package lab.sep_28;

import java1refresher.Book;
import java1refresher.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //    private static List<String> collection = new ArrayList<>();
    private static Set<Book> collection = new HashSet<>();
//    private static List<Integer> collection = new Stack<>();
//    private static Set<Integer> collection = new TreeSet<>();

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list, 8, 9, 1, 10, 7, 4);
//        list.addAll(Arrays.asList(8, 9, 2, 1, 6, 7));
//        list.forEach(System.out::println);
//        Collections.fill(list, 0); // Fill all object in the list with 0
//
//        List<String> stuff = new ArrayList<>(Collections.nCopies(5, "Java"));
//        stuff.add("Python");
//        Collections.replaceAll(stuff, "Java", "JavaScript");
//        stuff.forEach(System.out::println);
//
//        List<String> otherStuff = Arrays.asList("Monday", "Tuesday");
//        //OR: ArrayList<String> otherStuff = ArrayList<String>(Arrays.asList("Monday", "Tuesday"));
//        Collections.copy(stuff, otherStuff); // First list must be bigger than second list
//        stuff.forEach(System.out::println);
        //collection.addAll(Arrays.asList("cat", "dog", "fish"));
        collection.addAll(Arrays.asList(new Book("Java: A Beginner's Guide"), new Book("PHP and My SQL")));
        printCollection(collection);


        List<Employee> employees = new ArrayList<>(Arrays.asList((new Employee())));
        employees.add(new Employee());
        List<Employee> employeesCopy = new ArrayList<>(employees.size()); //Deep copy
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            employeesCopy.add(it.next().clone());
        }
        printCollection(employeesCopy);
        employeesCopy.get(0).setFirstName("Marc");
        printCollection(employeesCopy);
        printCollection(employees);
    }

    public static void printCollection(Collection<?> collection) {
        Class<?> listClass = null;
        try {
            Field listField = Main.class.getDeclaredField("collection");
            ParameterizedType listType = (ParameterizedType) listField.getGenericType();
            listClass = (Class<?>) listType.getActualTypeArguments()[0];
        } catch (NoSuchElementException | NoSuchFieldException e) {
            System.out.println("Cannot print this collection");
        }

        System.out.println("This " + collection.getClass().getSimpleName() + " contains " + collection.size() + " " + listClass.getSimpleName() + " element" + (collection.size() == 1? "" : "s"));
//        collection.forEach(element -> System.out.println(element));
//         collection.forEach(System.out::println);
//         System.out.println(collection.toString());
        System.out.println(collection.stream().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println();
    }
}
