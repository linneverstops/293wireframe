package wireframe;

import javax.swing.*;
import java.awt.*;

class Text extends Elements {

    private final String text;

    Text(int width, int length, int location_x, int location_y, String text) {
        //using html can allow multi-line read-only text in a JLabel
        super(width, length, location_x, location_y, new JLabel("<html>" + text + "</html>"));
        this.getComponent().setBorder(BorderFactory.createLineBorder(Color.black));
        this.text = text;
        ((JLabel) this.getComponent()).setVerticalAlignment(SwingConstants.TOP);
}

    public void align(Wireframe.Alignment alignment) throws WireframeException {
        checkIsLocked();
        JLabel textBox = ((JLabel)this.getComponent());
        int indexToInsert = textBox.getText().indexOf("<html>") + "<html>".length();
        StringBuilder builder = new StringBuilder(textBox.getText());
        //insert the html align String, html can allow Justified Alignment
        builder.insert(indexToInsert, alignment.getExpression());
        textBox.setText(builder.toString());
    }

}
