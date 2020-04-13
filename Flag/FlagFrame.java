import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FlagFrame extends JFrame {

    double scaleFactor; // scaleFactor determines height of Flag in pixels
    double width; // Width denotes the width of the flag in pixels

    int frameHeight;
    int frameWidth;


    public FlagFrame() {
        /*
        @param none
        @return null
        creates flag with width 1140 and height 600
         */

        setSize(1140, 600);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scaleFactor = 600;
        init();
    }

    public void init(){

        int scale = (int) scaleFactor;
        setResizable(true);

        printStars(scale);

        Union union = new Union(scale);
        union.setOpaque(false);
        add(union, 50);

        Stripes stripes = new Stripes(scale, 13);
        stripes.setOpaque(false);
        add(stripes, 51);


        Background back = new Background(frameWidth, frameHeight);
        back.setOpaque(true);
        add(back, 52);

    }

    private void printStars(int scale) {
        /*
        @param scale - used to determine size of stars.
        @return null
        Creates 50 starts in the right pattern
        Each star is placed on successive JLayeredPanes
         */



        //For loops create 5 rows of 6 stars
        for (int u = 0; u < 5; u++) {
            for (int i = 0; i < 6; i++) {
                Star s = new Star((int) Math.round(0.126 * i * scale + 0.063 * scale), (int) Math.round(0.054 * scale + 0.108 * scale * u), scale, 5);
                s.setOpaque(false);
                add(s, i + 6*u);
            }
        }

        //For loops create 4 rows of 5 stars
        for (int u = 0; u < 4; u++) {
            for (int i = 0; i < 5; i++) {
                Star s = new Star((int) Math.round(0.126 * i * scale + 0.126 * scale), (int) Math.round(0.108 * scale + 0.108 * scale * u), scale, 5);
                s.setOpaque(false);
                add(s, 30 + i + 5 * u);
            }
        }
    }

    public void updateFrameSize(){
        scaleFactor = getHeight();
        frameHeight = getHeight();
        frameWidth = getWidth();
        width = getWidth();
        if (1.9 * scaleFactor > width) {
            scaleFactor = Math.round(width / 1.9);
        } else {
            width = Math.round(1.9 * scaleFactor);
        }

    }



}
