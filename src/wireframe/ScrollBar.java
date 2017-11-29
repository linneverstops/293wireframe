package wireframe;import javax.swing.*;
import java.awt.*;

public class ScrollBar extends Elements {

    public ScrollBar(int location_x, int location_y) {
        this.width = -1;
        this.length = -1;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component = new JScrollBar(Adjustable.VERTICAL);
    }
}
