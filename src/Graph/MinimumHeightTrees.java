package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public static void main(String[] args){
        int[][] edges = new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> res = findMinHeightTrees(6, edges);
        for(int r : res){
            System.out.print(r + " ");
        }
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if(n <= 0){
            return res;
        }
        if(n == 1){
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            degree[e[0]]++;
            degree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }


        //bfs
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                qu.add(i);
            }
        }

        while(n > 2){
            int size = qu.size();
            n -= size;

            while(size-- > 0){
                int v = qu.poll();
                for(int i : adj.get(v)){
                    degree[i]--;
                    if(degree[i] == 1){
                        qu.add(i);
                    }
                }
            }
        }

        res.addAll(qu);
        return res;
    }
}
