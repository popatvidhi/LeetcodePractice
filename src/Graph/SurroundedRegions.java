package Graph;

public class SurroundedRegions {

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        System.out.println("Input");
        for(int r = 0; r < board.length; r++){
            System.out.print("[ ");
            for(int c = 0; c < board[0].length; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.print("]\n");
        }
        solve(board);
        System.out.println("Ouput");
        for(int r = 0; r < board.length; r++){
            System.out.print("[ ");
            for(int c = 0; c < board[0].length; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.print("]\n");
        }
    }

    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // phase 1: capture unsurrounded regions (border 'O's converted to 'T's)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((board[r][c] == 'O') && (r == 0 || r == rows - 1 || c == 0 || c == cols - 1)) {
                    capture(board, r, c);
                }
            }
        }


        // phase 2: capture surrounded regions (inside 'O's changed to 'X's)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        // phase 3: uncapture unsurrounded regions (change 'T's back to 'O's)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void capture(char[][] board, int r, int c){
        int rows = board.length;
        int cols = board[0].length;
        if(r < 0 || c < 0 || r == rows || c == cols || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}
