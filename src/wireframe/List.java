package wireframe;
import javax.swing.*;

class List extends Elements {

    private String[] listData;

    List(int width, int length, int location_x, int location_y, String[] listData) {
        super(width, length, location_x, location_y, new JList<>(listData));
        this.listData = listData;
    }

    String[] getListData() {
        return this.listData;
    }

}
