package rough;

import javax.crypto.spec.PSource;

public class sudokusolver {

    public static int iter = 0;

    public static void solveSudoku(char[][] board) {

        solve(board, 0, 0);

    }

  public static void main(String[] args) {
    //
      char[][] grid = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
      solveSudoku(grid);
      for (char[] chars : grid) {
          for (int j = 0; j < grid.length; j++) {
              System.out.print(chars[j] + " ");
          }
          System.out.println();
      }
    System.out.println("Iterations = " + iter);
  }

    public static boolean solve(char[][] board, int x, int y)
    {
        // exit condition
        iter++;
        if(boardFill(board))
            return true;

        for(int i=0; i<board.length ; i++)
        {
            for(int j=0 ; j<board.length ; j++)
            {
                if(board[i][j] == '.'){

                    for(int num = 1; num<10 ; num++)
                    {
                        if(validPos(num, i, j, board))
                        {
                            board[i][j] = (char)(num + 48);
                            System.out.println("i = " + i);
                            System.out.println("j = " + j);
                            System.out.println("board[i][j] = " + board[i][j]);
                            if (solve(board, i, j))
                                return true;
                            else board[i][j] = '.';

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validPos(int num, int x, int y, char[][] board)
    {
        for(int i=0 ; i<board.length ; i++)
            if(board[i][y] == (char)(num+48) || board[x][i] == (char)(num+48)) return false;

        int idx = x/3, idy = y/3;

        for(int i=idx*3; i<idx*3+3 ; i++)
            for(int j=idy*3 ; j<idy*3+3 ; j++)
                if(board[i][j] == (char)(num+48)) return false;

        return true;
    }

    public static boolean boardFill(char[][] board)
    {
        for(int i=0; i<board.length ; i++)
        {
            for(int j=0 ; j<board.length ; j++)
            {
                if(board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }
}
