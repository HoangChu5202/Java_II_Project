package generics;

public class GenericsDemo {
    public static void main(String[] args) {
        Box<Food> box = new Box<Food>();
        Apple apple = new Apple();
        box.add(apple);
        Banana banana = new Banana();
        box.add(banana);
        Food food = box.remove();
        box.add(banana);
        food = box.remove();

    }

    public static <T> void add(T item, Box<T> box) {
        box.add(item);
    }
}
