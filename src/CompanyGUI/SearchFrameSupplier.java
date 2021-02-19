package CompanyGUI;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CompanyGUI.showObject.jPanel;
import db_connect.PgTest;

public class SearchFrameSupplier extends JPanel implements ActionListener, MouseListener{
	private JPanel bottom= new JPanel();
	private JPanel lPanel=new JPanel();
	private JPanel rPanel= new JPanel();
		private String supstring= "Type supplier";
	private Object[][] res;
	private JTextField supplier= new JTextField(supstring); //
	private JButton search= new JButton("Search");
	private JButton add= new JButton("ADD");
	private JPanel showinfo;
	private WindowFrameCompany theparent;
	//private JTextField prodname= new JTextField("type product name");
//	private JTextField prodid= new JTextField("type product id");
	
//	private JTextField supplier= new JTextField("type supplier ");
	//private JTextField puchase= new JTextField("type receipt number");
	
	public SearchFrameSupplier( WindowFrameCompany parent){
		theparent=parent;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 140));
		showinfo= new JPanel(new GridLayout(1, 4));
		showinfo.setPreferredSize(new Dimension(600, 40));
		lPanel.setPreferredSize(new Dimension(400, 100));
		rPanel.setPreferredSize(new Dimension(200, 100));
	
		JLabel web=new JLabel("webadress",JLabel.LEFT);
		JLabel nr=new JLabel("telephone nr",JLabel.LEFT);
		JLabel supp=new JLabel("supplier",JLabel.LEFT);
		
		lPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		rPanel.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		web.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		nr.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		supp.setBorder(BorderFactory.createBevelBorder(FRAMEBITS, Color.RED, Color.black));
		
		web.setFont(new Font("sanserif", Font.PLAIN, 15));
		nr.setFont(new Font("sanserif", Font.PLAIN, 15));
		supp.setFont(new Font("sanserif", Font.PLAIN, 15));
		
		
		
		lPanel.setLayout(null);
		rPanel.setLayout(null);
		//search.setPreferredSize(new Dimension(110, 60));
		
		//pnr.setPreferredSize(new Dimension(110, 60));

		
		
		
		lPanel.setBackground(Color.pink);
		rPanel.setBackground(Color.red);
		
		showinfo.add(supp);
		showinfo.add(nr);
		showinfo.add(web);
		showinfo.add(new JPanel());
		
		lPanel.add(supplier);
		rPanel.add(search);
		rPanel.add(add);
		supplier.setBounds(20,20,110,60);
		search.setBounds(10, 20, 80, 60);
		add.setBounds(85,20, 80, 60);
		
		add(lPanel,BorderLayout.CENTER);
		add(rPanel, BorderLayout.EAST);
		add(showinfo, BorderLayout.SOUTH);
		
		supplier.addMouseListener(this);
		search.addActionListener(this);
		add.addActionListener(this);

		
		//supplier.setEnabled(true);
	
		
	}
	
	public void searchAll(){
		try {
			res=PgTest.supplierSearch(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		theparent.showResults(res, jPanel.panelsupplier);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == search) {
               try {
            	   if(supplier.getText()==supstring){
            		   res = PgTest.supplierSearch(null);
            	   }
            	   else{
				res = PgTest.supplierSearch(supplier.getText());
				theparent.refreshResults();
				theparent.showResults(res, jPanel.panelsupplier);
            	   }
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
               printRes(res);
            }
		 else if (e.getSource() == add) {
				String arr[] = { "supplier", "nbr", "web"};
				
				for (int i = 0; i < 3; i++) {
					arr[i] = JOptionPane.showInputDialog(arr[i]);
					 
				}
				try {
					PgTest.addSupplier(arr[0], arr[1], arr[2]);
					theparent.refreshResults();
					res = PgTest.supplierSearch(null);
					printRes(res);
					theparent.showResults(res, jPanel.panelsupplier);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==supplier) {
			supplier.setText(null);
		} 
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(supplier.getText().length()==0){
			supplier.setText(supstring);
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
