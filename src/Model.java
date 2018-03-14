
public class Model {

    static final int X = 1;
    static final int O = -1;
    static int [][] matrix = new int[4][44];
    static int xOrO = 1;
    static boolean hasWon;
    static boolean win;

    public static boolean hasWon(){
        //Variable holds the "result" of hasWon. True if a winner was found.
        boolean retVal = false;
        
        //Check for horizontal win
        for( int row = 0; row < matrix.length; row++ ){
           int sum = 0;
           for( int col = 0; col < matrix[0].length; col++ ){
              sum += matrix[row][col];
           }
           //Check to see if the sum of that row was 3 or -3, a win...
           if( sum == 4 ){
              System.out.println("X wins.");
              retVal = true;
           } else if ( sum == -4 ) {
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
           if( sum == 4 ){
              System.out.println("X wins.");
              retVal = true;
           } else if ( sum == -4 ) {
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
    public static void update(int row, int col){
        //System.out.println("updated from the model");
        matrix[row][col] = xOrO;
        //System.out.println(row +  " " + col +  " " + xOrO);

        xOrO *= -1;
        if(hasWon()){
            win = true;
            
        }
    }
}
