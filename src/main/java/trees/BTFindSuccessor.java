package trees;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class BTFindSuccessor {
    static class Node {
        public int value;
        public BSTTraversal.Node left;
        public BSTTraversal.Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static List<Integer> inOrder(BSTTraversal.Node tree, List<Integer> array) {
        if (tree.left != null) {
            inOrder(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrder(tree.right, array);
        }
        return array;
    }

    public static int binarySearch(List<Integer> array, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == array.get(middle)) {
                return middle;
            } else if (target < array.get(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BSTTraversal.Node node1 = new BSTTraversal.Node(10);
        BSTTraversal.Node node2 = new BSTTraversal.Node(5);
        BSTTraversal.Node node3 = new BSTTraversal.Node(15);
        BSTTraversal.Node node4 = new BSTTraversal.Node(2);
        BSTTraversal.Node node5 = new BSTTraversal.Node(6);
        BSTTraversal.Node node6 = new BSTTraversal.Node(1);
        BSTTraversal.Node node7 = new BSTTraversal.Node(22);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node3.right = node7;
        List<Integer> traversal = new ArrayList<>();
        List<Integer> array = inOrder(node1, traversal);
        int index = binarySearch(array, 5, 0, array.size() - 1);
        System.out.println("the successor is: " + array.get(index + 1));
    }
}
