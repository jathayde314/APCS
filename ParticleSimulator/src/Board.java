import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

    public static MainDraw[] draw;
    public static long timeDiff;
    private final int INITIAL_X = 50;
    private final int INITIAL_Y = 50;
    private final int DELAY = 25;
    private Thread animator;

    public Board(int numParts, int[][] partData) {
        initBoard(numParts, partData);
    }

    private void initBoard(int numParts, int[][] partData) {

        draw = new MainDraw[numParts];
        for(int i = 0; i < numParts; i++){
            MainDraw particle = new MainDraw(partData[i][0],partData[i][1],50,50);
            particle.x_velo = partData[i][2];
            particle.y_velo = partData[i][3];
            draw[i] = particle;
        }
        setBackground(Color.WHITE);
        // InputListener listener = new InputListener();
        // this.addKeyListener(listener);

    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCar(g);
    }

    private void drawCar(Graphics g) {
        for(int i = 0; i < draw.length; i++){
            g.fillRect(draw[i].x,draw[i].y,draw[i].carWidth,draw[i].carHeight);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void particleCollisions(){
        for(int i = 0; i < draw.length; i++){
            for(int j = i+1; j < draw.length; j++){
                if(draw[i].x+draw[i].carWidth > draw[j].x && draw[i].x+draw[i].carWidth - draw[j].x < 10 && Math.abs(draw[i].y-draw[j].y)<draw[i].carHeight){
                    draw[i].x = draw[j].x - draw[i].carWidth;
                    if(draw[i].x_velo>0){
                        draw[i].x_velo = -draw[i].x_velo;
                    }
                    if(draw[j].x_velo < 0){
                        draw[j].x_velo = -draw[j].x_velo;
                    }
                } else if(draw[j].x+draw[j].carWidth > draw[i].x && draw[j].x+draw[j].carWidth - draw[i].x < 10  && Math.abs(draw[i].y-draw[j].y)<draw[i].carHeight){
                    draw[j].x = draw[i].x - draw[j].carWidth;
                    if(draw[j].x_velo>0){
                        draw[j].x_velo = -draw[j].x_velo;
                    }
                    if(draw[i].x_velo < 0){
                        draw[i].x_velo = -draw[i].x_velo;
                    }
                }

                if(draw[i].y+draw[i].carHeight > draw[j].y && draw[i].y+draw[i].carHeight - draw[j].y < 10 && Math.abs(draw[i].x-draw[j].x)<draw[i].carWidth){
                    draw[i].y = draw[j].y - draw[i].carHeight;
                    if(draw[i].y_velo > 0){
                        draw[i].y_velo = -draw[i].y_velo;
                    }
                    if(draw[j].y_velo < 0){
                        draw[j].y_velo = -draw[j].y_velo;
                    }
                } else if(draw[j].y+draw[j].carHeight > draw[i].y && draw[j].y+draw[j].carHeight - draw[i].y < 10 && Math.abs(draw[i].x-draw[j].x)<draw[i].carWidth) {
                    draw[j].y = draw[i].y - draw[j].carHeight;
                    if(draw[j].y_velo > 0){
                        draw[j].y_velo = -draw[j].y_velo;
                    }
                    if(draw[i].y_velo < 0){
                        draw[i].y_velo = -draw[i].y_velo;
                    }
                }
            }
        }
    }

    @Override
    public void run() {

        long time, sleep;
        time = System.currentTimeMillis();

        while (!Thread.interrupted()) {

            //Moves all draw objects
            for(int i = 0; i < draw.length; i++){
                draw[i].cycle();
                if(getWidth()>=600){ //deals with edge collisions
                    draw[i].inFrame(getWidth(),getHeight());
                } else { //Start case where getWidth and getHeight are 0
                    draw[i].inFrame(600,600);
                }
            }

            particleCollisions();

            repaint();

            timeDiff = System.currentTimeMillis() - time;
            if (timeDiff > DELAY) { // Sets sleep to 0 if more than 25 ms have passed
                sleep = 0;
            } else { // Sets sleep to time until 25 ms
                sleep = DELAY - timeDiff;
            }

            try {
                Thread.sleep(sleep); // Runs in 25 ms intervals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time = System.currentTimeMillis();
        }
    }

}
