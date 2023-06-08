package trees;

import java.util.List;

public class BTBranchSums {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(n) TS
    public static void calculateSums(Node tree, int runningSum, List<Integer> branchSums) {
        runningSum = runningSum + tree.value;
        if (tree.left == null && tree.right == null) {
            branchSums.add(runningSum);
            return;
        }
        calculateSums(tree.left, runningSum, branchSums);
        calculateSums(tree.right, runningSum, branchSums);
    }
}
