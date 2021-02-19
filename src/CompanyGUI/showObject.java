package CompanyGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db_connect.PgTest;
import db_connect.shoppingCart;

public class showObject extends JPanel implements ActionListener {

	public enum jPanel {
		panelstock, panelsupplier, panelcustomer, panelpurchased, panestock_c
	};

	private JTextField c_fill_customerID;
	private JTextField fill_productID;
	private JTextField fill_supplier;
	private JTextField fill_purchaseID;
	private JTextField fill_customerPrice;
	

	private JPanel showinfo;
	private JPanel showObject;
	private JButton btnedit;
	private JButton btnDeleteCustomer;
	private JButton btnDeleteProduct;
	private JButton btnProductInfo;
	private JButton btnDeletePurchase;
	private JButton btnPurchaseInfo;
	private JButton btnDeleteSupplier;
	private JPanel btnPanel;
	private JButton buy = new JButton("buy");
	private jPanel parent;
	private shoppingCart cart;
	private String customer;
	private JButton btnAddSupplierProduct;

	public showObject(jPanel panel, Object[] results) {
		customer = "9308287250";
		parent=panel;

		switch (panel) {
		case panelstock:

			showhStock(results);
			break;
		case panelsupplier:
			showSupplier(results);
			break;

		case panelcustomer:
			showcustomer(results);
			break;

		case panelpurchased:
			showPurchased(results);
			break;
		case panestock_c:
			showStock_c(results);
			break;

		default:
			break;
		}
	}

	private void setCustomer(String customerID) {
		customer = customerID;
	}

	private void showSupplier(Object[] results) {
		setPreferredSize(new Dimension(600, 500));
		showObject = new JPanel(new GridLayout(1, 5));
		btnDeleteSupplier = new JButton("DELETE");
		btnDeleteSupplier.setPreferredSize(new Dimension(25, 38));

		btnAddSupplierProduct = new JButton("add product");
		btnAddSupplierProduct.setPreferredSize(new Dimension(25,38));

		showObject.setPreferredSize(new Dimension(600, 40));

		// gettextweb
		// gettextnr
		// gettextsupp
		// JOptionPane.showInputDialog(message)
		fill_supplier = new JTextField(results[0].toString());
		JTextField fill_nr = new JTextField(results[1].toString());
		JTextField fill_web = new JTextField(results[2].toString());
		//JTextField fill_web = new JTextField("test.com");


		fill_web.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_nr.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_supplier.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		fill_nr.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_supplier.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_web.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		showObject.add(fill_supplier);
		
		showObject.add(fill_nr);
		showObject.add(fill_web);
		

		/**
		showObject.add(fill_supplier);
		showObject.add(fill_nr);
		showObject.add(fill_web);
		*/
		showObject.add(btnDeleteSupplier);
		showObject.add(btnAddSupplierProduct);
		btnDeleteSupplier.addActionListener(this);
		btnAddSupplierProduct.addActionListener(this);

		add(showObject);

	}

	private void showhStock(Object[] results) {
		setPreferredSize(new Dimension(600, 500));
		showObject = new JPanel(new GridLayout(1, 7));
		btnDeleteProduct = new JButton("DELETE");
		btnDeleteProduct.setPreferredSize(new Dimension(50, 38));
		btnProductInfo = new JButton("info");
		// btnProductInfo.setPreferredSize()
		btnPanel = new JPanel();

		showObject.setPreferredSize(new Dimension(600, 40));

		fill_productID = new JTextField(results[0].toString());
		JTextField fill_productname = new JTextField(results[1].toString());
		JTextField fill_instock = new JTextField(results[2].toString());
		JTextField fill_customerPrice = new JTextField(results[3].toString());
		JTextField fill_manufactorer = new JTextField(results[4].toString());

		fill_productID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_productname.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_instock.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_customerPrice.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_manufactorer.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		fill_productname.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_instock.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_productID.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_customerPrice.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_manufactorer.setFont(new Font("sanserif", Font.PLAIN, 15));

		showObject.add(fill_productID);
		showObject.add(fill_productname);
		showObject.add(fill_instock);
		showObject.add(fill_customerPrice);
		showObject.add(fill_manufactorer);
		// btnPanel.add(btnDeleteProduct);
		// btnPanel.add(btnProductInfo);
		showObject.add(btnDeleteProduct);
		showObject.add(btnProductInfo);
		// showObject.add(btnPanel);
		btnDeleteProduct.addActionListener(this);
		btnProductInfo.addActionListener(this);

		add(showObject);

	}

	private void showStock_c(Object[] results) {

		// String customer = JOptionPane.showInputDialog("enter person number");

		cart = new shoppingCart("9308287250");
		setPreferredSize(new Dimension(600, 500));
		showObject = new JPanel(new GridLayout(1, 6));
		// buy = new JButton("buy");
		buy.setPreferredSize(new Dimension(50, 38));
		// btnProductInfo = new JButton("info");
		// btnProductInfo.setPreferredSize()
		// btnPanel = new JPanel();

		showObject.setPreferredSize(new Dimension(600, 40));

		fill_productID = new JTextField(results[0].toString());
		JTextField fill_productname = new JTextField(results[1].toString());
		JTextField fill_instock = new JTextField(results[2].toString());
		fill_customerPrice = new JTextField(results[3].toString());
		JTextField fill_manufactorer = new JTextField(results[4].toString());

		fill_productID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_productname.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_instock.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_customerPrice.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_manufactorer.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		fill_productname.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_instock.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_productID.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_customerPrice.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_manufactorer.setFont(new Font("sanserif", Font.PLAIN, 15));

		showObject.add(fill_productID);
		showObject.add(fill_productname);
		showObject.add(fill_instock);
		showObject.add(fill_customerPrice);
		showObject.add(fill_manufactorer);
		// btnPanel.add(btnDeleteProduct);
		// btnPanel.add(btnProductInfo);
		showObject.add(buy);
		// showObject.add(btnPanel);
		buy.addActionListener(this);
		System.out.println("bajs");

		add(showObject);

	}

