package wireframe;
import javax.swing.*;

/**
 * Class List
 *
 * Represents a list on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class List extends Elements {

    /**
     * Constructor of Class List
     * @param width The width of the List
     * @param length The length of the List
     * @param location_x The x-coordinate of the List
     * @param location_y The y-coordinate of the List
     * @param listData The array of Strings that represent the elements in the List
     */
    public List(int width, int length, int location_x, int location_y, String[] listData) {
        super(width, length, location_x, location_y, new JList<>(listData));
    }
}
