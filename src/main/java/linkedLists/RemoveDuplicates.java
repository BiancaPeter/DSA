package linkedLists;

public class RemoveDuplicates {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //complexitate - O(N) T, O(1) space
    public static Node removeDuplicatesFromLinkedList(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        Node node7 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        Node node = removeDuplicatesFromLinkedList(node1);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
