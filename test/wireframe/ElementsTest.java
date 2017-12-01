package wireframe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ElementsTest {

    private Elements element;

    @Before
    public void setUp() throws Exception {
        this.element = new Box(10, 10, 20, 20);
    }

    @Test
    public void test_resize_nominal() throws WireframeException {
        this.element.resize(50, 90);
        assertEquals(this.element.getWidth(), 50);
        assertEquals(this.element.getLength(), 90);
    }

    @Test
    public void test_resize_locked() throws WireframeException {
        this.element.setLock(true);
        try {
            this.element.resize(50, 50);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_resize_invalidParameter() throws WireframeException {
        try {
            this.element.resize(-50, -20);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Input out of range"));
        }
    }

    @Test
    public void test_annotate_nominal() throws WireframeException {
        this.element.annotate("annotations");
        assertTrue(this.element.getAnnotation().getText().equals("annotations"));
    }

    @Test
    public void test_annotate_locked() {
        this.element.setLock(true);
        try {
            this.element.annotate("annotations");
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_annotate_emptyInput() {
        try {
            this.element.annotate("");
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Annotation can not be empty"));
        }
        try {
            this.element.annotate(null);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Annotation can not be empty"));
        }
    }

    @Test
    public void test_move_nominal() throws WireframeException {
        this.element.move(55, 45);
        assertEquals(this.element.getLocation_x(), 55);
        assertEquals(this.element.getLocation_y(), 45);
    }

    @Test
    public void test_move_locked() {
        this.element.setLock(true);
        try {
            this.element.move(55, 45);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Element is locked! No action can be done"));
        }
    }

    @Test
    public void test_move_invalidInput() throws WireframeException {
        try {
            this.element.move(-55, -45);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Input out of range"));
        }
    }

}