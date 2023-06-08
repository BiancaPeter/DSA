package grafs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static class Node {
        public String value;
        List<Node> children = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }


        //O(V+E) T , O(V) S
        public List<String> breadthFirstSearch(List<String> array){
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()){
                Node current = queue.poll();
                array.add(current.value);
                queue.addAll(current.children);
            }
            return array;

        }
    }
}
