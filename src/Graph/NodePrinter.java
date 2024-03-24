package Graph;

import java.util.*;

public class NodePrinter {

    public static void printNodes(Node node) {
        if (node == null) {
            System.out.println("Graph is empty.");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (!visited.contains(current)) {
                visited.add(current);
                System.out.println("Node: " + current.val);

                for (Node neighbor : current.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void printAdjacencyList(Node node) {
        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        dfs(node, visited);

        for (Node visitedNode : visited) {
            System.out.print("[" + visitedNode.val + ",");

            List<Node> neighbors = visitedNode.neighbors;
            int n = neighbors.size();

            for (int i = 0; i < n; i++) {
                Node neighbor = neighbors.get(i);
                System.out.print(neighbor.val);

                if (i < n - 1) {
                    System.out.print(",");
                }
            }

            System.out.print("]");
            System.out.println();
        }
    }


    private static void dfs(Node node, Set<Node> visited) {
        visited.add(node);

        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
