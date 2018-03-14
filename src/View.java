import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
	Model model;
	private JPanel panel;
	public View(Model model){
		this.model = model;
		gamePanel();
	}
	
	
    static JButton buttons[][] = new JButton[4][4]; //create 16 buttons
	void gamePanel(){
		JFrame frame = new JFrame ("Tic Tac Toe");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


		panel = new JPanel(); //creating a panel with a box like a tic tac toe board
		panel.setLayout (new GridLayout (4, 4));
		panel.setBorder (BorderFactory.createLineBorder (Color.gray, 3));
		panel.setBackground (Color.white);
		int rowC = 0;
		int colC = 0;
		for(int i=0; i<=3; i++){ //placing the button onto the board
			for(int j=0; j<=3; j++){ //placing the button onto the board
				buttons[i][j] = new MyButton(i, j);
				panel.add(buttons[i][j]);	
				//System.out.println(" each button has i/j " + i + " " + j);
			}		
		}

		frame.getContentPane().add (panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(700, 700);// set frame size and let teh game begin
	}
	public void registerListeners(Controller controller) {
        

        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(controller);
            }
        }
	}
	public void update(){
		for(int i=0; i<=3; i++){ //placing the button onto the board
			for(int j=0; j<=3; j++){ //placing the button onto the board
				if(model.matrix[i][j] == 1){
					buttons[i][j].setText("X");
					//System.out.println("view is tryna set text to X at " + i + ", " + j);
				}
				if(model.matrix[i][j] == -1){
					buttons[i][j].setText("O");
					//System.out.println("view is tryna set text to O at " + i + ", " + j);

				}
			}		
		}
	}
	public void win(){
		JPanel winner = new JPanel();
	}
}
class MyButton extends JButton{
	public int row;
	public int col;
	public MyButton(int r, int c) {	// creating blank board
		super();
		this.row = r;
		this.col = c;
		//letter=" ";
		setFont(new Font("Dialog", 1, 60));
		setText(" ");
		//this.addActionListener(controller);
	}
}