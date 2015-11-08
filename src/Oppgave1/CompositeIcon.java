package Oppgave1;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class CompositeIcon implements Icon{
	
	private List<Icon> icons;
	private int height;
	private int width;
	
	public CompositeIcon(){
		//Initialize the array list and set current height and width to 0
		this.icons = new ArrayList<Icon>();
		this.height = 0;
		this.width = 0;
	}
	
	public void addIcon(Icon icon){
		this.icons.add(icon);
		
		//Efficiency, check if this image is the tallest one, and if it is
		//Set the CompositeIcon's height to it, since we only need the tallest one
		if(icon.getIconHeight() > height){
			height = icon.getIconHeight();
		}
		//Efficiency, just add the width once on ever add, instead of parsing
		//all sub-icons every time this.getIconWidth() is called;
		width += icon.getIconWidth();
	}
	
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		for(Icon icn : icons){
			
			//This test allows a reference to itself to exist within icons
			//without causing it to loop forever
			if(icn == this){
				for(Icon icn2 : icons)
				{
					if(icn2 == this){
						continue;
					}else{
						icn2.paintIcon(c, g, x, y);
						x += icn2.getIconWidth();
					}
				}
			continue;
			} //This whole check can be removed if you don't have the desire for some
			//freaky recursive composite icons, This might interfere with the real icon width
			
			
			icn.paintIcon(c, g, x, y);
			x += icn.getIconWidth();
		}
		
	}

	@Override
	public int getIconWidth() {
		/* OLD ALGORITHM
		int totalW = 0;
		for(Icon icn : icons){
			totalW += icn.getIconWidth();
		}
		return totalW;
		*/

		return width;
	}

	@Override
	public int getIconHeight() {
		/* OLD ALGORITHM
		int tallestImg = 0;
		for(Icon icn : icons){
			if(tallestImg < icn.getIconHeight()){
				tallestImg = icn.getIconHeight();
			}
		}
		return tallestImg;
		*/
		return height;
	}

}
