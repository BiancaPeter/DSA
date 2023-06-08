package trees;

public class BTNodeDepths {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(N) TS
    public static int nodeDepths(Node tree, int depth) {
        if (tree == null) {
            return 0;
        }
        return depth + nodeDepths(tree.left, depth + 1) + nodeDepths(tree.right, depth + 1);
    }
}
