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
        assert width > 0;
        assert length > 0;
        checkIsLocked();
        this.width = width;
        this.length = length;
    }

    @Override
    public void annotate(String annotation) throws WireframeException {
        checkIsLocked();
        checkEmptyString(annotation);
        setAnnotation(new Annotations(location_x, location_y + length, annotation));
    }

    @Override
    public void move(int location_x, int location_y) throws WireframeException {
        assert location_x >= 0;
        assert location_y >= 0;
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

    private void checkEmptyString(String input) throws WireframeException {
        if(input == null || input.length() == 0)
            throw new WireframeException("Annotation can not be empty");
    }
}
