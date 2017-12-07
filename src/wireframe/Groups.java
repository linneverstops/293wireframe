package wireframe;

import javax.swing.*;

/**
 * Abstract Class Groups
 *
 * Represents a group or an element
 * @author TungHo Lin
 */
abstract class Groups {

    /**
     * The annotation of the group/element
     */
    private Annotations annotation;

    /**
     * Indicator of whether this group/element is locked
     */
    private boolean isLocked;

    /**
     * Constructor of Abstract class Groups
     */
    Groups() {
        this.annotation = null;
        isLocked = false;
    }

    /**
     * Move the groups to a new location
     * @param x Movement in the x direction
     * @param y Movement in the y direction
     * @throws WireframeException
     * @see wireframe.Group#move(int, int)
     * @see wireframe.Elements#move(int, int)
     */
    public abstract void move(int x, int y) throws WireframeException;

    /**
     * Set the groups to be locked/unlocked
     * @param locked a boolean that indicates if the groups is locked or not
     */
    public void setLock(boolean locked) {
        this.isLocked = locked;
    }

    /**
     * Add an annotation to a groups
     * @param annotation The String message of the annotation
     * @throws WireframeException
     * @see wireframe.Groups#annotate(String)
     * @see wireframe.Elements#annotate(String)
     */
    public abstract void annotate(String annotation) throws WireframeException;

    /**
     * Check if the groups is locked
     * @throws WireframeException if the groups is locked
     */
    void checkIsLocked() throws WireframeException {
        if(this.isLocked) {
            throw new WireframeException("Element is locked! No action can be done");
        }
    }

    /**
     * Check if the groups has an annotation
     * @return if the groups has an annotation
     */
    boolean hasAnnotation() {
        return this.annotation != null;
    }

    /**
     * Return the annotation of the groups
     * @return the annotation of the groups
     */
    Annotations getAnnotation() {
        return this.annotation;
    }

    /**
     * Set the annotation of the groups
     * @param annotation the annotation to be set
     */
    void setAnnotation(Annotations annotation) {
        this.annotation = annotation;
    }

    /**
     * Retrieve the JComponent of the annotation
     * @return the JComponent of the annotation
     */
    JComponent annotationComponent() {
        return this.annotation.getComponent();
    }
}
