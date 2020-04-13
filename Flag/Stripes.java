import java.awt.*;
import javax.swing.*;

public class Stripes extends JLayeredPane {

    private int scaleFactor;
    private int width; // of stripes
    private int height; // of stripes
    public int numOfStripes;

    public Stripes(int scale, int numberOfStripes){
        /*
        @param scale and number of stripes
        @return null
        paints alternating stripes of red and white
         */
        //Sets width and length of stripes
        numOfStripes = numberOfStripes;
        scaleFactor = scale;
        width = (int) Math.round(1.9 * scale);
        height = Math.round(scaleFactor / numOfStripes);
        setSize(width , scaleFactor);
        setVisible(true);
        repaint();
    }


    public void paint(Graphics g){
        Color FlagRed = new Color(178, 34, 52);
        g.setColor(FlagRed);
        for(int i = 0; i < (numOfStripes/2 + numOfStripes % 2); i++){
            g.fillRect(0,2 * i * height, width, height);
        }

        g.setColor(Color.WHITE);
        for(int i = 0; i < (numOfStripes/2); i++){
            g.fillRect(0,(2 * i + 1) * height, width, height);
        }



    }
}
