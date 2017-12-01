package wireframe;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnnotationsTest {

    private Annotations annotation;

    @Before
    public void setUp() throws Exception {
        this.annotation = new Annotations(10, 10, "Annotation");
    }

    @Test
    public void test_isVisible_nominal() {
        assertFalse(this.annotation.isVisible());
    }

    @Test
    public void test_setIsVisible_true() {
        this.annotation.setIsVisible(true);
        assertTrue(this.annotation.isVisible());
    }

    @Test
    public void test_setIsVisible_false() {
        this.annotation.setIsVisible(true);
        this.annotation.setIsVisible(false);
        assertFalse(this.annotation.isVisible());
    }

}