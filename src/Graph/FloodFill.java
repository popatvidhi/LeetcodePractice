package Graph;

import java.util.Arrays;

public class FloodFill {
    public static void main(String args[]){
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] res = floodFill(image, sr, sc, color);
        for (int[] row : image)
            System.out.println(Arrays.toString(row));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];

        if(color == orgColor)
            return image;

        dfs(image, sr, sc, orgColor, color);

        return image;
    }
    public static void dfs(int[][] image, int r, int c, int orgColor, int newColor){
        int ROWS = image.length;
        int COLS = image[0].length;
        if(r<0 || c<0 || r>= ROWS || c>=COLS || image[r][c] != orgColor)
            return;
        image[r][c] = newColor;
        dfs(image, r+1, c, orgColor, newColor);
        dfs(image, r-1, c, orgColor, newColor);
        dfs(image, r, c+1, orgColor, newColor);
        dfs(image, r, c-1, orgColor, newColor);
    }
}
