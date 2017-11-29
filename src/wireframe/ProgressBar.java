package wireframe;
import javax.swing.*;

public class ProgressBar extends Elements {

    public ProgressBar(int location_x, int location_y) {
        this.width = -1;
        this.length = -1;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
    }
}
