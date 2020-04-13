import java.awt.*;
import javax.swing.*;

public class Union extends JLayeredPane {

    private int scaleFactor;

    public Union(int scale){
        /*
        @param scale
        @return null
        paints a blue union
         */
        scaleFactor = scale;
        setSize( (int) (0.76 * scaleFactor), (int) (0.5385 * scaleFactor));
        setVisible(true);
        repaint();
    }


    public void paint(Graphics g){
        // Paints a blue rectangle of the correct size.
        Color FlagBlue = new Color(60, 59, 110);
        g.setColor(FlagBlue);
        g.fillRect(0,0,(int) (0.76 * scaleFactor),(int) (0.5385 * scaleFactor));


    }
}
