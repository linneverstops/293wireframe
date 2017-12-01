package wireframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Group extends Groups {

    private List<Groups> elements;

    public Group() {
        this.elements = new ArrayList<>();
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
