/*
 * Instances of this class represent tic-tac-toe boards.
 */
public class TicTacToeBoard {
  
  //Use some character for an empty square.
  //public constants are fine, and are common.
  public static final char EMPTY = '.';
  
  /* The ways to win, stored as a 3-dimensional array
   *   There are 8 winning lines.
   *   Each consists of 3 squares in a row.
   *   Each square is identified by 2 numbers (row,col)
   */
  private static final int[][][] winLines =
  { { {0,0},{0,1},{0,2} }, //row 0
    { {1,0},{1,1},{1,2} }, //row 1
    { {2,0},{2,1},{2,2} }, //row 2
    { {0,0},{1,0},{2,0} }, //column 0
    { {0,1},{1,1},{2,1} }, //column 1
    { {0,2},{1,2},{2,2} }, //column 2
    { {0,0},{1,1},{2,2} }, //main diagonal
    { {0,2},{1,1},{2,0} }  //back diagonal
  };//winLines
  
  //The only instance variable is the board itself.
  private char[][] board;
  
  //Constructor
  public TicTacToeBoard() { 
    board = new char[3][3];
    for(int row=0; row<=2; row++)
      for(int col=0; col<=2; col++)
        board[row][col] = EMPTY;
  }//constructor
  
  public String toString(){
    //Return a string with \n characters in it, so it
    //will print as a 3-line board.
    String result = "";
    for(int row=0; row<=2; row++){
      for(int col=0; col<=2; col++)
        result += board[row][col];
      result += '\n';
    }//for row
    return result;
  }//toString
  
  public boolean makeMove(char symbol, int row, int col){
    boolean ok = squareEmpty(row,col);
    if(ok)
      board[row][col] = symbol;
    return ok;
  }//makeMove
  
  public boolean squareEmpty(int row, int col){
    return board[row][col]==EMPTY;
  }//squareEmpty
  
  public char detectWinner(){
    /* If any of the winning lines contain the same
     * value, and it's not EMPTY, return that value,
     * else return the EMPTY symbol.
     */
    for(int i=0; i<winLines.length; i++){
      int[][] line=winLines[i]; //Keeps it simpler
      char startOfLine = board[line[0][0]][line[0][1]];
      boolean allSame = board[line[1][0]][line[1][1]]==startOfLine &&
        board[line[2][0]][line[2][1]]==startOfLine;
      if((startOfLine != EMPTY) && allSame)
        return startOfLine;
    }
    return EMPTY; //Nobody has won yet
  }//detectWinner
  
  public boolean gameOver(){
    return boardFull() || EMPTY!=detectWinner();
  }//gameOver
  
  private boolean boardFull(){
    for(int row=0; row<=2; row++)
      for(int col=0; col<=2; col++)
        if(board[row][col]==EMPTY)
          return false;
    return true;
  }//boardFull
  
  //**THE END***, except...
  
  /* For comparison, here's an implementation of detectWinner
   * that doesn't use the winLines 3D array: */
  public char detectWinner2(){
    char startOfLine; //The first entry in the line to be checked
    boolean allSame; //True if the other two match startOfLine
    
    //See if any of the rows are winners
    for(int row=0; row<=2; row++){
      startOfLine = board[row][0];
      allSame = board[row][1]==startOfLine &&
        board[row][2]==startOfLine;
      if((startOfLine != EMPTY) && allSame)
        return startOfLine;
    }//for row
    
    //See if any of the columns are winners
    for(int col=0; col<=2; col++){
      startOfLine = board[0][col];
      allSame = board[1][col]==startOfLine &&
        board[2][col]==startOfLine;
      if((startOfLine != EMPTY) && allSame)
        return startOfLine;
    }//for col
    
    //See if either diagonal is a winner
    startOfLine = board[0][0];
    allSame = board[1][1]==startOfLine &&
      board[2][1]==startOfLine;
    if((startOfLine != EMPTY) && allSame)
      return startOfLine;
    startOfLine = board[0][2];
    allSame = board[1][1]==startOfLine &&
      board[2][0]==startOfLine;
    if((startOfLine != EMPTY) && allSame)
      return startOfLine;
    
    //Nobody won, I guess
    return EMPTY;
  }//detectWinner2 - alternate version
  
}
