package exercises;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        //cu ajutorul unei structuri de date ajutatoare
        //TODO: exista si alta metoda? Lista dublu inlantuita?!

        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(8);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        reverseLinkedList(node1);
    }

    public static void reverseLinkedList(Node node1) {
        List<Integer> arr = new ArrayList<>();
        Node currentNode = node1;
        while (currentNode != null) {
            arr.add(currentNode.value);
            currentNode = currentNode.next;
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i)+" ");
        }
    }
}
