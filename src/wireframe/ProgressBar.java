package wireframe;
import javax.swing.*;

public class ProgressBar extends Elements {

    public ProgressBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JProgressBar(orientation, 0, 100));
        ((JProgressBar)this.getComponent()).setValue(0);
        ((JProgressBar)this.getComponent()).setStringPainted(true);
    }

}
