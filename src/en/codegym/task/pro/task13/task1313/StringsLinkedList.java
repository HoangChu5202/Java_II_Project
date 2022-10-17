package en.codegym.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringsLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(int index, String value) {
//        1) Instantiate a new node object.
        Node node = new Node();
//        2) Store the passed value to the new node's value.
        node.value = value;
//        3) Find the node at the given index
        Node currentElement = first.next;
        for(int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
//        4) Create a temporary node variable and assign a reference to the last node's prev value.
        Node ref = currentElement.prev;
//        5) Assign the new node object to the temporary node's next value.
        ref.next = node;
//        6) Assign the new node object to the last node's prev value.
        currentElement.prev = node;
//        7) Assign the temporary node object to the new node's prev value.
        node.prev = ref;
//        8) Assign the last node object to the new node's next value.
        node.next = currentElement;
    }

    public void add(String value) {
//        1) Instantiate a new node object.
        Node node = new Node();
//        2) Store the passed value to the new node's value.
        node.value = value;
//        3) Create a temporary node variable and assign a reference to the last node's prev value.
        Node ref = last.prev;
//        4) Assign the new node object to the temporary node's next value.
        ref.next = node;
//        5) Assign the new node object to the last node's prev value.
        last.prev = node;
//        6) Assign the temporary node object to the new node's prev value.
        node.prev = ref;
//        7) Assign the last node object to the new node's next value.
//        node.next = last;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}