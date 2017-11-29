package wireframe;
import javax.swing.*;

public class List extends TextualElements {

    public List(String listData, int width, int length, int location_x, int location_y) {
        super(listData);
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component = new JList<>(listData.split(" "));
    }

}
