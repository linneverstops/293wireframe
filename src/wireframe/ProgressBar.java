package wireframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ProgressBar extends Elements {

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

    ProgressBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JProgressBar(orientation, 0, 100));
        JProgressBar progressBar = ((JProgressBar)this.getComponent());
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        timer.start();
    }

}
