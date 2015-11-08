package CompositeIconTest;

import javax.swing.*;
import java.awt.*;

public class CompositeIconTest {
    public static void main(String[] args) {
        SquareIcon red = new SquareIcon(20,Color.RED); 
        SquareIcon yellow = new SquareIcon(40,Color.YELLOW); 
        SquareIcon magenta = new SquareIcon(80,Color.MAGENTA); 
        SquareIcon blue = new SquareIcon(40,Color.BLUE); 
        
        CompositeIcon ci = new CompositeIcon();
        ci.addIcon(red);
        ci.addIcon(yellow);
        ci.addIcon(magenta);
        ci.addIcon(yellow);
        ci.addIcon(red);

        CompositeIcon ci2 = new CompositeIcon();
        ci2.addIcon(blue);
        ci2.addIcon(ci);
        ci2.addIcon(ci);
        ci2.addIcon(ci);
        ci2.addIcon(blue);

        JOptionPane.showMessageDialog(
            null,
            "CompositeIcon!",
            "CompositeIcon Test",
            JOptionPane.INFORMATION_MESSAGE,
            ci2
        );
    }
}