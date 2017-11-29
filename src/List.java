import javax.swing.*;

public class List extends TextualElements {

    public List(String listData) {
        super(listData);
        JList<String> list = new JList(listData.split(" "));
        this.component = list;
    }
}
