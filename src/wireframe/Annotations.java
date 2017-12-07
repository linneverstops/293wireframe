package wireframe;

import java.awt.*;

/**
 * Class Annotations
 *
 * Represents an annotation on the wireframe
 * @author TungHo Lin
 */
class Annotations extends Text {

    /**
     * The default annotations box width
     */
    private static final int ANNOTATIONS_WIDTH = 100;

    /**
     * The default annotations box length
     */
    private static final int ANNOTATIONS_LENGTH = 20;

    /**
     * Indicates whether the annotation is visible or not
     */
    private boolean isVisible;

    /**
     * Constructor of Class Annotations
     * @param location_x The x-coordinate of the annotation
     * @param location_y The y-coordinate of the annotation
     * @param annotation The String message of the annotation
     */
    Annotations(int location_x, int location_y, String annotation) {
        super(ANNOTATIONS_WIDTH, ANNOTATIONS_LENGTH, location_x, location_y, annotation);
        this.isVisible = false;
        this.getComponent().setBackground(Color.GREEN);
        this.getComponent().setOpaque(true);
        this.getComponent().setVisible(false);
    }

    /**
     * Returns whether this annotation is visible or not
     * @return whether this annotation is visible or not
     */
    boolean isVisible() {
        return this.isVisible;
    }

    /**
     * Set this annotation's visibility to be the input boolean
     * @param visible the visibility you want to set this annotation
     */
    void setIsVisible(boolean visible) {
        this.isVisible = visible;
        this.getComponent().setVisible(isVisible);
    }
}
