package generics;

import java.util.*;


public class MyStack<T> implements PushPop<T>{
    private ArrayList<T> stack;

    // Creates an empty Stack
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Tests if this stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public T peek() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public T pop() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public void swap(T obj1, T obj2) {
//        Set<T> newStack = new HashSet<>(stack);
//        stack = new ArrayList<>(newStack);

        int loc1 = stack.size() - search(obj1);
        int loc2 = stack.size() - search(obj2);

        if ((loc1 > stack.size() || loc1 < -1) || (loc2 > stack.size() || loc2 < -1)) {
            throw new NoSuchElementException();
        } else {
            T temp = stack.get(loc1);
            stack.set(loc1, stack.get(loc2));
            stack.set(loc2, temp);
        }
    }

    // Pushes an item onto the top of this stack.
    public T push(T obj) {
        stack.add(obj);
        return obj;
    }

    // Returns the 1-based position where an object is on this stack.
    public int search(T obj) {
        int i = stack.lastIndexOf(obj);
        if (i >= 0) {
            return stack.size() - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
