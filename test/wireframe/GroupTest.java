package wireframe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GroupTest {

    private Group group;

    @Before
    public void setUp() throws Exception {
        Box box = new Box(20, 20, 30, 50);
        box.annotate("box");
        ScrollBar scrollBar = new ScrollBar(100, 20, 40, 60, SwingConstants.HORIZONTAL);
        scrollBar.annotate("scrollbar");
        this.group = new Group();
        group.addToGroup(box);
        group.addToGroup(scrollBar);
    }

    @Test
    public void test_move_nominal() throws Exception {
        Elements element1 = (Elements)this.group.getElements().get(0);
        Elements element2 = (Elements)this.group.getElements().get(1);
        int element1_originalXPosition = element1.getLocation_x();
        int element1_originalYPosition = element1.getLocation_y();
        int element2_originalXPosition = element2.getLocation_x();
        int element2_originalYPosition = element2.getLocation_y();
        this.group.move(50, 20);
        assertEquals(element1.getLocation_x() - element1_originalXPosition, 50);
        assertEquals(element1.getLocation_y() - element1_originalYPosition, 20);
        assertEquals(element2.getLocation_x() - element2_originalXPosition, 50);
        assertEquals(element2.getLocation_y() - element2_originalYPosition, 20);
    }

    @Test
    public void test_move_locked() {
        this.group.setLock(true);
        try {
            this.group.move(100, 100);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_annotate_nominal() throws WireframeException {
        this.group.annotate("Annotation");
        assertEquals(this.group.getElements().get(0).getAnnotation().getText(), "Annotation");
    }

    @Test
    public void test_annotate_locked() {
        this.group.setLock(true);
        try {
            this.group.annotate("Annotation");
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_addToGroup_nominal() throws WireframeException {
        Slider slider = new Slider(10, 20, 30, 40, SwingConstants.VERTICAL);
        this.group.addToGroup(slider);
        assertEquals(this.group.getElements().get(0), slider);
    }

    @Test
    public void test_addToGroup_locked() {
        Slider slider = new Slider(10, 20, 30, 40, SwingConstants.VERTICAL);
        this.group.setLock(true);
        try {
            this.group.addToGroup(slider);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_removeFromGroup_nominal() throws WireframeException {
        Text text = new Text(10, 20, 30, 40, "text");
        this.group.addToGroup(text);
        this.group.removeFromGroup(text);
        assertEquals(this.group.getElements().size(), 4); //there are 4 remaining: a box, a scrollbar and 2 annotations
        assertEquals(this.group.getElements().get(0).getAnnotation().getText(), "scrollbar");
        assertEquals(this.group.getElements().get(2).getAnnotation().getText(), "box");
    }

}