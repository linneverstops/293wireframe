import javax.swing.*;

public class List extends TextualElements {

    public List(String listData) {
        super(listData);
        this.component = new JList<>(listData.split(" "));
    }
}
