package wireframe;
import java.util.ArrayList;
import java.util.List;

class Group extends Groups {

    private List<Groups> elements;

    public Group() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void move(int x_units, int y_units) throws WireframeException {
        checkIsLocked();
        for(Groups component : this.elements) {
            if(Wireframe.isAnElement(component)) {
                Elements element = (Elements)component;
                element.move(newLocation(element, x_units), newLocation(element, y_units));
            }
            else {
                Group subgroup = (Group)component;
                subgroup.move(x_units, y_units);
            }
        }
    }

    @Override
    public void annotate(String annotation) throws WireframeException {
        checkIsLocked();
        if(elements.isEmpty())
            throw new WireframeException("This group is empty");
        elements.get(0).annotate(annotation);
    }

    public void addToGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.addGroupToListAtIndex(group, this.elements, 0);
    }

    public void removeFromGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.removeGroupFromList(group, this.elements);
    }

    List<Groups> getElements() {
        return this.elements;
    }

    private int newLocation(Elements element, int unitsOfMovement) {
        return element.getLocation_x() + unitsOfMovement;
    }
}
