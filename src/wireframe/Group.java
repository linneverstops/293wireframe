package wireframe;
import java.util.Collections;
import java.util.List;

class Group extends Groups {

    private List<Groups> elements;

    public Group() {
        this.elements = Collections.emptyList();
    }

    void group(Groups group) throws WireframeException {
        checkIsLocked();
        this.elements.add(group);
    }

    void ungroup(Groups group) throws WireframeException {
        checkIsLocked();
        int groupIndex = this.elements.indexOf(group);
        this.elements.remove(group);
    }
}
