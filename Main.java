import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;

public class Main extends JFrame {


    public Main(int numParts, int[][] partData) {

        init(numParts, partData);
    }

    private void init(int numParts, int[][] partData) {

        add(new Board(numParts, partData));

        setTitle("Square Move Practice");
        setResizable(true);
        setSize(600, 600);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of particles: ");
        int numPart = scanner.nextInt();

        int[][] partData = new int[numPart][4];

        for(int i = 0; i < numPart; i++){
            System.out.print("Enter the x-position of particle #" + i + ":");
            int xpos = scanner.nextInt();
            partData[i][0] = xpos;
            System.out.print("Enter the y-position of particle #" + i + ":");
            int ypos = scanner.nextInt();
            partData[i][1] = ypos;
            System.out.print("Enter the x-velocity of particle #" + i + ":");
            int xvelo = scanner.nextInt();
            partData[i][2] = xvelo;
            System.out.print("Enter the y-velocity of particle #" + i + ":");
            int yvelo = scanner.nextInt();
            partData[i][3] = yvelo;
        }

        EventQueue.invokeLater(() -> {
            new Main(numPart, partData);
        });

    }


}

