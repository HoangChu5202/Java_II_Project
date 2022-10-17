package en.codegym.task.pro.task13.task1309;

import java.util.HashMap;

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("A", 9.0);
        grades.put("B", 7.0);
        grades.put("C", 6.0);
        grades.put("D", 5.0);
        grades.put("F", 4.0);
    }
}
