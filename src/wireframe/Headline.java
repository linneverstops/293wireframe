package wireframe;
import javax.swing.*;
import java.awt.*;

public class Headline extends Elements{

    public Headline(int width, int length, int location_x, int location_y, String headline) {
        super(width, length, location_x, location_y, new JLabel(headline));
        this.getComponent().setFont(new Font("Courier", Font.BOLD, 25));
    }

    public void setFont(Font font) {
        this.getComponent().setFont(font);
    }

}
