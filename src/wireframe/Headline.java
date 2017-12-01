package wireframe;
import java.awt.*;

class Headline extends Text {

    Headline(int width, int length, int location_x, int location_y, String headline) {
        super(width, length, location_x, location_y, headline);
        this.getComponent().setFont(new Font("Courier", Font.BOLD, 25));
    }

}
