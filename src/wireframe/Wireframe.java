package wireframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Wireframe
 *
 * Represents the Wireframe itself
 * @author TungHo Lin
 * @see JLayeredPane
 * @see ActionListener
 */
public class Wireframe extends JLayeredPane implements ActionListener {

    /**
     * The enum of Alignment
     */
    public enum Alignment {
        LEFT("<body style='text-align: left'>"),
        RIGHT("<body style='text-align: right'>"),
        CENTER("<body style='text-align: center'>"),
        JUSTIFIED("<body style='text-align: justify'>");

        /**
         * The String expression of the alignment in HTML
         */
        private String expression;

        /**
         * The constructor for enum Alignment
         * @param expression The String expression of the alignment in HTML
         */
        Alignment(String expression) {
            this.expression = expression;
        }

        /**
         * Return the HTML expression of the alignment
         * @return the HTML expression of the alignment
         */
        String getExpression() {
            return expression;
        }
    }

    /**
     * The List of Groups in the Wireframe
     */
    private List<Groups> componentsList;

    /**
     * Constructor of Class Wireframe
     * @param width The width of the Wireframe
     * @param length The length of the Wireframe
     */
    public Wireframe(int width, int length) {
        this.setSize(width, length);
        this.componentsList = new ArrayList<>();
    }

    /**
     * The main method that will produce and display the Wireframe
     * @param args The arguments to be passed in
     * @throws WireframeException
     */
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

    /**
     * Display all the components in this wireframe in a JFrame window
     */
    void displayGUI() {
        JFrame jframe = new JFrame();
        this.addComponentsToGUI(this.componentsList);
        jframe.add(this);
        jframe.setSize(this.getSize());
        jframe.setVisible(true);;
    }

    /**
     * Display the annotations of all groups
     */
    void displayAnnotations() {
        for(Groups group : this.componentsList) {
            if(group.hasAnnotation()) {
                group.getAnnotation().setIsVisible(true);
                moveToFront(group.annotationComponent());
            }
        }
    }

    /**
     * Add a groups to the wireframe
     * @param group The groups to be added
     * @throws WireframeException if there is an error, which will be indicated by the error message
     */
    public void addToWireframe(Groups group) throws WireframeException {
        Wireframe.addGroupToListAtIndex(group, this.componentsList, 0);
    }

    /**
     * Remove a groups from the wireframe
     * @param group The group to be removed
     * @throws WireframeException if the wireframe is empty
     */
    public void removeFromWireframe(Groups group) throws WireframeException {
        checkEmptyList();
        Wireframe.removeGroupFromList(group, this.componentsList);
    }

    /**
     * Move a groups to an specific index in the List of groups
     * @param group The groups to be moved
     * @param index The new index of the groups
     * @throws WireframeException if the groups is locked
     * @throws WireframeException if the index is not valid
     */
    public void moveGroupToIndex(Groups group, int index) throws WireframeException {
        group.checkIsLocked();
        checkValidIndex(index);
        Wireframe.removeGroupFromList(group, this.componentsList);
        Wireframe.addGroupToListAtIndex(group, this.componentsList, index);
    }

    /**
     * Check if the wireframe is empty
     * @throws WireframeException if the wireframe is empty
     */
    private void checkEmptyList() throws WireframeException {
        if(this.componentsList.size() == 0)
            throw new WireframeException("There is nothing to be removed");
    }

    /**
     * Check if the groups exists in the wireframe to be searched
     * @param group The groups to be checked
     * @param components The List of groups to be searched
     * @throws WireframeException if the groups does not exist int the wireframe
     */
    private static void checkGroupExist(Groups group, List<Groups> components) throws WireframeException {
        if(!components.contains(group))
            throw new WireframeException("No such group/element");
    }

    /**
     * Check if the index is valid
     * @param index The index to be checked
     * @throws WireframeException if the index is not valid
     */
    private void checkValidIndex(int index) throws WireframeException {
        if(index >= componentsList.size() || index < 0)
            throw new WireframeException("Index not in range");
    }

    /**
     * Return the List of groups in the wireframe
     * @return the List of groups in the wireframe
     */
    List<Groups> getComponentsList() {
        return this.componentsList;
    }

    /**
     * Add a group to a List of groups at the given index
     * @param group The groups to be added
     * @param list The List of groups to add to
     * @param index The index to be added at
     */
    static void addGroupToListAtIndex(Groups group, List<Groups> list, int index) {
        if(group.getAnnotation() != null)
            list.add(index, group.getAnnotation());
        list.add(index, group);
    }

    /**
     * Remove a group from a List of groups
     * @param group The groups to be removed
     * @param list The List of groups to be removed from
     * @throws WireframeException if the groups is locked
     * @throws WireframeException if the groups to be removed does not exist in the List of groups to be removed from
     */
    static void removeGroupFromList(Groups group, List<Groups> list) throws WireframeException {
        group.checkIsLocked();
        Wireframe.checkGroupExist(group, list);
        int elementIndex = list.indexOf(group);
        list.remove(elementIndex);
    }

    /**
     * Return if the groups is an element
     * @param group The groups to be checked
     * @return if the groups is an element
     */
    static boolean isAnElement(Groups group) {
        return Elements.class.isAssignableFrom(group.getClass());
    }

    /**
     * Add the List of groups to the wireframe
     * @param list The List of groups to be added to the wireframe
     */
    private void addComponentsToGUI(List<Groups> list) {
        for(Groups component : list) {
            if(isAnElement(component)) {
                Elements element = (Elements)component;
                element.getComponent().setBounds(element.getLocation_x(), element.getLocation_y(), element.getWidth(), element.getLength());
                add(element.getComponent(), 0);
            }
            else {
                /* recursively retrieve all elements from the group */
                Group group = (Group)component;
                addComponentsToGUI(group.getElements());
            }
        }
    }

    /**
     * Display the Annotations if the button is clicked
     * @param e The Action to be detected
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        displayAnnotations();
    }
}
