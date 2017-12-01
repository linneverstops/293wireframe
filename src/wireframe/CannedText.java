package wireframe;

import javax.swing.*;
import java.awt.*;

public class CannedText extends Elements {

    private final String text;

    public CannedText(int width, int length, int location_x, int location_y, String text) {
        super(width, length, location_x, location_y, new JLabel("<html>"+ text +"</html>"));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
        ((JLabel)this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
        this.text = text;
    }

}
