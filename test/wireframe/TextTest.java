package wireframe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;
import static wireframe.Wireframe.Alignment.*;

public class TextTest {

    private Text text;

    @Before
    public void setUp() throws Exception {
        this.text = new Text(200, 300, 200, 200, "texty text text");
    }

    /*since the JLabel HTML text would be: "<html>" + "<body style='text-align: ALIGNMENT'>" + text + "</html>"
    we just need to check if the Alignment Expression is in the JLabel text
     */
    @Test
    public void test_align_nominal() throws Exception {
        this.text.align(JUSTIFIED);
        assertTrue(((JLabel)(this.text.getComponent())).getText().contains(JUSTIFIED.getExpression()));
        this.text.align(CENTER);
        assertTrue(((JLabel)(this.text.getComponent())).getText().contains(CENTER.getExpression()));
    }

}