import java.awt.*;
import javax.swing.*;

public class Star extends JLayeredPane {

    int x;
    int y;
    int[] roundedXValues;
    int[] roundedYValues;
    int numbOfPoints;

    public Star (int x1, int y1, int scaleFactor, int numberOfPoints) {
        /*
        @param center of star at (x1, y1), scaleFactor, and number of points that the star has
        @return null
        prints a star with the given number of points, with diameter 0.0616*scaleFactor, with center x1,y1
         */

        numbOfPoints = numberOfPoints;

        x = x1;
        y = y1;

        double outerRadius = 0.0616 * scaleFactor / 2;
        double innerRadius = outerRadius * Math.sin(Math.PI / (2*numberOfPoints)) / Math.sin(3 * Math.PI / (2*numberOfPoints)); //Law of sine with "pi -" removed

        double[] xValues = new double[2*numberOfPoints];
        double[] yValues = new double[2*numberOfPoints];

        double theta = Math.PI / 2; //Rotates them upright

        for(int i=0; i<numberOfPoints; i++){
            xValues[2*i] = x + outerRadius*Math.cos(theta);
            yValues[2*i] = y - outerRadius*Math.sin(theta);
            theta += Math.PI/numberOfPoints;
            xValues[2*i + 1] = x + innerRadius*Math.cos(theta);
            yValues[2*i + 1] = y - innerRadius*Math.sin(theta);
            theta += Math.PI/numberOfPoints;
        }



        roundedXValues = RoundArray(xValues, 2*numberOfPoints);
        roundedYValues = RoundArray(yValues, 2*numberOfPoints);

        init();



    }


    public void init() {
        //Paints stars
        setVisible(true);
        setSize(800,800);
        repaint();

    }


    public int[] RoundArray(double[] array, int length){
        //Takes a double array and returns a rounded int array
        int[] rounded = new int[length];
        for (int i = 0; i < array.length; i++){
            rounded[i] = (int) Math.round(array[i]);

        }
        return rounded;
    }

        public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillPolygon(roundedXValues, roundedYValues, 2*numbOfPoints);

    }

}
