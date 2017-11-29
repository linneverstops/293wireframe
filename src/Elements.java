import javax.swing.*;

abstract class Elements extends Groups {

    JComponent component;

    private int width;

    private int length;

    private int location_x;

    private int location_y;

    void resize(int width, int length) throws WireframeException {
        checkIsLocked();
        this.width = width;
        this.length = length;
    }

    void align(Wireframe.Alignment alignment) throws WireframeException {
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

    int getLocation_x() {
        return this.location_x;
    }

    int getLocation_y() {
        return this.location_y;
    }

    JComponent getComponent() {
        return this.component;
    }

    void move(int location_x, int location_y) throws WireframeException {
        checkIsLocked();
        this.location_x = location_x;
        this.location_y = location_y;
    }
}
