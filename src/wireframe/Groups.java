package wireframe;

import javax.swing.*;

abstract class Groups {

    private Annotations annotation;

    private boolean isLocked;

    Groups() {
        this.annotation = null;
        isLocked = false;
    }

    public abstract void move(int x, int y) throws WireframeException;

    public void setIsLocked(boolean locked) {
        this.isLocked = locked;
    }

    public abstract void annotate(String annotation) throws WireframeException;

    private boolean isLocked() {
        return this.isLocked;
    }

    void checkIsLocked() throws WireframeException {
        if(isLocked()) {
            throw new WireframeException("Element is locked!");
        }
    }

    boolean hasAnnotation() {
        return this.annotation != null;
    }

    Annotations getAnnotation() {
        return this.annotation;
    }

    void setAnnotation(Annotations annotation) {
        this.annotation = annotation;
    }

    JComponent annotationComponent() {
        return this.annotation.getComponent();
    }
}
