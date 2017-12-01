package wireframe;
import javax.swing.*;

class ComboBox extends Elements {

    private String[] combo;

    ComboBox(int width, int length, int location_x, int location_y, String[] combo) {
        super(width, length, location_x, location_y, new JComboBox<>(combo));
        this.combo = combo;
    }

    public String[] geCombo() {
        return combo;
    }

}
