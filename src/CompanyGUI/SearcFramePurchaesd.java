package CompanyGUI;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import CompanyGUI.showObject.jPanel;

import javax.swing.*;

import db_connect.*;

public class SearcFramePurchaesd extends JPanel implements ActionListener, MouseListener {
	private JPanel lPanel = new JPanel();
	private JPanel rPanel = new JPanel();
	private JPanel bottom= new JPanel();
	
	private JPanel showinfo;	private String purString = "Type receipt";
	
	
	private String perString = "Type personnumber";
	private Object[][] res;

	private JTextField purchasedID = new JTextField(purString); //
	private JTextField pernr = new JTextField(perString);
	private JButton search = new JButton("Search");
	private JButton add= new JButton("ADD");
	private WindowFrameCompany theParent;

	public SearcFramePurchaesd(WindowFrameCompany parent) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 140));
		theParent=parent;

		showinfo= new JPanel(new GridLayout(1, 5));
		showinfo.setPreferredSize(new Dimension(600, 40));
		
		lPanel.setPreferredSize(new Dimension(400, 100));
		rPanel.setPreferredSize(new Dimension(200, 100));
		
		JLabel proID=new JLabel("purchaseID",JLabel.LEFT);
		JLabel personnr=new JLabel("pnr",JLabel.LEFT);
		JLabel totalprice=new JLabel("total Price",JLabel.LEFT);
		JLabel date=new JLabel("date",JLabel.LEFT);
		
		lPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		rPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		proID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		personnr.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		totalprice.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		date.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		
		proID.setFont(new Font("sanserif", Font.PLAIN, 15));
		personnr.setFont(new Font("sanserif", Font.PLAIN, 15));
		totalprice.setFont(new Font("sanserif", Font.PLAIN, 15));
		date.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		
		lPanel.setLayout(null);
		rPanel.setLayout(null);
		// search.setPreferredSize(new Dimension(110, 60));

		// pnr.setPreferredSize(new Dimension(110, 60));

		lPanel.setBackground(Color.pink);
		rPanel.setBackground(Color.red);

		showinfo.add(proID);
		showinfo.add(personnr);
		showinfo.add(totalprice);
		showinfo.add(date);
		showinfo.add(new JPanel());

		
		lPanel.add(purchasedID);
		lPanel.add(pernr);
		rPanel.add(search);
		rPanel.add(add);

		purchasedID.setBounds(20, 20, 110, 60);
		pernr.setBounds(150, 20, 120, 60);

		search.setBounds(10, 20, 80, 60);
		add.setBounds(85,20, 80, 60);
		add(lPanel, BorderLayout.CENTER);
		add(rPanel, BorderLayout.EAST);
		add(showinfo, BorderLayout.SOUTH);
		
		search.addActionListener(this);
		add.addActionListener(this);
		
		pernr.addMouseListener(this);
		purchasedID.addMouseListener(this);
	
		// purchasedID.setEnabled(true);
		// pernr.setEnabled(true);
	}
	
	public void searchAll(){
		try {
			res=PgTest.purchaseSearch(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		theParent.showResults(res, jPanel.panelpurchased);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == search) {
			 try {
				 System.out.println("bajz");
				res=PgTest.purchaseSearch(purchasedID.getText(), pernr.getText());
				theParent.refreshResults();
				printRes(res);
				theParent.showResults(res, jPanel.panelpurchased);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		 else if (e.getSource() == add) {
				String arr[] = { "pernr", "totalprice" };
				String ans;
				String pernr;
				int total;
				//int prodID;
				String prodID;
				pernr=JOptionPane.showInputDialog("CustomerID:");
				//prodID=Integer.parseInt(JOptionPane.showInputDialog("productID:"));
				prodID=JOptionPane.showInputDialog("productID:");
				total=Integer.parseInt(JOptionPane.showInputDialog("Paid price:"));
				
				/**
				for (int i = 0; i < 2; i++) {
					ans = JOptionPane.showInputDialog(arr[i]);
					arr[i] = ans;
				
				}*/
				try {
					//PgTest.addPurchase(arr[0],Integer.parseInt(arr[1]));
					int id=PgTest.addPurchase(pernr, total);
					PgTest.addPurchaseItem(id, prodID, total, 1);
					theParent.refreshResults();
					res=PgTest.purchaseSearch(null, null);
					printRes(res);
					theParent.showResults(res, jPanel.panelpurchased);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==purchasedID) {
			purchasedID.setText(null);
		}else{
			pernr.setText(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == purchasedID && purchasedID.getText().length() == 0) {

			//purchasedID.setText(purString);

		} else if (e.getSource() == pernr && pernr.getText().length() == 0) {
			//pernr.setText(perString);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public Object[][] getResults(){
		return res;
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
}
