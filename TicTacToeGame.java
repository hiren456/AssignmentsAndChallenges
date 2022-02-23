import java.util.Scanner;

/**
 * Use the TicTacToeBoard class to implement a very simple
 * text-based game. There is absolutely no error checking whatsoever.
 */
public class TicTacToeGame {
    
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    TicTacToeBoard board = new TicTacToeBoard();
    char whoseMove = 'X';
    while(!board.gameOver()){
      System.out.println(board);
      System.out.println(whoseMove+"'s turn.");
      System.out.print("Enter row(0-2) and col(0-2):");
      int r = keyboard.nextInt();
      int c = keyboard.nextInt();
      if(!board.makeMove(whoseMove,r,c))
        System.out.println("Invalid move. Try again.");
      else
        whoseMove = (whoseMove=='X'?'O':'X'); //Swaps 'X' <-> 'O'
    }
    System.out.println(board);
    char winner = board.detectWinner();
    if(winner==TicTacToeBoard.EMPTY)
      System.out.println("Cat wins.");
    else
      System.out.println(winner+" wins!");
  }
  
}
