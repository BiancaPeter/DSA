package linkedLists;

public class RemoveKthNodeFromEnd {
    //1->3->4->6->5->8->9->10->11->12->13->14->15  , k = 4


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void removeKthNodeFromEnd(Node head, int k) {
        Node first = head;
        Node second = head;
        int count = 0;
        while (count < k) {
            second = second.next;
            count++;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        removeKthNodeFromEnd(node1, 3);
        while (node1 != null) {
            System.out.println(node1.value);
            node1 = node1.next;
        }
    }
}
