package java1refresher;

import java.util.*;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 99, 77, 22, 11);
        set.forEach(System.out::println);

        Map<String, Integer> inventory = new HashMap<>(); // Change to TreeMap<>() to allow duplicate value
        inventory.put("Bread", 99);
        inventory.put("Eggs", 77);
        inventory.put("Milk", 11);
        inventory.put("Ketchup", 22);
        inventory.put("Butter", 77);

        inventory.entrySet().forEach(System.out::println);
        System.out.println(inventory.get("Milk"));

        System.out.println(inventory.containsKey("Eggs"));
        System.out.println(inventory.containsValue(99));

        inventory.remove("Ketchup");
        inventory.entrySet().forEach(System.out::println);
        System.out.println(inventory.size());

        for(String product: inventory.keySet()) { // key set return the key
            System.out.println(product);
        }

        for(Integer quantity: inventory.values()) {
            System.out.println(quantity);
        }

        for (Map.Entry productQty: inventory.entrySet()) {
            System.out.printf("There are %d unit of %s%n", productQty.getValue(), productQty.getKey());
        }
    }
}
