package wireframe;
abstract class Groups {

    private Annotations annotation;

    private boolean isLocked;

    Groups() {
        this.annotation = null;
        isLocked = false;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public void annotate(String annotation) {
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
