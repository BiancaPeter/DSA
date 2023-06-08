package grafs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static class Node {
        public String value;
        List<Node> children = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }


        //O(V+E) T , O(V) S
        public List<String> depthFirstSearch(List<String> array){
            array.add(this.value);
            for (int i=0; i< children.size(); i++){
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }
    }
}
