package wireframe;
import javax.swing.*;

class Slider extends Elements {

    Slider(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JSlider(orientation));
    }

}
