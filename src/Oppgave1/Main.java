package Oppgave1;
//Import everything for graphics and gui
import java.awt.*;

//Import everything for windows
import java.awt.event.*;
import javax.swing.*;


public class Main {
	/**
	 *	Static fields supposed to make createIconButtonListener work.
	 */
	//CompositeIcon and its label to contain the generated squares.
	private static CompositeIcon comp;
	private static JLabel compLabel;
	
	//Frame to be "repacked"
	private static JFrame frame;
	
	/**
	 *	Creates a window containing 3 buttons creating colored squares.
	 */
	public static void main(String[] args){
		//Creates a CompositeIcon to contain all the beautiful squares
		comp = new CompositeIcon();
		
		//Creates a Label to contain the CompositeIcon.
		compLabel = new JLabel(comp);
		compLabel.setLayout(new FlowLayout());
		compLabel.setToolTipText("These are squares.");
		
		//Squares to add for the buttons.
		SquareIcon blueIcon = new SquareIcon(30,Color.BLUE);
		SquareIcon greenIcon = new SquareIcon(30,Color.GREEN);
		SquareIcon redIcon = new SquareIcon(30,Color.RED);
		
		//Buttons
		JButton blueButton = createIconButton("Blue","blue",blueIcon);
		JButton greenButton = createIconButton("Green","green",greenIcon);
		JButton redButton = createIconButton("Red","red",redIcon);

		//Creates a panel with flowlayout for the colorbuttons.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setToolTipText("These buttons add squares below.");
		
		buttonPanel.add(blueButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(redButton);
		
		//Setting up the window
		frame = new JFrame();
		frame.setLayout(new BorderLayout());	//Redundant, but here for readability
		
		frame.add(buttonPanel, BorderLayout.NORTH);
		frame.add(compLabel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Creates a JButton based on Name, color and square to add.
     */
	private static JButton createIconButton(String name, String color, SquareIcon square) {
		JButton result = new JButton(color);
		result.addActionListener(createIconButtonListener(square));
		result.setToolTipText("Make " + color + " square.");

		return result;
	}

	/**
	 *	Creates an actionlistener for the square specified.
	 *
	 *	In the first iteration a new SquareIcon object was created by a formal colorvariable,
	 *	but due to memory implifications this optimization was done.
	 */
	private static ActionListener createIconButtonListener(final SquareIcon squareIcon) {
		return new
			ActionListener() {
				public void actionPerformed(ActionEvent event) {
					comp.addIcon(squareIcon);
					compLabel.updateUI();
					frame.pack();
				}
			};
	}
}