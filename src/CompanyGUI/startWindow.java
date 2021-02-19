package CompanyGUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import CompanyGUI.WindowFrameCompany.state;

public class startWindow{

private JPanel panel1;
private startWindow companyGUI;

private WindowFrameCompany windowFrameCompany;

private ViewCustomerFrame window;


	public  startWindow(String string){
		//ButtonFrame panel1= new ButtonFrame(this);
		
		//windowFrameCompany= new WindowFrameCompany(state.welcome,this);
		
		//window = new ViewCustomerFrame(this);
		
		//SearchFrameCustomer searchFrameCustomer= new SearchFrameCustomer();
		//SearchFrameStock panelstock= new SearchFrameStock();
//		SearchFrameSupplier supplier= new SearchFrameSupplier(this);
//		SearcFramePurchaesd purchaesd= new SearcFramePurchaesd();
		JFrame frame = new JFrame( "FlowLayoutApp" );
		 frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	if(string.equals("owner")){
		System.out.println("hej");
		windowFrameCompany= new WindowFrameCompany(state.welcome,this);
		frame.add(windowFrameCompany);
	}else{
		System.out.println("då");
		window = new ViewCustomerFrame(this);
		frame.add(window);
	}
		
		//frame.setResizable(false);
		
       
        //frame.add( panel1 );
        
        
        //frame.add(window);
        
        frame.pack();
        frame.setVisible( true );
        
	}
	public void setWindow(state theState){
		
		if(theState==state.customer){
			windowFrameCompany= new WindowFrameCompany(state.customer,this);
		}
		else if(theState==state.product){
			windowFrameCompany= new WindowFrameCompany(state.product,this);
		}
		else if(theState==state.supplier){
			windowFrameCompany= new WindowFrameCompany(state.supplier,this);
		}
		else if(theState==state.purchased){
			windowFrameCompany= new WindowFrameCompany(state.purchased,this);
		}
		
	}

	
	public static void main(String[] args) {
		//startWindow companyGUI=new startWindow();
		
		//companyGUI.co
		
	}
	
	
	
}
