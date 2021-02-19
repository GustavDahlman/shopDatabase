package CompanyGUI;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import CompanyGUI.showObject.jPanel;
import db_connect.*;

public class SearchFrameCustomer extends JPanel implements ActionListener, MouseListener {
	private JPanel lPanel = new JPanel();
	private JPanel rPanel = new JPanel();
	private JPanel bottom= new JPanel();
	private String pNrS= "type personnumber";
	private Object[][] res; 

	private JTextField pnr = new JTextField(pNrS); //
	private JButton search = new JButton("Search");
	private JButton add= new JButton("ADD");
	private JPanel showinfo;
	private WindowFrameCompany theParent;
	// private JTextField prodname= new JTextField("type product name");
	// private JTextField prodid= new JTextField("type product id");

	// private JTextField supplier= new JTextField("type supplier ");
	// private JTextField puchase= new JTextField("type receipt number");

	public SearchFrameCustomer(WindowFrameCompany parent) {
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 140));
		theParent=parent;
		showinfo= new JPanel(new GridLayout(1, 5));
		showinfo.setPreferredSize(new Dimension(600, 40));

		
		lPanel.setPreferredSize(new Dimension(400, 100));
		rPanel.setPreferredSize(new Dimension(200, 100));
		JLabel customerID=new JLabel("customerID",JLabel.LEFT);
		JLabel name=new JLabel("name",JLabel.LEFT);
		JLabel address=new JLabel("address",JLabel.LEFT);
		JLabel email=new JLabel("email",JLabel.LEFT);
		
		lPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		rPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		bottom.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		customerID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		name.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		address.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		
		customerID.setFont(new Font("sanserif", Font.PLAIN, 15));
		name.setFont(new Font("sanserif", Font.PLAIN, 15));
		address.setFont(new Font("sanserif", Font.PLAIN, 15));
		email.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		customerID.setFont(new Font("sanserif", Font.PLAIN, 15));
		name.setFont(new Font("sanserif", Font.PLAIN, 15));
		address.setFont(new Font("sanserif", Font.PLAIN, 15));
		email.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		lPanel.setLayout(null);
		rPanel.setLayout(null);
		// search.setPreferredSize(new Dimension(110, 60));

		// pnr.setPreferredSize(new Dimension(110, 60));

		showinfo.add(customerID);
		showinfo.add(name);
		showinfo.add(address);
		showinfo.add(email);
		showinfo.add(new JPanel());
			
		
		lPanel.setBackground(Color.pink);
		rPanel.setBackground(Color.red);

		lPanel.add(pnr);
		rPanel.add(search);
		rPanel.add(add);

		pnr.setBounds(20, 20, 110, 60);
		search.setBounds(10, 20, 80, 60);
		add.setBounds(85,20, 80, 60);
		search.addActionListener(this);
		add.addActionListener(this);

		add(lPanel, BorderLayout.CENTER);
		add(rPanel, BorderLayout.EAST);
		add(showinfo, BorderLayout.SOUTH);
		pnr.setEnabled(true);
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search){
			//System.out.println("hj");
			try {
				
				//if(pnr.getText()==null){System.out.println("null");}
				res=PgTest.customerSearch(pnr.getText());
				theParent.refreshResults();
				printRes(res);
				theParent.showResults(res,jPanel.panelcustomer );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == add) {
			 
			String arr[] = { "customerID", "name", "address", "email" };
			String ans;
			for (int i = 0; i < 4; i++) {
				ans = JOptionPane.showInputDialog(arr[i]);
				arr[i] = ans;
			}
			try {
				PgTest.addCustomer(arr[0], arr[1], arr[2], arr[3]);
				theParent.refreshResults();
				res = PgTest.customerSearch(arr[0]);// fixa så alla syns
				printRes(res);
				theParent.showResults(res, jPanel.panelpurchased);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	
	public void searchAll(){
		
		try {
			res=PgTest.customerSearch(null);
			System.out.println("check2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("check3");
		theParent.showResults(res, jPanel.panelcustomer);
	}
	
	public void printRes(Object[][] res){
		
		for(int i=0; i<res.length;i++){
			//System.out.println(test[i][0]);
			System.out.println("\n");
			for(int k=0;k<res[0].length;k++){
				System.out.print(res[i][k]+"  ");
			}
		}
	}

	@Override
	
	public void mouseClicked(MouseEvent e) {
		//if(e.getSource()==){
			
		}
		
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
