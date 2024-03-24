package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {

    public static void main(String args[]){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        //NodePrinter.printNodes(node1);
        NodePrinter.printAdjacencyList(node1);

        Node res = cloneGraph(node1);

        NodePrinter.printAdjacencyList(res);

    }

    public static HashMap<Node, Node> oldToNew = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if(node == null)
            return null;

        return dfs(node);
    }

    public static Node dfs(Node node){
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        oldToNew.put(node, copy);
        for(Node neighbor : node.neighbors){
            copy.neighbors.add(dfs(neighbor));
        }
        return copy;
    }
}
