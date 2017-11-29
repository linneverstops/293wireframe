public abstract class Groups {

    Annotations annotation;

    boolean isLocked;

    void lock() {
        this.isLocked = true;
    }

    void unlock() {
        this.isLocked = false;
    }

    void addAnnotation(Annotations annotation) {
        this.annotation = annotation;
    }

    void removeAnnotation() {
        this.annotation = null;
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
