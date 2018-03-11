import java.util.Scanner;
public class Main {
	//John W. Burris
	//Tic-Tac-Toe. Two player.
	//Feel free to use as a starting point for Connect 4.

	   static final int X = 1;
	   static final int O = -1;
	   
	   //printBoard method that prints out the current state of the
	   //Tic-Tac-Toe board. Does not return anything or change the board.
	   public static void printBoard( int [][] matrix ){
	      
	      for( int row = 0; row < matrix.length; row++ ){
	         for( int col = 0; col < matrix[row].length; col++ ){
	            // Uses the "global" constants to print out appropriate letter.
	            if( matrix[row][col] == X )
	               System.out.print("X ");
	            else if(matrix[row][col] == O )
	               System.out.print("O ");
	            else 
	               System.out.print(". ");
	          }
	          // Goes to new line after printing each row
	          System.out.println("");
	       }
	   }

	   //hasWon returns true if there was a win or a cat game.
	   public static boolean hasWon( int [][] matrix ){
	      //Variable holds the "result" of hasWon. True if a winner was found.
	      boolean retVal = false;
	      
	      //Check for horizontal win
	      for( int row = 0; row < matrix.length; row++ ){
	         int sum = 0;
	         for( int col = 0; col < matrix[0].length; col++ ){
	            sum += matrix[row][col];
	         }
	         //Check to see if the sum of that row was 3 or -3, a win...
	         if( sum == 3 ){
	            System.out.println("X wins.");
	            retVal = true;
	         } else if ( sum == -3 ) {
	            System.out.println("O wins.");
	            retVal = true;
	         }
	      }
	      
	      //Check for vertical win
	      for( int col = 0; col < matrix[0].length; col++ ){
	         int sum = 0;
	         for( int row = 0; row < matrix.length; row++ ){
	            sum += matrix[row][col];
	         }
	         //Check to see if the sum of that column was 3 or -3, a win...
	         if( sum == 3 ){
	            System.out.println("X wins.");
	            retVal = true;
	         } else if ( sum == -3 ) {
	            System.out.println("O wins.");
	            retVal = true;
	         }
	      }
	      
	      //Check for diagonal win
	      if( (matrix[0][0] + matrix[1][1] + matrix[2][2]) == 3 ){
	         System.out.println("X wins.");
	         retVal = true;
	      } else if ( (matrix[0][0] + matrix[1][1] + matrix[2][2]) == -3 ) {
	         System.out.println("O wins.");
	         retVal = true;
	      }
	      if( (matrix[0][2] + matrix[1][1] + matrix[2][0]) == 3 ){
	         System.out.println("X wins.");
	         retVal = true;
	      } else if ( (matrix[0][2] + matrix[1][1] + matrix[2][0]) == -3 ) {
	         System.out.println("O wins.");
	         retVal = true;
	      }
	      
	      //Check for cat game
	      boolean foundSpace = false;
	      for( int row = 0; row < matrix.length; row++ ){
	         for( int col = 0; col < matrix[0].length; col++ ){
	            if( matrix[row][col] == 0 ) 
	               foundSpace = true;
	         }
	      }
	      if( foundSpace == false ){
	         System.out.println("Ends in tie.");
	         retVal = true;
	      }
	      
	      return retVal;
	   }
	   
	   public static void main (String [] args) {
	      Scanner input = new Scanner(System.in);
	      
	      //A 3x3 array stored as integers. X will be 1. O will be -1.
	      int [][] board = new int[3][3];
	      
	      while( hasWon(board) == false){
	         
	         //Get the X player input and make the change if not taken.
	         System.out.print("X, enter row: ");
	         int row = input.nextInt();
	         System.out.print("X, enter column: ");
	         int col = input.nextInt();
	         if( board[row][col] == 0 )
	            board[row][col] = X;
	            
	         printBoard(board);
	         
	         //Check to see if X's move won the game. If so, break out of game loop
	         if( hasWon(board) == true )
	            break;
	         
	         //Get the O player input and make the change if not taken.
	         System.out.print("O, enter row: ");
	         row = input.nextInt();
	         System.out.print("O, enter column: ");
	         col = input.nextInt();
	         if( board[row][col] == 0 )
	            board[row][col] = O;
	         
	         printBoard(board);
	         
	      }
	      
	      System.out.println("Game over.");
	   }
	}


