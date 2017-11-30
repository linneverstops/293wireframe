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
        wireframe.setVisible(true);
    }



    public void addToWireframe(Groups group) {
        this.components.add(group);
        if(isAnElement(group)) {
            Elements element = (Elements)group;
            element.getComponent().setBounds(element.getLocation_x(), element.getLocation_y(), element.getWidth(), element.getLength());
            add(element.getComponent());
        }
        else {
            //recursively retrieve all elements from the group
            Group bigGroup = (Group)group;
            for (Groups smallGroup : bigGroup.getElements())
                addToWireframe(smallGroup);
        }
    }

        public void removeFromWireframe(Groups group) {
        int elementIndex = this.components.indexOf(group);
        this.components.remove(elementIndex);
    }

    public void moveGroupToIndex(Groups group, int index) throws WireframeException {
        checkGroupExist(group);
        if(index >= components.size())
            throw new WireframeException("Index larger than total number of components");
        int elementIndex = components.indexOf(group);
        this.components.add(index, group);
        if(index <= elementIndex)
            this.components.remove(elementIndex + 1);
        else
            this.components.remove(elementIndex);
    }

    private void checkGroupExist(Groups group) throws WireframeException {
        if(!components.contains(group))
            throw new WireframeException("No such group/element");
    }

    private boolean isAnElement(Groups group) {
        return Elements.class.isAssignableFrom(group.getClass());
    }
}
