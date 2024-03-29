package en.codegym.task.pro.task13.task1310;

import java.util.HashMap;

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println("Student list: ");
        printStudents();
        System.out.printf("Average grade: %.1f", getAverageMark());
    }

    public static void addStudents() {
        grades.put("William Butler Yeats", 4.3d);
        grades.put("Emily Dickenson", 4.1d);
        grades.put("William Shakespeare", 4.9d);
        grades.put("Maya Angelou", 3.7d);
        grades.put("Shel Silverstein", 3.2d);
    }

    public static void printStudents() {
        for (String studentName : grades.keySet()) {
            System.out.println(studentName);
        }
    }

    public static Double getAverageMark() {
        double result = 0;
        for (Double grade : grades.values()) {
            result += grade;
        }
        return result / grades.size();
    }
}
