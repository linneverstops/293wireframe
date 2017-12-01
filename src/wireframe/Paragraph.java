package wireframe;
import javax.swing.*;

public class Paragraph extends Text {

    public Paragraph(int width, int length, int location_x, int location_y, String paragraph) {
        super(width, length, location_x, location_y, paragraph);
        ((JLabel)this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
    }

}
