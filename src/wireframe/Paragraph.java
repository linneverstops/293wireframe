package wireframe;
import javax.swing.*;

public class Paragraph extends Elements {

    public Paragraph(int width, int length, int location_x, int location_y, String paragraph) {
        super(width, length, location_x, location_y, new JLabel("<html>"+ paragraph +"</html>"));
        ((JLabel)this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
    }

}
