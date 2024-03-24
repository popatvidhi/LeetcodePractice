package Graph;

public class NumberOfIsland {
    public static void main(String args[]){
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '1', '0', '0'},
                                     {'0', '0', '0', '1', '1'}};
        int res = numIslands(grid);
        System.out.println(res);
    }
    public static int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int countIsland = 0;
        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                if(grid[r][c] =='1'){
                    dfs(r,c,grid);
                    countIsland++;
                }
            }
        }
        return countIsland;
    }
    public static void dfs(int r, int c, char[][] grid){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if(r<0 || c<0 || r>=ROWS || c>=COLS || grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);

    }
}
