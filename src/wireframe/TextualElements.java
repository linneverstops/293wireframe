package wireframe;
abstract class TextualElements extends Elements {

    final String text;

    TextualElements(String text) {
        this.text = text;
    }

    String getText() {
        return this.text;
    }
}
