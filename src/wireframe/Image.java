package wireframe;
import javax.swing.*;
import java.awt.*;

class Image extends Elements {

    Image(int width, int length, int location_x, int location_y, String imagePath) {
        super(width, length, location_x, location_y, new JLabel(new ImageIcon(imagePath)));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
