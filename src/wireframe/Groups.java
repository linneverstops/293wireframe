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

    public void setLock(boolean locked) {
        this.isLocked = locked;
    }

    public abstract void annotate(String annotation) throws WireframeException;

    void checkIsLocked() throws WireframeException {
        if(this.isLocked) {
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

    //get the JComponent of the annotation
    JComponent annotationComponent() {
        return this.annotation.getComponent();
    }
}
