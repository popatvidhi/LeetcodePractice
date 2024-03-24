package Graph;

public class NumberofConnectedComponentsInUndirectedGraph {
    public static void main(String args[]){
        int n = 6;
        int[][] edges = new int[][]{{0,1},{1,2},{2,3},{4,5}};
        int res = countComponents(n, edges);
        System.out.println(res);
    }

    public static int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int res = n;
        for(int[] edge : edges){
            res -= union(edge[0],edge[1], parent, rank);
        }
        return res;
    }
    public static int find(int n1, int[] parent){
        int res = n1;
        while(res != parent[res]){
            parent[res] = parent[parent[res]];
            res = parent[res];
        }
        return res;
    }
    public static int union(int n1, int n2 , int[] parent, int[] rank){
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1 == p2)
            return 0;
        if (rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }

}
