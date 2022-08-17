public class Practice {
    public static void main(String[] args){
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Solution.nqueens(board, 0);
        //System.out.println(Solution.isPossible(board, 1, 3));
    }
}

class Solution{

    public static void printSolution(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("==============");
    }

    public static void coppyArray(int[][] board, int[][] newBoard){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }
    }

    public static void nqueens(int[][] board, int column){

        if(column >= board[0].length){
            printSolution(board);
            return;
        }

        for(int i=0; i < board.length; i++){
            if(isPossible(board, column, i)) {
                int[][] newBoard = new int[board.length][board[0].length];
                coppyArray(board, newBoard);
                newBoard[i][column] = 1;
                nqueens(newBoard, column + 1);
            }
        }

    }

    public static boolean isPossible(int[][] board, int x, int y){

        for(int i=0; i < board[y].length; i++){
            if(i!=x){
                if(board[y][i] == 1){
                    return false;
                }
            }
        }

        for(int i=0; i < board.length; i++){
            if(i!=y){
                if(board[i][x] == 1){
                    return false;
                }
            }
        }

        int[][] directions = {
                {1,1},
                {1,-1},
                {-1,1},
                {-1,-1}
        };

        for(int i=0; i<4; i++){
            int magnitude = 1;
            while(true){
                int xNew = (magnitude * directions[i][0]) + x;
                int yNew = (magnitude * directions[i][1]) + y;

                try{
                    if(board[yNew][xNew] == 1){
                        return false;
                    }
                }catch (Exception e){
                    break;
                }

                magnitude++;
            }
        }

        return true;
    }
}
