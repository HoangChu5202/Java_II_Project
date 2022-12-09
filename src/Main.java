import java1refresher.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Person, List<Animal>> owners_and_their_pets = new HashMap<>();
        Map<Person, List<Animal>> owners_and_their_pets2 = new TreeMap<>();

        Person marc = new Person("Marc");
        List<Animal> marcs_pets = new ArrayList<>();
        marcs_pets.add(new Cat("Zipper"));
        marcs_pets.add(new Cat("Waffles"));
        owners_and_their_pets.put(marc, marcs_pets);

        Person krystal = new Person("Krystal");
        List<Animal> krystal_pets = new ArrayList<>();
        krystal_pets.add(new Cat("Lulu"));
        krystal_pets.add(new Dog("Penny"));
        krystal_pets.add(new Cat("Gus"));
        owners_and_their_pets.put(krystal, krystal_pets);

        Person bob = new Person("Bob");
        List<Animal> bobs_pets = new ArrayList<>();
        owners_and_their_pets.put(bob, bobs_pets);

        Person amy = new Person("Amy");
        List<Animal> amys_pets = new ArrayList<>();
        amys_pets.add(new Cat("Velcro"));
        owners_and_their_pets.put(amy, amys_pets);

        Person hoang = new Person("Hoang");
        List<Animal> hoangs_pets = new ArrayList<>();
        hoangs_pets.add(new Dog("Den"));
        hoangs_pets.add(new Dog("Lucy"));
        hoangs_pets.add(new Cat("Jennifer"));
        owners_and_their_pets.put(hoang, hoangs_pets);

        owners_and_their_pets.forEach((person, pets) -> {
            // Part 1 code
            String result = person.getFirstName();
            if (pets.size() == 0) {
                result += " has no pets";
            } else {
                result += "\'s pets:";
                String listPets = "";
                for (Animal pet : pets) {
                    listPets += " " + pet.toString() + ",";
                }
                listPets = listPets.substring(0, listPets.length()-1);
                result += listPets;
            }
            System.out.println(result);
        });
        //Different way to write this:
//        for (Map.Entry<Person, List<Animal>> entry : owners_and_their_pets.entrySet()) {
//            Person person = entry.getKey();
//            List<Animal> pets = entry.getValue();
//        }
        System.out.println();

        processData(owners_and_their_pets);
        printReport();

        processData2(owners_and_their_pets);
        printReport2();

    }

    static Map<String, Integer> counter = new HashMap<>();

    public static void processData(Map<Person, List<Animal>> map) {
        // Part 2 code
        for (List<Animal> animals : map.values()) {
            for (Animal animal : animals) {
                String type = animal.getClass().getSimpleName();
                if (counter.containsKey(type)) {
                    counter.put(type, counter.get(type) + 1);
                } else {
                    counter.put(type, 1);
                }
            }
        }
    }

    static Map<Integer, Integer> counter2 = new TreeMap<>();
    public static void processData2(Map<Person, List<Animal>> map) {
        // Part 2 code
        map.forEach((key, list) -> {
            if (counter2.containsKey(list.size())) {
                counter2.put(list.size(), counter2.get(list.size()) + 1);
            } else {
                counter2.put(list.size(), 1);
            }
        });
    }


    public static void printReport() {
        System.out.println("--- Animals Report ---");
        // Part 3 code
        counter.forEach((type, count) -> {
            System.out.println("Type: " + type + "\t\t" + "Count: " + count);
        });
    }

    static Map<Integer, Integer> report = new TreeMap<>();
    public static void printReport2() {
        System.out.println("--- Animals Report ---");
        counter2.forEach((type, count) -> {
            System.out.println(count + " person has " + type + " animals");
        });
    }

    public static void printCollection(Collection<?> collection) {
//        System.out.println("This " + collection.getClass().getSimpleName() + " contains " + collection.size() + " " + listClass.getSimpleName() + " element" + (collection.size() == 1? "" : "s"));
//        collection.forEach(element -> System.out.println(element));
//         collection.forEach(System.out::println);
//         System.out.println(collection.toString());
        System.out.println(collection.stream().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println();
    }
}