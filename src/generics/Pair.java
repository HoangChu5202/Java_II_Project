package generics;

import java.util.Iterator;

public class Pair<T, U extends T> {
}



class Main4 {
    public static void main(String[] args) {
 //       Pair<String, Integer> p1; This will not work
        Pair<Number, Integer> p2;
        Pair<Fruit, Banana> p3;

    }
}