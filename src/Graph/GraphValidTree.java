package Graph;

import java.util.*;

public class GraphValidTree {

    public static void main(String args[]){
        int n = 5;
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        boolean res = validTree(n, edges);
        System.out.println(res);
    }

    public static boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();
        if(n == 0)
            return true;

        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for (int[] pair : edges) {
            int n1 = pair[0];
            int n2 = pair[1];
            /**
             * since it is an undirected graph, add the edge to both  nodes
             */
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        return dfs(0,-1, adj, visitSet) && n == visitSet.size();
    }
    public static boolean dfs(int i, int prev, HashMap<Integer, List<Integer>> adj, Set<Integer> visitSet ){
        if(visitSet.contains(i))
            return false;
        visitSet.add(i);
        for(int j : adj.get(i)){
            if(j==prev)
                continue;
            if(!dfs(j, i, adj, visitSet))
                return false;
        }
        return true;
    }
}
