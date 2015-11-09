import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SquareIcon implements Icon{
	//Size of icon
	private int size;
	//Color of icon
	private Color color;
	
	//Constructs a solid SquareIcon.
	public SquareIcon(int size, Color color){
		this.size = size;
		this.color = color;
	}
	
	/**
	 *	Returns the width of the icon
	 */
	public int getIconWidth(){
		return size;
	}
	
	/**
	 *	Returns the height of the icon
	 */
	public int getIconHeight(){
		return size;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y){
		//Implements graphics.
		Graphics2D g2 = (Graphics2D) g;
		
		//Draws a rectangle at the size specified for the icon.
		Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
		g2.setColor(color);
		g2.fill(square);
	}
}