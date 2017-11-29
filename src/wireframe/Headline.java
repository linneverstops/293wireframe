package wireframe;
import javax.swing.*;

public class Headline extends TextualElements {

    public Headline(String headline, int width, int length, int location_x, int location_y) {
        super(headline);
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.isLocked = false;
        this.component = new JTextArea(headline);
    }

}
