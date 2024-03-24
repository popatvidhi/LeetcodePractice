package Matrix;

public class GameOfLife {

    public static void main(String args[]){
        int[][] board = new int[][]{{0,1,0},
                                    {0,0,1},
                                    {1,1,1},
                                    {0,0,0}};
        gameOfLife(board);
        for(int r = 0; r < board.length; r++){
            System.out.println();
            for(int c = 0; c < board[0].length; c++){
                System.out.print(board[r][c] + " ");
            }
        }
    }
    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                int nei = countNeighbors(r, c, board, rows, cols);
                if(board[r][c] == 1){
                    if(nei == 2 || nei == 3){
                        board[r][c] = 3;
                    }
                }else{
                    if(nei == 3){
                        board[r][c] = 2;
                    }
                }
            }
        }

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(board[r][c] == 1){
                    board[r][c] = 0;
                }else if(board[r][c] == 2 || board[r][c] == 3){
                    board[r][c] = 1;
                }
            }
        }
    }
    private static int countNeighbors(int r, int c, int[][] board, int ROWS, int COLS){
        int nei = 0;

        for (int i = r - 1; i < r + 2; i++) {
            for (int j =  c - 1; j < c + 2; j++) {
                if ((i == r && j == c) || i < 0 || j < 0 || i >= ROWS || j >= COLS) {
                    continue;
                }

                if (board[i][j] == 1 || board[i][j] == 3) {
                    nei += 1;
                }
            }
        }

        return nei;

    }
}
