package en.codegym.task.pro.task13.task1304;
import java.util.*;

public class Solution {
    public static void printList(ArrayList<String> words) {
//        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
//            String word = iterator.next();
//            System.out.println(word);
//        }
//        for(String word: words) {
//            System.out.println(word);
//        }
        for(int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.equalsIgnoreCase("just")) {
                words.remove(word);
                i--;
            }
        }
    }

    public static void printHashSet(HashSet<String> words) {
        Iterator<String> iterator = words.iterator();
//        while (iterator.hasNext()) {
//            String word = iterator.next();
//            System.out.println(word);
//        }
//        for(String word: words) {
//            System.out.println(word);
//        }
        while (iterator.hasNext()) {
            if(iterator.hasNext()) {
                String str = iterator.next();
                if(str.equals("Just")) {
                    iterator.remove();              
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] wordsArray = "I think this will be a new feature. Just don't tell anyone that it was an accident.".split(" ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));
        HashSet<String> wordsHashSet = new HashSet<>(wordsList);
        printList(wordsList);
        System.out.println("__________________________________");
        System.out.println(Arrays.toString(wordsList.toArray()));
        printHashSet(wordsHashSet);
        System.out.println("__________________________________");
        System.out.println(Arrays.toString(wordsHashSet.toArray()));
    }
}
