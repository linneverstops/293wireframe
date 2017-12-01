package wireframe;import javax.swing.*;
import java.awt.*;

class ScrollBar extends Elements {

    ScrollBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JScrollBar(orientation));
    }

}
