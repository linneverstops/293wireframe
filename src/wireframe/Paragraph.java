package wireframe;
import javax.swing.*;

/**
 * Class Paragraph
 *
 * Represents a paragraph on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class Paragraph extends Text {

    /**
     * Constructor of Class Paragraph
     * @param width The width of the Paragraph
     * @param length The length of the Paragraph
     * @param location_x The x coordinate of the Paragraph
     * @param location_y The y coordinate of the Paragraph
     * @param paragraph The String paragraph
     */
    public Paragraph(int width, int length, int location_x, int location_y, String paragraph) {
        super(width, length, location_x, location_y, paragraph);
        ((JLabel)this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
    }

}
