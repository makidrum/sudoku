public class Main {
    private static final int SIZE = 9;

    public static void main(string[] args){
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        SudokuSolver solver = new SudokuSolver();
        if(solver.solve(board)){
            printBoard(board);
        }else{
            System.out.println("No solution exists");
        }
    }

    private static void printBoard(int[][] board){
        for (int r = 0; r < SIZE; r++){
            for(int d = 0; d < SIZE; d++){
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            system.out.print("¥n");

            if((r + 1) % 3 == 0){
                system.out.print("")
            }
        }
    }
}

class SudokuSolver{
    private static final int SIZE = 9;

    public boolean solve(int[][] board){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(board[row][col] == 0){
                    for(int num = 1; num <= SIZE; num++){
                        if(isValid(board,row,col,num)){
                            board[row][col] = num;
                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row,int col,int num){
        for(int i = 0; i < SIZE; i++){
            if(board[row][i] == num || board[i][col] == num ||
                board[row - row % 3 + i /3][col - col % 3 + i % 3] == num){
                    return false;
            }
        }
        return true;
    }
}