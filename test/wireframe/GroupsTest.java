package wireframe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class GroupsTest {

    private Groups group;

    @Before
    public void setUp() throws Exception {
        this.group = new Box(10, 10, 20, 30);
    }

    @Test(expected = WireframeException.class)
    public void test_setLock_nominal() throws WireframeException {
        this.group.setLock(true);
        this.group.checkIsLocked();
    }

    @Test
    public void test_hasAnnotation_nominal() throws WireframeException {
        this.group.annotate("annotation");
        assertTrue(this.group.hasAnnotation());
    }

    @Test
    public void test_setAnnotation_nominal() {
        Annotations annotation = new Annotations(30, 30, "annotation");
        this.group.setAnnotation(annotation);
        assertEquals(this.group.getAnnotation().getText(), "annotation");
    }

    @Test
    public void test_annotationComponent_nominal() throws Exception {
        this.group.annotate("annotation");
        assertEquals(this.group.annotationComponent().getClass(), JLabel.class);
    }

}