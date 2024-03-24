package Graph;

public class NumberOfProvinces {
    public static void main(String args[]){
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int res = findCircleNum(isConnected);
        System.out.println(res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int res = n;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(isConnected[r][c] == 1)
                    res -= union(r, c, parent, rank);
            }
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
