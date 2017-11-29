package wireframe;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
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
        this.elements = new ArrayList<>();
    }

    public static void main(String[] args) {
        Wireframe wireframe = new Wireframe(600, 600);
        Image image = new Image(100, 100, 100, 100);
        ScrollBar scrollBar = new ScrollBar(400,400);
        /*
        Border border = image.getComponent().getBorder();
        Dimension size = image.getComponent().getSize();
        border.paintBorder(image.getComponent(), 0, 0, size.width, size.height);
        */
        wireframe.addToWireframe(image);
        wireframe.addToWireframe(scrollBar);
        wireframe.displayWireframe();
    }

    public void displayWireframe() {
        this.setVisible(true);
    }

    void addToWireframe(Groups group) {
        this.elements.add(group);
        if(Elements.class.isAssignableFrom(group.getClass())) {
            Elements element = (Elements)group;
            this.container.add(element.getComponent());
            element.getComponent().setLocation(element.getLocation_x(), element.getLocation_y());
        }
        else {
            Group bigGroup = (Group)group;
            for (Groups smallGroup : ((Group) group).getElements())
                addToWireframe(smallGroup);
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
