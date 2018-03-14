
//import java.awt.font.*;
import java.awt.event.*;
//Taken from http://courses.washington.edu/css161/nash/slides/games/gamePak/gamePak/src/TicTacToe.java
//Then changed to be four in a row instead of 3.

public class Main {

	
	
	
	



	public static void main (String[] args)
	{
		//view.gamePanel(); //launch game
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
		view.registerListeners(controller);

	}
	


	
	

}


