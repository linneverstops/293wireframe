package wireframe;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Wireframe extends JFrame {

    public enum Alignment {
        LEFT(SwingConstants.LEFT),
        RIGHT(SwingConstants.RIGHT),
        CENTER(SwingConstants.CENTER),
        JUSTIFIED(SwingConstants.LEADING),
        VERTICAL(SwingConstants.VERTICAL),
        HORIZONTAL(SwingConstants.HORIZONTAL);

        private int orientation;

        Alignment(int orientation) {
            this.orientation = orientation;
        }
    }

    private List<Groups> components;

    public Wireframe(int width, int length) {
        this.setSize(width, length);
        this.components = new ArrayList<>();
    }

    public static void main(String[] args) throws WireframeException {
        Wireframe wireframe = new Wireframe(500, 600);
        wireframe.setLayout(null);
        Image image = new Image(200, 200, 30, 30, "image.png");
        Paragraph paragraph = new Paragraph(200, 100, 30, 260, "This is a paragraph, a paragraph with some sentences with some words that don't mean anything so please don't read it.");
        String[] combo = {"One", "Two", "Three"};
        ComboBox comboBox = new ComboBox(200, 30, 30, 390, combo);
        ProgressBar progressBar = new ProgressBar(200, 30, 30, 470, SwingConstants.HORIZONTAL);


        Headline headline = new Headline(200, 30, 270, 30, "EECS293 PA12");
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore";
        CannedText text = new CannedText(200, 220, 270, 90, loremIpsum);
        //((JLabel)text.getComponent()).setText("lalala");
        Slider slider = new Slider(200, 50, 270, 340, SwingConstants.HORIZONTAL);
        String[] listData = {"List1", "List2", "List3"};
        wireframe.List list = new wireframe.List(150, 100, 270, 420, listData);
        ScrollBar scrollBar = new ScrollBar(40,100, 430, 420, SwingConstants.VERTICAL);
        Group group = new Group();
        group.addToGroup(list);
        group.addToGroup(scrollBar);
        Group bgroup = new Group();
        bgroup.addToGroup(group);
        wireframe.addToWireframe(image);
        wireframe.addToWireframe(paragraph);
        wireframe.addToWireframe(comboBox);
        wireframe.addToWireframe(progressBar);
        wireframe.addToWireframe(headline);
        wireframe.addToWireframe(text);
        wireframe.addToWireframe(slider);
        wireframe.addToWireframe(bgroup);
        //wireframe.addToWireframe(list);
        //wireframe.addToWireframe(scrollBar);
        wireframe.displayGUI();
    }

    public void displayGUI() {
        this.addComponentsToGUI(this.components);
        this.setVisible(true);
    }

    public void addToWireframe(Groups group) {
        Wireframe.addGroupToListAtIndex(group, this.components, 0);
    }

    public void removeFromWireframe(Groups group) throws WireframeException {
        Wireframe.removeGroupFromList(group, this.components);
    }

    public void moveGroupToIndex(Groups group, int index) throws WireframeException {
        checkValidIndex(index);
        Wireframe.removeGroupFromList(group, this.components);
        Wireframe.addGroupToListAtIndex(group, this.components, index);
    }

    private static void checkGroupExist(Groups group, List<Groups> components) throws WireframeException {
        if(!components.contains(group))
            throw new WireframeException("No such group/element");
    }

    private void checkValidIndex(int index) throws WireframeException {
        if(index >= components.size())
            throw new WireframeException("Index larger than total number of components");
    }

    static void addGroupToListAtIndex(Groups group, List<Groups> list, int index) {
        list.add(index, group);
    }

    static void removeGroupFromList(Groups group, List<Groups> list) throws WireframeException {
        Wireframe.checkGroupExist(group, list);
        int elementIndex = list.indexOf(group);
        list.remove(elementIndex);
    }

    private boolean isAnElement(Groups group) {
        return Elements.class.isAssignableFrom(group.getClass());
    }

    private void addComponentsToGUI(List<Groups> list) {
        for(Groups component : list) {
            if(isAnElement(component)) {
                Elements element = (Elements)component;
                element.getComponent().setBounds(element.getLocation_x(), element.getLocation_y(), element.getWidth(), element.getLength());
                add(element.getComponent());
            }
            else {
                //recursively retrieve all elements from the group
                Group group = (Group)component;
                addComponentsToGUI(group.getElements());
            }
        }
    }
}
