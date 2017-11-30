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

    //need to change this
    public void align(Wireframe.Alignment alignment) throws WireframeException {
        checkIsLocked();
        switch(alignment) {
            case LEFT:
                move(0, this.location_y);
                break;
            case RIGHT:
                move(this.width, this.location_y);
                break;
            case CENTER:
                move(this.width/2, this.length/2);
                break;
            case JUSTIFIED:
                //move()
                break;
            default:
                throw new WireframeException("No such Alignment");
        }
    }

    public int getLocation_x() {
        return this.location_x;
    }

    public int getLocation_y() {
        return this.location_y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public JComponent getComponent() {
        return this.component;
    }

    public void move(int location_x, int location_y) throws WireframeException {
        checkIsLocked();
        this.location_x = location_x;
        this.location_y = location_y;
    }
}
