package CompanyGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

//import org.omg.CORBA.PUBLIC_MEMBER;

import CompanyGUI.showObject.jPanel;

public class ViewCustomerFrame extends JPanel implements ActionListener {
	JPanel panel = new JPanel();
	JPanel resultPanel = new JPanel();
	private String customer;
	
	customerSearch stock = new customerSearch(this);
	ButtonFrame button;
	startWindow theParent;
	
	public enum state{
		product,customer,supplier,purchased,welcome
	};

	public ViewCustomerFrame(startWindow parent) {
		customer=JOptionPane.showInputDialog("enter person number");
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(800, 500));
		setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		JLabel welcome= new JLabel("welcome!");
		button=new ButtonFrame(this);
		theParent= parent;

		panel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.red, Color.gray));
		button.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.red, Color.gray));

		stock.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.red, Color.gray));

		
		
		
			panel.add(stock, BorderLayout.NORTH);
		
		
			
		
		add(panel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);

		add(scrollPane);
		
		panel.add(resultPanel, BorderLayout.CENTER);
		stock.searchAll();

	}
	public startWindow getWindow(){
		return theParent;
	}
	
	public void setPanel(){
		
		panel.add(resultPanel, BorderLayout.CENTER);

	}
	
	
	public void showResults(Object[][] results, jPanel state){
		
		for(int i = 0; i<results.length; i++){
			showObject res=new showObject(state,results[i]);
			//panel.add(res, BorderLayout.CENTER);
			resultPanel.add(res);
			resultPanel.validate();
			resultPanel.repaint();
			
		}

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	public void refreshResults(){
		resultPanel.removeAll();
		resultPanel.validate();
		resultPanel.repaint();
	}
	public String getCustomer(){
		return customer;
	}

}
