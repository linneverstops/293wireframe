package wireframe;
class Annotations extends Elements {

    private String annotation;

    private boolean isVisible;

    public Annotations(String annotation) {
        this.annotation = annotation;
    }

    void setText(String annotation) {
        this.annotation = annotation;
    }

    void display() {
        this.isVisible = true;
    }

    void hide() {
        this.isVisible = false;
    }
}
