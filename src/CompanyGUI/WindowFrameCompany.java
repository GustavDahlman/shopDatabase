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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

//import org.omg.CORBA.PUBLIC_MEMBER;

import CompanyGUI.showObject.jPanel;

public class WindowFrameCompany extends JPanel implements ActionListener {
	JPanel panel = new JPanel();
	JPanel resultPanel = new JPanel();
	
	// showObject view[];
	SearchFrameSupplier supplier = new SearchFrameSupplier(this);
	SearcFramePurchaesd purchaesd = new SearcFramePurchaesd(this);
	SearchFrameCustomer customer = new SearchFrameCustomer(this);
	SearchFrameStock stock = new SearchFrameStock(this);
	ButtonFrame button;
	startWindow theParent;
	
	public enum state{
		product,customer,supplier,purchased,welcome
	};

	public WindowFrameCompany(state theState, startWindow parent) {
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

		
		//panel.add(stock, BorderLayout.NORTH);
		//panel.remove(view);
		
		if(theState==state.product){
			panel.add(stock, BorderLayout.NORTH);
		}
		else if(theState==state.customer){
			panel.add(customer,BorderLayout.NORTH);
		}
		else if(theState==state.supplier){
			panel.add(supplier,BorderLayout.NORTH);
		}
		else if(theState==state.purchased){
			panel.add(purchaesd,BorderLayout.NORTH);
		}
		else if(theState==state.welcome){
			panel.add(welcome,BorderLayout.NORTH);
		}
		
			
		
		add(panel, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);

		add(scrollPane);
		add(button, BorderLayout.WEST);
		panel.add(resultPanel, BorderLayout.CENTER);

	}
	public startWindow getWindow(){
		return theParent;
	}
	public void setPanel(state theState){
		
		//panel.remove(0);
		panel.removeAll();
		panel.add(resultPanel, BorderLayout.CENTER);
		if(theState==state.product){
			refreshResults();
			panel.add(stock, BorderLayout.NORTH);
			panel.validate();
			panel.repaint();
			stock.searchAll();
			System.out.println("check");
		}
		else if(theState==state.customer){
			refreshResults();
			panel.add(customer,BorderLayout.NORTH);
			panel.validate();
			panel.repaint();
			customer.searchAll();
			System.out.println("check");
		}
		else if(theState==state.supplier){
			refreshResults();
			panel.add(supplier,BorderLayout.NORTH);
			panel.validate();
			panel.repaint();
			supplier.searchAll();
			System.out.println("check");
		}
		else if(theState==state.purchased){
			refreshResults();
			panel.add(purchaesd,BorderLayout.NORTH);
			panel.validate();
			panel.repaint();
			purchaesd.searchAll();
			System.out.println("check");
		}
		else if(theState==state.welcome){
			refreshResults();
			panel.add(stock,BorderLayout.CENTER);
			panel.validate();
			panel.repaint();
			
		}
	}
	
	public void showResults(Object[][] results, jPanel state){
		
		for(int i = 0; i<results.length; i++){
			showObject res=new showObject(state,results[i]);
			//panel.add(res, BorderLayout.CENTER);
			resultPanel.add(res);
			resultPanel.validate();
			resultPanel.repaint();
			//panel.validate();
			//panel.repaint();
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

}
