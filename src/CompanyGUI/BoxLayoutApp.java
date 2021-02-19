package CompanyGUI;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BoxLayoutApp {
    public void start() {
        JFrame frame = new JFrame( "BoxLayoutApp" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new BoxLayoutPanel() );
        frame.pack();
        frame.setVisible( true );
    }
    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); // eller
        	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        	
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }catch(Exception e) {}
        BoxLayoutApp app = new BoxLayoutApp();
        app.start();
    }
}
