package wireframe;

import javax.swing.*;
import java.awt.*;

/**
 * Class Box
 *
 * Represents a box with red borders on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
class Box extends Elements {

    /**
     * Constructor of Class Box
     * @param width The width of the Box
     * @param length The length of the Box
     * @param location_x The x-coordinate of the Box
     * @param location_y The y-coordinate of the Box
     */
    Box(int width, int length, int location_x, int location_y) {
        super(width, length, location_x, location_y, new JLabel());
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.RED));
    }
}
