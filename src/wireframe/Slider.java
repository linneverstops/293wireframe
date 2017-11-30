package wireframe;
import javax.swing.*;

public class Slider extends Elements {

    public Slider(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JSlider(orientation));
    }
}
