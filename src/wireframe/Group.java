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
        this.elements.add(group);
    }

    public void removeFromGroup(Groups group) throws WireframeException {
        checkIsLocked();
        int groupIndex = this.elements.indexOf(group);
        this.elements.remove(group);
    }
}