	private void showPurchased(Object[] results) {
		setPreferredSize(new Dimension(600, 500));
		showObject = new JPanel(new GridLayout(1, 5));
		btnDeletePurchase = new JButton("DELETE");
		btnDeletePurchase.setPreferredSize(new Dimension(50, 38));
		btnPurchaseInfo = new JButton("info");

		showObject.setPreferredSize(new Dimension(600, 40));


		fill_purchaseID = new JTextField(results[0].toString());
		JTextField fill_customerID = new JTextField(results[1].toString());
		JTextField fill_totalPrice = new JTextField(results[2].toString());
		JTextField fill_timestamp = new JTextField(results[3].toString());

		fill_purchaseID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_customerID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_timestamp.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_totalPrice.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		fill_customerID.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_timestamp.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_purchaseID.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_totalPrice.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		showObject.add(fill_purchaseID);
		showObject.add(fill_customerID);
		showObject.add(fill_totalPrice);
		showObject.add(fill_timestamp);
		/**
		showObject.add(fill_timestamp);
		showObject.add(fill_customerID);
		showObject.add(fill_purchaseID);
		showObject.add(fill_totalPrice);
		*/
		
		showObject.add(btnDeletePurchase);
		showObject.add(btnPurchaseInfo);
		btnDeletePurchase.addActionListener(this);
		btnPurchaseInfo.addActionListener(this);

		add(showObject);

	}

	private void showcustomer(Object[] results) {
		setPreferredSize(new Dimension(600, 500));
		showObject = new JPanel(new GridLayout(1, 5));
		btnDeleteCustomer = new JButton("DELETE");
		btnDeleteCustomer.setPreferredSize(new Dimension(50, 38));

		showObject.setPreferredSize(new Dimension(600, 40));

		c_fill_customerID = new JTextField(results[0].toString());
		JTextField fill_name = new JTextField(results[1].toString());
		JTextField fill_address = new JTextField(results[2].toString());
		JTextField fill_mail = new JTextField(results[3].toString());

		c_fill_customerID.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_name.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_address.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		fill_mail.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));

		fill_name.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_address.setFont(new Font("sanserif", Font.PLAIN, 15));
		c_fill_customerID.setFont(new Font("sanserif", Font.PLAIN, 15));
		fill_mail.setFont(new Font("sanserif", Font.PLAIN, 15));

		showObject.add(c_fill_customerID);
		showObject.add(fill_name);
		showObject.add(fill_address);
		showObject.add(fill_mail);

		showObject.add(btnDeleteCustomer);
		btnDeleteCustomer.addActionListener(this);

		add(showObject);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDeleteCustomer) {
			try {
				// System.out.println(c_fill_customerID.getText());
				PgTest.removeCustomer(c_fill_customerID.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnDeleteProduct) {
			try {
				PgTest.removeProduct(fill_productID.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnDeleteSupplier) {
			try {
				System.out.println(fill_supplier.getText()); 
				PgTest.removeSupplier(fill_supplier.getText());
				// delete from supplierProduct
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnDeletePurchase) {
			try {
				PgTest.removePurchase(fill_purchaseID.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == buy) {
			System.out.println("jadå");
			int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter amount"));
			System.out.println(fill_customerPrice.getText());
			int price = Integer.parseInt(fill_customerPrice.getText());
			try {
				cart.buy(fill_productID.getText(), qty, price);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// int quantity= Integer.parseInt(qty);
		}else if(e.getSource()== btnProductInfo){
			System.out.println(fill_productID.getText());
			try {
				String r=PgTest.supplierProductString(PgTest.productDetails(fill_productID.getText()));
				//String r=PgTest.resToString(PgTest.productDetails(fill_productID.getText()));
				System.out.println(r);
				JOptionPane.showMessageDialog(null, r);
				//PgTest.printRes(PgTest.productDetails(fill_productID.getText()));
				//JOptionPane.showMessageDialog(null,PgTest.resToString(PgTest.productDetails(fill_productID.getText())));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==btnAddSupplierProduct){
			int productToAdd=Integer.parseInt(JOptionPane.showInputDialog("enter productID"));
			int supplierPrice=Integer.parseInt(JOptionPane.showInputDialog("Enter supplier price"));
			
			try {
				PgTest.addSupplierProduct(productToAdd, fill_supplier.getText(), supplierPrice);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btnPurchaseInfo){
			try {
				String r=PgTest.purchaseProductString(PgTest.purchaseDetails(fill_purchaseID.getText()));
				//String r=PgTest.resToString(PgTest.purchaseDetails(fill_purchaseID.getText()));
				System.out.println(r);
				JOptionPane.showMessageDialog(null, r);
				//PgTest.printRes(PgTest.productDetails(fill_productID.getText()));
				//JOptionPane.showMessageDialog(null,PgTest.resToString(PgTest.productDetails(fill_productID.getText())));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
