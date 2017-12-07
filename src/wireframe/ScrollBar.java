package wireframe;
import javax.swing.*;

/**
 * Class ScrollBar
 *
 * Represents a ScrollBar on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class ScrollBar extends Elements {

    /**
     * Constructor of Class ScrollBar
     * @param width The width of the ScrollBar
     * @param length The length of the ScrollBar
     * @param location_x The x-coordinate of the ScrollBar
     * @param location_y The y-coordinate of the ScrollBar
     * @param orientation The orientation of the ScrollBar
     */
    public ScrollBar(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JScrollBar(orientation));
    }

}
