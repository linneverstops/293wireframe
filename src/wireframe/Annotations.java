package wireframe;

import javax.swing.*;

class Annotations extends Groups {

    private String annotation;

    private boolean isVisible;

    private JLabel label;

    Annotations(String annotation) {
        this.annotation = annotation;
        this.isVisible = false;
        this.label = new JLabel("annotation");
    }

    void setText(String annotation) {
        this.annotation = annotation;
    }

    void display() {
        this.isVisible = true;
    }

    void hide() {
        this.isVisible = false;
    }
}
