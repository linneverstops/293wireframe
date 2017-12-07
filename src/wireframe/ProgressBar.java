package wireframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class ProgressBar
 *
 * Represents a ProgressBar on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class ProgressBar extends Elements {

    /**
     * the timer that will start the ProgressBar
     */
    private Timer timer = new Timer(100, new ActionListener() {

        private int counter = 1;

        @Override
        public void actionPerformed(ActionEvent event) {
            ((JProgressBar)getComponent()).setValue(++counter);
            if (counter > 100) {
                timer.stop();
            }
        }
    });

    /**
     * Constructor of Class ProgressBar
     * @param width The width of the ProgressBar
     * @param length The length of the ProgressBar
     * @param location_x The x-coordinate of the ProgressBar
     * @param location_y The y-coordinate of the ProgressBar
     * @param orientation The orientation of the ProgressBar
     */
    public ProgressBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JProgressBar(orientation, 0, 100));
        JProgressBar progressBar = ((JProgressBar)this.getComponent());
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        timer.start();
    }

}
