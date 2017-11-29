package wireframe;
import javax.swing.*;

public class Paragraph extends TextualElements {

    public Paragraph(String paragraph, int width, int length, int location_x, int location_y) {
        super(paragraph);
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component = new JTextArea(paragraph);
    }

}
