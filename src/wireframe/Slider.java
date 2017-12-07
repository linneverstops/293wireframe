package wireframe;
import javax.swing.*;

/**
 * Class Slider
 *
 * Represents a Slider on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
class Slider extends Elements {

    /**
     * Constructor of Class Slider
     * @param width The width of the Slider
     * @param length The length of the Slider
     * @param location_x The x-coordinate of the Slider
     * @param location_y The y-coordinate of the Slider
     * @param orientation The orientation of the Slider
     */
    Slider(int width, int length, int location_x, int location_y, int orientation) {
        super(width, length, location_x, location_y, new JSlider(orientation));
    }

}
