package wireframe;
import java.awt.*;

/**
 * Class Headline
 *
 * Represents a headline on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class Headline extends Text {

    /**
     * Constructor of Class Headline
     * @param width The width of the headline
     * @param length The length of the headline
     * @param location_x The x coordinate of the headline
     * @param location_y The y coordinate of the headline
     * @param headline The String headline
     */
    public Headline(int width, int length, int location_x, int location_y, String headline) {
        super(width, length, location_x, location_y, headline);
        this.getComponent().setFont(new Font("Courier", Font.BOLD, 25));
    }

}
