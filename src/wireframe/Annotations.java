package wireframe;

import java.awt.*;

class Annotations extends Text {

    private static final int ANNOTATIONS_WIDTH = 100, ANNOTATIONS_LENGTH = 20;

    private boolean isVisible;

    Annotations(int location_x, int location_y, String annotation) {
        super(ANNOTATIONS_WIDTH, ANNOTATIONS_LENGTH, location_x, location_y, annotation);
        this.isVisible = false;
        this.getComponent().setBackground(Color.GREEN);
        this.getComponent().setOpaque(true);
        this.getComponent().setVisible(false);
    }

    void setIsVisible(boolean visible) {
        this.isVisible = visible;
        this.getComponent().setVisible(isVisible);
    }
}
