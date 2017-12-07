package wireframe;
import javax.swing.*;

/**
 * Class ComboBox
 *
 * Represents a combobox on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
class ComboBox extends Elements {

    /**
     * Constructor of Class ComboBox
     * @param width The width of the ComboBox
     * @param length The length of the ComboBox
     * @param location_x The x-coordinate of the ComboBox
     * @param location_y The y-coordinate of the ComboBox
     * @param combo The array of Strings that represent the options in the ComboBox
     */
    ComboBox(int width, int length, int location_x, int location_y, String[] combo) {
        super(width, length, location_x, location_y, new JComboBox<>(combo));
    }

}
