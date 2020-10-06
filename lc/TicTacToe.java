public class TicTacToe {

    static int[] rows;
    static int[] cols;
    static int diagCount;
    static int gridSize;
    static int antiDiagCount;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagCount = 0;
        this.gridSize = n;
        this.antiDiagCount = 0;

    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public static int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;
        rows[row]+= move;
        cols[col]+= move;
        if(row == col){
            diagCount+=move;
        }

        if(row == gridSize - col-1){
            antiDiagCount+= move;
        }

        if(rows[row] == gridSize || cols[col] == gridSize || diagCount == gridSize || antiDiagCount == gridSize){
            return 1;
        }
        else if(rows[row] == -gridSize || cols[col] == -gridSize || diagCount == -gridSize || antiDiagCount == -gridSize){
            return 2;
        }
        else{
            return 0;
        }
        
    }

    public static void main(String[] args){
        System.out.println("\n348. Design Tic-Tac-Toe\n");
        TicTacToe game = new TicTacToe(3);
        game.move(0, 0, 1);
        game.move(0, 2, 2);
        game.move(2, 2, 1);
        game.move(1, 1, 2);
        game.move(2, 0, 1);
        game.move(1, 0, 2);
        game.move(0, 1, 1);
        game.move(1, 2, 2);

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */