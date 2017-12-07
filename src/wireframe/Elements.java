package wireframe;
import javax.swing.*;

/**
 * Abstract Class Elements
 *
 * Represents an element on the wireframe
 * @author TungHo Lin
 * @see wireframe.Groups
 */
abstract class Elements extends Groups {

    /**
     * The width of the element
     */
    private int width;

    /**
     * The length of the element
     */
    private int length;

    /**
     * The x-coordinate of the element
     */
    private int location_x;

    /**
     * The y-coordinate of the element
     */
    private int location_y;

    /**
     * The JComponent that represents the element
     */
    private JComponent component;

    /**
     * Constructor of Abstract Class Elements
     * @param width The width of the element
     * @param length The length of the element
     * @param location_x The x-coordinate of the element
     * @param location_y The y-coordinate of the element
     * @param component The JComponent that represents the element
     */
    Elements(int width, int length, int location_x, int location_y, JComponent component) {
        this.width = width;
        this.length = length;
        this.location_x = location_x;
        this.location_y = location_y;
        this.component = component;
    }

    /**
     * Resize the element
     * @param width The new width of the element
     * @param length The new length of the element
     * @throws WireframeException if the input parameters are not positive
     * @throws WireframeException if the element is locked
     */
    public void resize(int width, int length) throws WireframeException {
        checkPositiveInput(width, length);
        checkIsLocked();
        this.width = width;
        this.length = length;
    }

    /**
     * Add an annotation to the element
     * @param annotation The String message of the annotation
     * @throws WireframeException if the element is locked
     * @throws WireframeException if the input parameter is an empty String
     */
    @Override
    public void annotate(String annotation) throws WireframeException {
        checkIsLocked();
        checkEmptyString(annotation);
        setAnnotation(new Annotations(location_x, location_y + length, annotation));
    }

    /**
     * Move the element to a new position
     * @param location_x The new x-coordinate of the element
     * @param location_y The new y-coordinate of the element
     * @throws WireframeException if the input parameters are not positive
     * @throws WireframeException if the element is locked
     */
    @Override
    public void move(int location_x, int location_y) throws WireframeException {
        checkPositiveInput(location_x, location_y);
        checkIsLocked();
        this.location_x = location_x;
        this.location_y = location_y;
    }

    /**
     * Return the x-coordinate of the element
     * @return the x-coordinate of the element
     */
    int getLocation_x() {
        return this.location_x;
    }

    /**
     * Return the y-coordinate of the element
     * @return the y-coordinate of the element
     */
    int getLocation_y() {
        return this.location_y;
    }

    /**
     * Return the width of the element
     * @return the width of the element
     */
    int getWidth() {
        return this.width;
    }

    /**
     * Return the length of the element
     * @return the length of the element
     */
    int getLength() {
        return this.length;
    }

    /**
     * Return the JComponent of the element
     * @return the JComponent of the element
     */
    JComponent getComponent() {
        return this.component;
    }

    /**
     * Check if the input parameters are positive integers
     * @param num1 The first number to be checked
     * @param num2 The second number to be checked
     * @throws WireframeException if either of the input numbers are not positive integer
     */
    private void checkPositiveInput(int num1, int num2) throws WireframeException {
        if(isNegative(num1) && isNegative(num2))
            throw new WireframeException("Input out of range");
    }

    private boolean isNegative(int num) {
        return num < 0;
    }

    /**
     * Check if the input String is empty or null
     * @param input The String to be checked
     * @throws WireframeException if the input String is empty or null
     */
    private void checkEmptyString(String input) throws WireframeException {
        if(input == null || input.length() == 0)
            throw new WireframeException("Annotation can not be empty");
    }
}
