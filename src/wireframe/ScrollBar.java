package wireframe;import javax.swing.*;
import java.awt.*;

public class ScrollBar extends Elements {

    public ScrollBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JScrollBar(orientation));
    }

}
