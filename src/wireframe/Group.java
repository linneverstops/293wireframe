package wireframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Group extends Groups {

    private List<Groups> elements;

    public Group() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void move(int x_units, int y_units) throws WireframeException {
        for(Groups component : this.elements) {
            if(Wireframe.isAnElement(component)) {
                Elements element = (Elements)component;
                int new_x = element.getLocation_x() + x_units;
                int new_y = element.getLocation_y() + y_units;
                element.move(new_x, new_y);
            }
            else {
                Group subgroup = (Group)component;
                subgroup.move(x_units, y_units);
            }
        }
    }

    @Override
    public void annotate(String annotation) throws WireframeException {
        if(elements.isEmpty())
            throw new WireframeException("This group is empty");
        elements.get(0).annotate(annotation);
    }

    public List<Groups> getElements() {
        return this.elements;
    }

    public void addToGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.addGroupToListAtIndex(group, this.elements, 0);
    }

    public void removeFromGroup(Groups group) throws WireframeException {
        checkIsLocked();
        Wireframe.removeGroupFromList(group, this.elements);
    }
}
