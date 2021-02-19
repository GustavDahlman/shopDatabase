package CompanyGUI;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.management.ListenerNotFoundException;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.xml.bind.Marshaller.Listener;

import CompanyGUI.showObject.jPanel;
import db_connect.PgTest;

public class customerSearch extends JPanel implements ActionListener, MouseListener{
	private JPanel lPanel = new JPanel();
	private JPanel rPanel = new JPanel();
	private String idString="Type product ID";
	private String prodstring="Type product name";
	private JTextField idprod = new JTextField(idString); //
	private JTextField prodname = new JTextField(prodstring);
	private JButton search = new JButton("Search");
	private JButton add = new JButton("ADD");
	private Object[][] res;
	private JPanel showinfo;
	private ViewCustomerFrame theParent;
	
	public customerSearch(ViewCustomerFrame parent) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 140));
		theParent=parent;
		showinfo = new JPanel(new GridLayout(1, 7));
		showinfo.setPreferredSize(new Dimension(600, 40));


		lPanel.setPreferredSize(new Dimension(400, 100));
		rPanel.setPreferredSize(new Dimension(200, 100));
		
		JLabel proID = new JLabel("prodID", JLabel.LEFT);
		JLabel productname = new JLabel("prodName", JLabel.LEFT);
		JLabel inStock = new JLabel("in stock", JLabel.LEFT);
		JLabel customerprice = new JLabel("customer price", JLabel.LEFT);
		JLabel manyfactorer = new JLabel("manufactorer", JLabel.LEFT);

		lPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		rPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		proID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		productname.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		inStock.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		customerprice.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		manyfactorer.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		proID.setFont(new Font("sanserif", Font.PLAIN, 15));
		productname.setFont(new Font("sanserif", Font.PLAIN, 15));
		inStock.setFont(new Font("sanserif", Font.PLAIN, 15));
		customerprice.setFont(new Font("sanserif", Font.PLAIN, 15));
		manyfactorer.setFont(new Font("sanserif", Font.PLAIN, 15));

		
		
		
		lPanel.setLayout(null);
		rPanel.setLayout(null);
		// search.setPreferredSize(new Dimension(110, 60));

		// pnr.setPreferredSize(new Dimension(110, 60));
		showinfo.add(proID);
		showinfo.add(productname);
		showinfo.add(inStock);
		showinfo.add(customerprice);
		showinfo.add(manyfactorer);
		showinfo.add(new JPanel());
		showinfo.add(new JPanel());

		
		lPanel.setBackground(Color.pink);
		rPanel.setBackground(Color.red);

		lPanel.add(idprod);
		lPanel.add(prodname);
		rPanel.add(search);
		//rPanel.add(add);

		idprod.setBounds(20, 20, 110, 60);
		prodname.setBounds(150, 20, 110, 60);
		
		search.setBounds(10, 20, 80, 60);
		add.setBounds(85,20, 80, 60);

		add(lPanel, BorderLayout.CENTER);
		add(rPanel, BorderLayout.EAST);
		add(showinfo, BorderLayout.SOUTH);
		
		
		idprod.addMouseListener(this);
		prodname.addMouseListener(this);
		
	
//		idprod.setEnabled(true);
//		prodname.setEnabled(true);
	}
	
	public void searchAll(){
		
		try {
			res=PgTest.productSearch(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		theParent.showResults(res, jPanel.panestock_c);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			String producutID = idprod.getText();
			String productName = prodname.getText();
			try {
				res=PgTest.productSearch(producutID, productName);
				printRes(res);
				theParent.showResults(res, jPanel.panestock_c);
				//showObject result=new showObject(jPanel.panelstock,res);
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//searchProduct(productID,productName)
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==idprod) {
			idprod.setText(null);
		} else {
			prodname.setText(null);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource()==idprod && idprod.getText().length()==0 ) {
			
				idprod.setText(idString);

		} else if (e.getSource()==prodname && prodname.getText().length()==0) {
			prodname.setText(prodstring);
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
	