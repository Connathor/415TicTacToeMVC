import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import Package.MyButton;

public class Controller implements ActionListener{
    private Model model;
	private View view;
	
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        MyButton butt;
        if (source instanceof MyButton) {
            butt = (MyButton)source;
            //System.out.println("the controller sends " + butt.col + " and row: " + butt.row);
            model.update(butt.row,butt.col);
            if(!model.hasWon){
                view.update();
            }
            if(model.win){
                view.update();
                model.hasWon=true;
                model.win=false;
            }

        }
        
        
	}

}
