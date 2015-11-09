package Oppgave1;
//Import everything for graphics and windows.
import java.awt.*;
import javax.swing.*;

//Import other classical goodies
import java.util.ArrayList;

public class CompositeIcon implements Icon {
	private ArrayList<Icon> icons;
	private int width;
	private int height;
	
	public CompositeIcon() {
		icons = new ArrayList<Icon>();
		width = 0;
		height = 0;
	}
	
	/**
	 *	Adds an icon to the list of icons (and redraws?).
	 */
	public void addIcon(Icon ic) {
		icons.add(ic);

		//Changes the width accordingly
		width += ic.getIconWidth();

		//Checks if the compositeIcon got bigger.
		if(height < ic.getIconHeight()) {
			height = ic.getIconHeight();
		}
	}
	
	/**
	 *	Removes an icon from the list of icons.
	 */
	public void removeIcon(Icon ic) {
		if(icons.remove(ic)){

			//Changes the width
			width -= ic.getIconWidth();
	
			//Checks if the height has to be changed.
			if(height == ic.getIconHeight()){
				int newHeight = 0;
	
				for(Icon i : icons) {
					if (newHeight < i.getIconHeight()) {
						newHeight = i.getIconHeight();
					}
				}
			}
		}
	}
	
	/**
	 *	Returns the width of the icon
	 */
	public int getIconWidth() {
		return width;
	}
	
	/**
	 *	Returns the height of the icon
	 */
	public int getIconHeight() {
		return height;
	}
	
	/**
	 *	(Re)Paints all icons in the list in succession from left to right.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
        int newY = 0;

        for(Icon i : icons) {
			//Finds the center for the vertical.
			newY = y + (getIconHeight() - i.getIconHeight()) / 2;
			
			//Paints the current icon in the list.
			i.paintIcon(c,g,x,newY);
			
			//Finds the x coordinate for the next icon.
			x += i.getIconWidth();
		}
	}
}