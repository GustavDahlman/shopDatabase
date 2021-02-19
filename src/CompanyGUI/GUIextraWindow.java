package CompanyGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIextraWindow extends JPanel {
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();

	private JLabel purchaseID = new JLabel("purchaseID");
	private JLabel prodID = new JLabel("prodID");
	private JLabel suppID = new JLabel("suppID");
	private JLabel paidprice = new JLabel("price");
	private JLabel quantity =new JLabel("quantity");
	private JTextField arr[][];
	

	private JLabel price = new JLabel("suppID");
	

	public GUIextraWindow( Object array[][]) {
		setPreferredSize(new Dimension(400, 600));
		setLayout(new BorderLayout());
		north.setPreferredSize(new Dimension(300, 50));
		south.setPreferredSize(new Dimension(300, 400));
		
		 prodID.setPreferredSize(new Dimension(100, 40));
		 quantity.setPreferredSize(new Dimension(100, 40));
		 paidprice.setPreferredSize(new Dimension(100, 40));
		 
		
		
		
		
			arr = fixfields(array);

			 north.add(prodID);
			 
			 north.add(paidprice);
			 north.add(quantity);
		
		add(north,BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
	}
	public GUIextraWindow(Object arr[]){
		JTextField [] array= new JTextField[arr.length];
		setPreferredSize(new Dimension(400, 600));
		setLayout(new BorderLayout());
		north.setPreferredSize(new Dimension(300, 50));
		south.setPreferredSize(new Dimension(300, 400));
		
		 price.setPreferredSize(new Dimension(100, 40));
		 suppID.setPreferredSize(new Dimension(100, 40));
		 prodID.setPreferredSize(new Dimension(100, 40));
		 
		 north.add(prodID);
		 north.add(suppID);
		 north.add(price);
		 for (int i = 0; i < arr.length; i++) {
			array[i]=new JTextField(arr[i].toString());
			array[i].setPreferredSize(new Dimension(100, 40));
			south.add(array[i]);
			
		}
		 
		add(north,BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
	}

	private JTextField[][] fixfields(Object array[][]) {
		arr = new JTextField[array.length][array[0].length-1];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array[0].length; j++) {
				
				arr[i][j-1] = new JTextField(array[i][j].toString());
				arr[i][j-1].setPreferredSize(new Dimension(100, 40));
				
				south.add(arr[i][j-1]);
				
			}

		}
		return arr;
	}

	public static void main(String arg[]) {
		Object[]	arr= {"1","2","3"};
		Object[][] objarr = { { "1", "2", "3","4" }, { "1", "2", "3" ,"4" }, { "1", "2", "3" ,"4" }, { "1", "2", "3","4"  },
				
				{ "1", "2", "3" ,"4" } };
		
		GUIextraWindow app = new GUIextraWindow( objarr);
		JOptionPane.showMessageDialog(null, app);
//		JFrame frame = new JFrame("test");
//		
//		frame.add(app);
//		frame.pack();
//		frame.setVisible(true);
	}
}
