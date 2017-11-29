package wireframe;
public abstract class Groups {

    Annotations annotation;

    boolean isLocked;

    void lock() {
        this.isLocked = true;
    }

    void unlock() {
        this.isLocked = false;
    }

    void annotate(String annotation) {
        this.annotation = new Annotations(annotation);
    }

    boolean isLocked() {
        return this.isLocked;
    }

    void checkIsLocked() throws WireframeException {
        if(isLocked()) {
            throw new WireframeException("Element is locked!");
        }
    }
}
