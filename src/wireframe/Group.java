package wireframe;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Group
 *
 * Represents a group that contains elements and/or subgroups
 * @author TungHo Lin
 * @see wireframe.Groups
 */
class Group extends Groups {

    /**
     * The List of elements and/or subgroups
     */
    private List<Groups> elements;

    /**
     * Constructor of Class Group
     */
    public Group() {
        this.elements = new ArrayList<>();
    }

    /**
     * Move the whole Group by x units and y units
     * @param x_units The amount of units the Group will move in the x direction
     * @param y_units The amount of units the Group will move in the y direction
     * @throws WireframeException if the Group is locked
     */
    @Override
    public void move(int x_units, int y_units) throws WireframeException {
        checkIsLocked();
        for(Groups component : this.elements) {
            if(Wireframe.isAnElement(component)) {
                Elements element = (Elements)component;
                element.move(newLocation(element.getLocation_x(), x_units), newLocation(element.getLocation_y(), y_units));
            }
            else {
                Group subgroup = (Group)component;
                subgroup.move(x_units, y_units);
            }
        }
    }

    /**
     * Add an annotation to the group's first element/subgroup
     * @param annotation The String message of the annotation
     * @throws WireframeException if the group is locked
     */
    @Override
    public void annotate(String annotation) throws WireframeException {
        checkIsLocked();
        elements.get(0).annotate(annotation);
    }

    /**
     * Add a group/element into this group
     * @param group The group/element to be added
     * @throws WireframeException if the group is locked
     */
    public void addToGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.addGroupToListAtIndex(group, this.elements, 0);
    }

    /**
     * Remove a group/element from this group
     * @param group The group/element to be removed
     * @throws WireframeException if the group is locked
     */
    public void removeFromGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.removeGroupFromList(group, this.elements);
    }

    /**
     * Return the List of elements/subgroups of this group
     * @return the List of elements/subgroups of this group
     */
    List<Groups> getElements() {
        return this.elements;
    }

    /**
     * Return the new coordinate after moving a certain number of units specified by the input parameter unitsOfMovement
     * @param originalValue The original coordinate
     * @param unitsOfMovement The number of units to be moved
     * @return the new coordinate after moving a certain number of units
     */
    private int newLocation(int originalValue, int unitsOfMovement) {
        return originalValue + unitsOfMovement;
    }
}
