package en.codegym.task.pro.task13.task1303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public static void print(HashSet<String> words) {
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(Arrays.asList("Programming is usually taught using examples.".split(" ")));
        print(words);
    }
}
