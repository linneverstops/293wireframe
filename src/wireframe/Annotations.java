package wireframe;

import javax.swing.*;

class Annotations extends Groups {

    private String annotation;

    private boolean isVisible;

    private JLabel label;

    Annotations(String annotation) {
        this.annotation = annotation;
        this.isVisible = false;
        this.label = new JLabel("<html>" + annotation + "</html>");
    }

    void setText(String annotation) {
        this.annotation = annotation;
    }

    void display() {
        this.isVisible = true;
        label.setVisible(true);
    }

    void hide() {
        this.isVisible = false;
        label.setVisible(false);
    }
}
