package trees;

import java.util.ArrayList;
import java.util.List;

public class BSTFindKthLargestValue {
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value=value;
        }
    }

    public static List<Integer> inOrder (Node tree, List<Integer> array){
        if (tree.left!=null) {
            inOrder(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right!=null){
            inOrder(tree.right, array);
        }
        return array;
    }

    //O(N) TS
    public int findKthLargestValue(Node tree, int k){
        List<Integer> sortedValues = new ArrayList<>();
        inOrder(tree, sortedValues);
        return sortedValues.get(sortedValues.size()-k);
    }
}
