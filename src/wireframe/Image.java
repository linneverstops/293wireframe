package wireframe;
import javax.swing.*;
import java.awt.*;

/**
 * Class Image
 *
 * Represents an image on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
public class Image extends Elements {

    /**
     * Constructor of Class Image
     * @param width The width of the image
     * @param length tThe length of the image
     * @param location_x The x coordinate of the image
     * @param location_y The y coordinate of the image
     * @param imagePath The String path of the image
     */
    public Image(int width, int length, int location_x, int location_y, String imagePath) {
        super(width, length, location_x, location_y, new JLabel(new ImageIcon(imagePath)));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
