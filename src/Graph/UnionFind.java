package Graph;

public class UnionFind {

    public static int[] parent;
    public static int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
        public static int find(int n1){
            int res = n1;
            while(res != parent[res]){
                parent[res] = parent[parent[res]];
                res = parent[res];
            }
            return res;
        }

        public static boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);
            if(p1 == p2){
                return false;
            }
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }else{
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
            return true;
        }
}
