package wireframe;

import javax.swing.*;

class Annotations extends Elements {

    private String annotation;

    private boolean isVisible;

    Annotations(int width, int length, int location_x, int location_y, String annotation) {
        super(width, length, location_x, location_y, new JLabel("<html>" + annotation + "</html>"));
        this.annotation = annotation;
        this.isVisible = false;
    }

    void setText(String annotation) {
        this.annotation = annotation;
        ((JLabel)this.getComponent()).setText(annotation);
    }

    void setIsVisibility(boolean isVisible) {
        this.isVisible = isVisible;
        this.getComponent().setVisible(isVisible);
    }
}
