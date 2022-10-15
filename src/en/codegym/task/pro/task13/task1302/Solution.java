package en.codegym.task.pro.task13.task1302;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.util.Arrays.asList;

public class Solution {
    public static Set<String> languagesIKnow = new HashSet<>(asList("HTML CSS JavaScript SQL Java Python".split(" ")));

    public static void iteratorDemo() {
        Iterator<String> it = languagesIKnow.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(String.format("I know the %s prgraming language", str));
        }
    }

    public static void checkWords(String word) {
        if(languagesIKnow.contains(word)) {
            //System.out.println("The word " + word + " is in the set");
            System.out.println(String.format("The word %s is in the set", word));
        } else {
            //System.out.println("The word " + word + " is not in the set");
            System.out.println(String.format("The word %s is not in the set", word));
        }
        //Other way to write this
        System.out.println(String.format("The word %s is%s not in the set",
                    word, languagesIKnow.contains(word) ? "" : " not"));
    }

    public static void main(String[] args) {
        iteratorDemo();
        checkWords("C#");
        checkWords("Java");
    }
}
