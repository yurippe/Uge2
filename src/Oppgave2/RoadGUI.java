package Oppgave2;

//Listener awesomeness
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

//GUI stuff
import javax.swing.*;

//Gui and graphics
import java.awt.*;

public class RoadGUI implements ChangeListener {
	//The counter currently referenced.
	private Counter counter;
	
	//The number currently displayed.
	private JTextField number;
	
	/**
	 *	Constructor for a RoadGUI linked to a specifik counter.
	 */
	public RoadGUI(Counter counter) {
		this.counter = counter;
		createGUI();
	}
	
	/**
	 *	Changes the counter referenced.
	 */
	public void changeCounter(Counter counter) {
		this.counter = counter;
	}
	
	/**
	 *	RoadGUI is a ChangeListener and has to implement stateChanged.
	 *
	 *	When the state changes, the RoadGUI updates the value to the current.
	 */
	public void stateChanged(ChangeEvent change) {
		number.setText("Free Spots: "+counter.getValue());
	}
	
	/**
	 *	Creates a UI, simulating a sign showing the number of free spots.
	 */
	public void createGUI(){
		//Creates the textfield
		number = new JTextField(16);
		number.setText("Free Spots: "+counter.getValue());
		
		//Creates the frame.
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		frame.add(number);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}