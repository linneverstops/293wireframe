package wireframe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WireframeTest {

    private Wireframe wireframe;

    private Box box;

    private Slider slider;

    @Before
    public void setUp() throws Exception {
        this.wireframe = new Wireframe(500, 500);
        this.slider = new Slider(40, 40, 40, 40, SwingConstants.VERTICAL);
        this.box = new Box(20, 20, 20, 20);
        this.wireframe.addToWireframe(slider);
        this.wireframe.addToWireframe(box);
    }

    @Test
    public void test_addToWireframe_nominal() throws WireframeException {
        assertEquals(this.wireframe.getComponentsList().get(0), box);
        assertEquals(this.wireframe.getComponentsList().get(1), slider);
    }

    @Test
    public void test_removeFromWireframe_nominal() throws WireframeException {
        this.wireframe.removeFromWireframe(slider);
        assertEquals(this.wireframe.getComponentsList().size(), 1);
        assertEquals(this.wireframe.getComponentsList().get(0).getClass(), Box.class);
    }

    @Test
    public void test_removeFromWireframe_emptyFrame() throws WireframeException {
        Wireframe emptyFrame = new Wireframe(30, 30);
        try {
            emptyFrame.removeFromWireframe(box);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: There is nothing to be removed"));
        }
    }

    @Test
    public void test_removeFromWireframe_noSuchGroup() throws WireframeException {
        Text text = new Text(30, 30, 30, 30, "text");
        try {
            this.wireframe.removeFromWireframe(text);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: No such group/element"));
        }
    }

    @Test
    public void test_moveGroupToIndex_nominal() throws WireframeException {
        ProgressBar pbar = new ProgressBar(30, 30, 30, 30, SwingConstants.VERTICAL);
        this.wireframe.addToWireframe(pbar);
        int lastIndex = this.wireframe.getComponentsList().size() - 1;
        this.wireframe.moveGroupToIndex(pbar, lastIndex);
        assertEquals(this.wireframe.getComponentsList().get(lastIndex).getClass(), ProgressBar.class);
    }

    @Test
    public void test_moveGroupToIndex_invalidInput() {
        ProgressBar pbar = new ProgressBar(30, 30, 30, 30, SwingConstants.VERTICAL);
        try {
            this.wireframe.addToWireframe(pbar);
            this.wireframe.moveGroupToIndex(pbar, -6);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Index not in range"));
        }
        try {
            this.wireframe.addToWireframe(pbar);
            this.wireframe.moveGroupToIndex(pbar, 50);
        }
        catch (WireframeException we) {
            assertThat(we.toString(), is("WireframeException: Index not in range"));
        }
    }

}