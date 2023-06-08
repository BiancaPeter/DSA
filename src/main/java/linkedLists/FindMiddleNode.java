package linkedLists;

public class FindMiddleNode {

    //1->2->3->4->5

    //sol1
    //parcurgem toata lista ca sa aflam nr de noduri
    //mai parcurgem o data pana la numar de noduri impartit la 2 (pana la jumatate)

    //sol2
    //

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static int findMiddleNode(Node head) {
        Node first = head;
        Node second = head;
        while (second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first.value;
    }
}
