package trees;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(N) ST
    public static List<Integer> inOrder(Node tree, List<Integer> array) {
        if (tree.left != null) {
            inOrder(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrder(tree.right, array);
        }
        return array;
    }

    //O(N) ST
    public static List<Integer> preOrder(Node tree, List<Integer> array) {
        array.add(tree.value);
        if (tree.left != null) {
            preOrder(tree.left, array);
        }
        if (tree.right != null) {
            preOrder(tree.right, array);
        }
        return array;
    }

    //O(N) ST
    public static List<Integer> postOrder(Node tree, List<Integer> array) {
        if (tree.left != null) {
            postOrder(tree.left, array);
        }
        if (tree.right != null) {
            postOrder(tree.right, array);
        }
        array.add(tree.value);
        return array;
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(15);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(1);
        Node node7 = new Node(22);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node3.right = node7;
        List<Integer> traversal = new ArrayList<>();
        System.out.println(inOrder(node1, traversal));
        traversal.clear();
        System.out.println(preOrder(node1, traversal));
        traversal.clear();
        System.out.println(postOrder(node1, traversal));
    }
}
