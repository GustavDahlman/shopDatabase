package CompanyGUI;
import java.awt.*;
import javax.swing.*;

public class BoxLayoutPanel extends JPanel {
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");

    public BoxLayoutPanel() {
        setPreferredSize( new Dimension( 400, 300 ) );
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS)); 
//        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
                
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
    }
}
