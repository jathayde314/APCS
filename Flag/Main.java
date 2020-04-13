import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class Main  {


    public static void main(String[] args) {
        FlagFrame Flag = new FlagFrame();
        Flag.setVisible(true);

        // Redraws Flag when Window size changes
        Flag.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                Flag.updateFrameSize();
                Flag.init();
            }
        });






    }

}