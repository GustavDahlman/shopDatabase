package CompanyGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 

import CompanyGUI.WindowFrameCompany.state;



public class ButtonFrame extends JPanel implements ActionListener{
	private JButton Customer= new JButton("customer");
	private JButton lager	= new JButton("Stock");
	private JButton supplier= new JButton("supplier");
	private JButton purchased= new JButton("Purchased");
	private WindowFrameCompany parentWindow;
	
	private Font font = new Font("SansSerif", Font.BOLD, 14);
//	private JPanel btnP		=new JPanel();
//	private JPanel srhp 	= new JPanel();
//	private JPanel showp	= new JPanel();
	
	public ButtonFrame(WindowFrameCompany parent){
		
		parentWindow=parent;
		setPreferredSize(new Dimension(200, 500));
		
		setBackground(Color.gray);
		
		Customer.setPreferredSize(new Dimension(180, 50));
		Customer.setBorder(BorderFactory.createLineBorder(Color.black));
		Customer.setFont(font);
		Customer.addActionListener(this);
		
		lager.setPreferredSize(new Dimension(180, 50));
		lager.setBorder(BorderFactory.createLineBorder(Color.black));
		lager.setFont(font);
		lager.addActionListener(this);
		
		supplier.setPreferredSize(new Dimension(180, 50));
		supplier.setBorder(BorderFactory.createLineBorder(Color.black));
		supplier.setFont(font);
		supplier.addActionListener(this);
		
		
		purchased.setPreferredSize(new Dimension(180, 50));
		purchased.setBorder(BorderFactory.createLineBorder(Color.black));
		purchased.setFont(font);
		purchased.addActionListener(this);
		
		
		
		add(Customer);
		add(lager);
		add(supplier);
		add(purchased);
		setMaximumSize(new Dimension(200, 500));
			}
	
	public ButtonFrame(ViewCustomerFrame parent){
		
		//parentWindow=parent;
		setPreferredSize(new Dimension(200, 500));
		
		setBackground(Color.gray);
		
		Customer.setPreferredSize(new Dimension(180, 50));
		Customer.setBorder(BorderFactory.createLineBorder(Color.black));
		Customer.setFont(font);
		Customer.addActionListener(this);
		
		lager.setPreferredSize(new Dimension(180, 50));
		lager.setBorder(BorderFactory.createLineBorder(Color.black));
		lager.setFont(font);
		lager.addActionListener(this);
		
		supplier.setPreferredSize(new Dimension(180, 50));
		supplier.setBorder(BorderFactory.createLineBorder(Color.black));
		supplier.setFont(font);
		supplier.addActionListener(this);
		
		
		purchased.setPreferredSize(new Dimension(180, 50));
		purchased.setBorder(BorderFactory.createLineBorder(Color.black));
		purchased.setFont(font);
		purchased.addActionListener(this);
		
		
		
		//add(Customer);
		//add(lager);
		//add(supplier);
		//add(purchased);
		setMaximumSize(new Dimension(200, 500));
			}
	
	//public static void main(String[] args) {
		 //new ButtonFrame();
	//	JOptionPane.showMessageDialog(new ButtonFrame(), null);
		
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==supplier){
			//parentWindow.setWindow(state.supplier);
			//((startWindow) getParent()).setWindow(state.supplier);
			//System.out.println("check");
			parentWindow.setPanel(state.supplier);
		}
		if(e.getSource()==Customer){
			parentWindow.setPanel(state.customer);
		}
		if(e.getSource()==purchased){
			parentWindow.setPanel(state.purchased);
		}
		if(e.getSource()==lager){
			parentWindow.setPanel(state.product);
		}
		
		
	}

}
