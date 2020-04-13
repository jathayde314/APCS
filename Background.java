import javax.swing.*;
import java.awt.*;

/*
Class creates a black background to prevent old Flag from being visible in empty space.
 */
public class Background extends JLayeredPane {
    int width;
    int height;

    public Background(int frameWidth, int frameHeight){
        //Sets size to size of window and repaints
        width = frameWidth;
        height = frameHeight;
        setSize(width , height);
        setVisible(true);
        repaint();
    }

    public void paint(Graphics g){
        // Paints black background
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);

    }
}
