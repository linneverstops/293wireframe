package wireframe;
import javax.swing.*;

public class ComboBox extends Elements {

    String[] elements;

    public ComboBox(String[] elements, int width, int length, int location_x, int location_y) {
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component =  new JComboBox<>(elements);
    }
}
