package wireframe;
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Wireframe extends JFrame {

    enum Alignment {
        LEFT,
        RIGHT,
        CENTER,
        JUSTIFIED;
    }

    private Container container;

    private List<Groups> elements;

    public Wireframe(int width, int length) {
        this.container = this.getContentPane();
        this.setSize(width, length);
        this.elements = Collections.emptyList();
    }

    public static void main(String[] args) {
        Wireframe wireframe = new Wireframe(500, 500);

    }

    public void displayWireframe() {
        this.setVisible(true);
    }

    void addToWireframe(Groups group) {
        this.elements.add(group);
        if(group.getClass().equals(Elements.class)) {
            Elements element = (Elements)group;
            this.container.add(element.getComponent());
        }
        else {
            Group bigGroup = (Group)group;
            for(Groups smallGroup : group.)
        }
    }

    void moveGroupToIndex(Groups group, int index) {
        if(!elements.contains(group))
            throw new NoSuchElementException("No such element");
        if(index >= elements.size())
            throw new ArrayIndexOutOfBoundsException();
        int elementIndex = elements.indexOf(group);
        this.elements.add(index, group);
        if(index <= elementIndex)
            this.elements.remove(elementIndex + 1);
        else
            this.elements.remove(elementIndex);
    }

    void delete(Groups group) {
        int elementIndex = this.elements.indexOf(group);
        this.elements.remove(elementIndex);
    }
}
