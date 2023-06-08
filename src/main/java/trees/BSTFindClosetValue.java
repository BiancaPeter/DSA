package trees;

public class BSTFindClosetValue {
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value=value;
        }
    }

    //O(log(N))TS
    public static int findClosestValue(Node tree, int target, int closest, int nodeValue){
        if (Math.abs(target - tree.value) < closest){
            closest = target-tree.value;
            nodeValue = tree.value;
        }
        if (target < tree.value && tree.left != null){
            return findClosestValue(tree.left, target, closest, nodeValue);
        }else if (target > tree.value && tree.right != null) {
            return findClosestValue(tree.right, target, closest, nodeValue);
        }else{
            return nodeValue;
        }
    }

    //O(logN) T , O(1) S
    public static int findClosestValue2(Node tree, int target, int closest, int nodeValue){
        Node currentNode = tree;
        while (currentNode != null){
            if (Math.abs(target - currentNode.value) < closest){
                closest = target-currentNode.value;
                nodeValue = currentNode.value;
            }
            if (target < currentNode.value ){
                currentNode = currentNode.left;
            }else if (target > currentNode.value) {
                currentNode = currentNode.right;
            }else{
                break;
            }
        }
        return nodeValue;
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(15);
        Node node3 = new Node(13);
        Node node4 = new Node(22);
        Node node5 = new Node(14);
        node1.left=null;
        node1.right = node2;
        node2.left=node3;
        node2.right=node4;
        node3.right=node5;
        node4.left=null;

        System.out.println(findClosestValue(node1,12, Integer.MAX_VALUE, 0));
        System.out.println(findClosestValue2(node1, 12, Integer.MAX_VALUE, 0));
    }
}
