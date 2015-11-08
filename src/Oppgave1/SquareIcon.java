package Oppgave1;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class SquareIcon implements Icon {
	
	private int size;
	private Color color;
	
	public SquareIcon(int size, Color color){
		this.size = size;
		this.color = color;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		
		g.setColor(this.color);
		g.fillRect(x, y, size, size);
		
	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public int getIconHeight() {
		return size;
	}
	
}
