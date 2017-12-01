package wireframe;
import javax.swing.*;

abstract class Elements extends Groups {

    private int width;

    private int length;

    private int location_x;

    private int location_y;

    private JComponent component;

    Elements(int width, int length, int location_x, int location_y, JComponent component) {
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.component = component;
    }

    public void resize(int width, int length) throws WireframeException {
        checkIsLocked();
        this.width = width;
        this.length = length;
    }

    @Override
    public void annotate(String annotation) throws WireframeException {
        checkIsLocked();
        setAnnotation(new Annotations(location_x, location_y + length, annotation));
    }

    @Override
    public void move(int location_x, int location_y) throws WireframeException {
        checkIsLocked();
        this.location_x = location_x;
        this.location_y = location_y;
    }

    int getLocation_x() {
        return this.location_x;
    }

    int getLocation_y() {
        return this.location_y;
    }

    int getWidth() {
        return this.width;
    }

    int getLength() {
        return this.length;
    }

    JComponent getComponent() {
        return this.component;
    }
}
