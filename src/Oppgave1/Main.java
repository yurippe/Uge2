package Oppgave1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CompositeIconTest.CompositeIcon;

public class Main {
		
	public static void main(String[] args){
		//Create the jframe / window
		JFrame frame = new JFrame("Aflevering 1 / 2");
		//It says to use this for a good exit in the documentation: https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Get the root content area
		Container root = frame.getContentPane();
		
		//Make 3 buttons, red, green, and blue
		JButton red = new JButton("Red");
		JButton green = new JButton("Green");
		JButton blue = new JButton("Blue");
		
		
		//Since BorderLayout can only hold one element per position, we make that element a container by itself
		//This will hold the buttons
		JPanel buttonPanel = new JPanel();
		//Set the layout to FlowLayout, since this automatically adjusts the buttons nicely
		buttonPanel.setLayout(new FlowLayout());
		
		//Add the buttons to the container we made
		buttonPanel.add(red);
		buttonPanel.add(green);
		buttonPanel.add(blue);
		
		
		//Add the container to the main window, in the top position
		root.add(buttonPanel, BorderLayout.NORTH);
		
		//Make the label to hold our icon
		JLabel iconLabel = new JLabel();
		
		//Create the composite icon
		CompositeIcon cIcon = new CompositeIcon();
		//And place it in the label
		iconLabel.setIcon(cIcon);
		
		//Add the icon label to our frame
		root.add(iconLabel, BorderLayout.CENTER);
		
		//Add action listeners to the buttons
		red.addActionListener(createIconButtonActionListener(frame, cIcon, new SquareIcon(10, Color.RED)));
		green.addActionListener(createIconButtonActionListener(frame, cIcon, new SquareIcon(10, Color.GREEN)));
		blue.addActionListener(createIconButtonActionListener(frame, cIcon, new SquareIcon(10, Color.BLUE)));
		
		//FUN:
		//We add the CompositeIcon to itself, this is not normally permitted, but i changed the paint method to not loop forever
		JButton cpy = new JButton("Copy");
		buttonPanel.add(cpy);
		cpy.addActionListener(createIconButtonActionListener(frame, cIcon, cIcon));
		
		//Pack the window and make it visible, 
		//taken from the documentation: https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private static ActionListener createIconButtonActionListener(final JFrame frame, final CompositeIcon cicon, final Icon icon){
		
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				cicon.addIcon(icon);
				frame.pack();
				frame.repaint();
				
				
			}
			
		};
	}
	
}
