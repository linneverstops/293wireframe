package wireframe;
import javax.swing.*;

public class Image extends Elements {

    public Image(int width, int length, int location_x, int location_y) {
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component =  new JLabel("Image");
    }

}
