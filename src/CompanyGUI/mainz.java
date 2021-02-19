package CompanyGUI;

import javax.swing.JOptionPane;

public class mainz {
	
	public static void main(String[] args) {
		//startWindow companyGUI=new startWindow();
		String r = JOptionPane.showInputDialog("customer or owner");
		
		startWindow companyGUI=new startWindow(r);
		//companyGUI.co
		
	}

}
