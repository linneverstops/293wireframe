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
        JFrame jframe = new JFrame("Testing");
        Container c = jframe.getContentPane();
        c.add(new JTextArea("firstline\nsecondline\n"));
        //c.add(new JSlider());
        jframe.setSize(500, 500);
        jframe.setVisible(true);
    }

    public void displayWireframe() {

    }

    void addToWireframe(Groups group) {
        this.elements.add(group);
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
