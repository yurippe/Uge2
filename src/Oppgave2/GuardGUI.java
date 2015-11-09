package Oppgave2;

//GUI stuff
import java.awt.event.*;
import javax.swing.*;

//Gui and graphics
import java.awt.*;


public class GuardGUI{
	//Counter currently manipulated and referenced
	private Counter counter;
	
	public GuardGUI(Counter counter) {
		this.counter = counter;
		createGUI();
	}
	
	/**
	 *	Changes the counter referenced and manipulated.
	 */
	public void changeCounter(Counter counter) {
		this.counter = counter;
	}
	
	/**
	 *	Creates the UI for the Guard
	 */
	public void createGUI(){
		//Button "in"
		JButton inButton = new JButton("Bil kører ind");
		inButton.addActionListener(createDiffButtonListener(-1));
		
		//Button "out"
		JButton outButton = new JButton("Bil kører ud");
		outButton.addActionListener(createDiffButtonListener(1));
		
		//Setting up the window
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		frame.add(inButton);
		frame.add(outButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 *	Creates an actionlistener changing the state of counter as specified
	 */
	private ActionListener createDiffButtonListener(final int i) {
		return new
			ActionListener() {
				public void actionPerformed(ActionEvent event) {
					counter.change(i);
				}
			};
	}
}