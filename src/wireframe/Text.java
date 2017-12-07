package wireframe;

import javax.swing.*;
import java.awt.*;

/**
 * Class Text
 *
 * Represents a Text on the wireframe
 * @author TungHo Lin
 * @see wireframe.Elements
 */
class Text extends Elements {

    /**
     * The text that cannot be changed
     */
    private final String text;

    /**
     * Constructor of Class Text
     * @param width The width of the Text
     * @param length The length of the Text
     * @param location_x The x coordinate of the Text
     * @param location_y The y coordinate of the Text
     * @param text The String Text
     */
    Text(int width, int length, int location_x, int location_y, String text) {
        /* using html can allow multi-line read-only text in a JLabel */
        super(width, length, location_x, location_y, new JLabel("<html>" + text + "</html>"));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
        this.text = text;
        ((JLabel) this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
}

    /**
     * Align the Text according to the input alignment
     * @param alignment The new alignment of the text
     * @throws WireframeException if the element is locked
     */
    public void align(Wireframe.Alignment alignment) throws WireframeException {
        checkIsLocked();
        JLabel textBox = ((JLabel)this.getComponent());
        StringBuilder builder = new StringBuilder("<html>");
        /* append the HTML alignment into the JLabel text */
        builder.append(alignment.getExpression());
        builder.append(this.text);
        builder.append("</html>");
        textBox.setText(builder.toString());
    }

    /**
     * Return the String text
     * @return the String text
     */
    String getText() {
        return this.text;
    }

}
