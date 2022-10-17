package generics;

import java.util.*;

public class Assignment4 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push('J');
        myStack.push('A');
        myStack.push('V');
        myStack.push('A');
        System.out.println(myStack.peek());
        Character cha = (Character) myStack.pop();
        System.out.println(cha);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.search('V'));
        System.out.println(myStack.search('J'));
        System.out.println(myStack.empty());
        System.out.println(myStack.toString());
        myStack.pop();
        myStack.pop();
// myStack.pop();
// System.out.println(myStack.peek());
        System.out.println(myStack.empty());
        System.out.println();
    }
}
