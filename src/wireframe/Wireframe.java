package wireframe;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Wireframe extends JLayeredPane implements ActionListener {

    public enum Alignment {
        LEFT("<body style='text-align: left'>"),
        RIGHT("<body style='text-align: right'>"),
        CENTER("<body style='text-align: center'>"),
        JUSTIFIED("<body style='text-align: justify'>");

        private String expression;

        Alignment(String expression) {
            this.expression = expression;
        }

        String getExpression() {
            return expression;
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
        JButton button = new JButton("Display All Annotations");
        button.addActionListener(wireframe);
        Box box = new Box(200, 100, 270, 420);
        box.annotate("Box and List");
        Image image = new Image(200, 200, 30, 30, "cwru.png");
        image.annotate("Image");
        Paragraph paragraph = new Paragraph(200, 100, 30, 260, "In U.S. News & World Report's 2016 rankings, Case Western Reserve's undergraduate program ranked 37th among national universities.[7] In 2016, the inaugural edition of The Wall Street Journal/Times Higher Education (WSJ/THE) ranked Case Western Reserve as 32nd among all universities and 29th among private institutions.");
        paragraph.annotate("Paragraph");
        String[] combo = {"Admissions", "Athletics", "Campus Life", "Research"};
        ComboBox comboBox = new ComboBox(200, 30, 30, 390, combo);
        comboBox.annotate("ComboBox");
        ProgressBar progressBar = new ProgressBar(200, 30, 30, 470, SwingConstants.HORIZONTAL);
        progressBar.annotate("ProgressBar");
        Headline headline = new Headline(200, 30, 270, 30, "EECS293 PA12");
        headline.annotate("Headline");
        String words = "Case Western Reserve University is a private doctorate-granting university in Cleveland, Ohio. The university was created in 1967 by the federation of Case Institute of Technology and Western Reserve University.";
        Text text = new Text(200, 220, 270, 90, words);
        text.annotate("CannedText");
        Slider slider = new Slider(200, 30, 270, 340, SwingConstants.HORIZONTAL);
        slider.annotate("Slider");
        String[] listData = {"List1", "List2", "List3"};
        wireframe.List list = new wireframe.List(150, 100, 270, 420, listData);
        ScrollBar scrollBar = new ScrollBar(40,100, 430, 420, SwingConstants.VERTICAL);
        scrollBar.annotate("ScrollBar");
        button.setSize(200, 15);
        button.setLocation(10, 10);
        wireframe.add(button);
        wireframe.addToWireframe(box);
        wireframe.addToWireframe(image);
        wireframe.addToWireframe(paragraph);
        wireframe.addToWireframe(comboBox);
        wireframe.addToWireframe(progressBar);
        wireframe.addToWireframe(headline);
        wireframe.addToWireframe(text);
        wireframe.addToWireframe(slider);
        wireframe.addToWireframe(list);
        wireframe.addToWireframe(scrollBar);
        paragraph.align(Alignment.JUSTIFIED);
        text.align(Alignment.CENTER);
        wireframe.displayGUI();
    }

    private void displayGUI() {
        JFrame jframe = new JFrame();
        this.addComponentsToGUI(this.components);
        jframe.add(this);
        jframe.setSize(this.getSize());
        jframe.setVisible(true);;
    }

    void displayAnnotations() {
        for(Groups group : this.components) {
            if(group.hasAnnotation()) {
                group.getAnnotation().setIsVisible(true);
                moveToFront(group.annotationComponent());
            }
        }
    }

    public void addToWireframe(Groups group) throws WireframeException {
        Wireframe.addGroupToListAtIndex(group, this.components, 0);
    }

    public void removeFromWireframe(Groups group) throws WireframeException {
        group.checkIsLocked();
        Wireframe.removeGroupFromList(group, this.components);
    }

    public void moveGroupToIndex(Groups group, int index) throws WireframeException {
        group.checkIsLocked();
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

    static void addGroupToListAtIndex(Groups group, List<Groups> list, int index) throws WireframeException {
        if(group.getAnnotation() != null)
            list.add(index, group.getAnnotation());
        list.add(index, group);
    }

    static void removeGroupFromList(Groups group, List<Groups> list) throws WireframeException {
        Wireframe.checkGroupExist(group, list);
        int elementIndex = list.indexOf(group);
        list.remove(elementIndex);
    }

    static boolean isAnElement(Groups group) {
        return Elements.class.isAssignableFrom(group.getClass());
    }

    private void addComponentsToGUI(List<Groups> list) {
        for(Groups component : list) {
            if(isAnElement(component)) {
                Elements element = (Elements)component;
                element.getComponent().setBounds(element.getLocation_x(), element.getLocation_y(), element.getWidth(), element.getLength());
                add(element.getComponent(), 0);
                //addAnnotationsToGUI(element);
            }
            else {
                //recursively retrieve all elements from the group
                Group group = (Group)component;
                addComponentsToGUI(group.getElements());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayAnnotations();
    }
}
