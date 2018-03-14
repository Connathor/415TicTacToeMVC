import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
	Model model;
	Controller controller;
	private JPanel panel;
	public View(Model model){
		this.model = model;
		this.controller = controller;
		gamePanel();
	}
	private static class MyButton extends JButton{
		public MyButton() {	// creating blank board
			super();
			//letter=" ";
			setFont(new Font("Dialog", 1, 60));
			//setText(letter);
			//this.addActionListener(controller);
		}
	}
	
    static JButton buttons[] = new JButton[16]; //create 16 buttons
	void gamePanel(){
		JFrame frame = new JFrame ("Tic Tac Toe");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


		panel = new JPanel(); //creating a panel with a box like a tic tac toe board
		panel.setLayout (new GridLayout (4, 4));
		panel.setBorder (BorderFactory.createLineBorder (Color.gray, 3));
		panel.setBackground (Color.white);

		for(int i=0; i<=15; i++){ //placing the button onto the board
			buttons[i] = new MyButton();
			panel.add(buttons[i]);			
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
}
