package wireframe;

import javax.swing.*;
import java.awt.*;

class Box extends Elements {

    Box(int width, int length, int location_x, int location_y) {
        super(width, length, location_x, location_y, new JLabel());
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.RED));
    }
}
