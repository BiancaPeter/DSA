package linkedLists;

public class SinglyLinkedListConstruction {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void deleteNode(Node head, int value) {
        Node currentNode = head;
        Node prev = null;
        if (head.value == value) {
            head = head.next;
            return;
        }
        while (currentNode != null && currentNode.value != value) {
            prev = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            return;
        }
        prev.next = currentNode.next;
    }

    public static void insertFirst(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAfter(Node prevNode, int value) {
        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public static void insertLast(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.next = null;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}
