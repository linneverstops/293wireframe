package wireframe;
import javax.swing.*;
import java.awt.*;

public class Image extends Elements {

    public Image(int width, int length, int location_x, int location_y, String imagePath) {
        super(width, length, location_x, location_y, new JLabel(new ImageIcon(imagePath)));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
