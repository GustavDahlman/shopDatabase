package db_connect;
import java.util.*;
/** TO DO: add functionality for adding multiple items to shoping cart */

public class shoppingCart {
	
	private String[][] cart;
	private String customerID;
	private int items;
	private String statement;
	private ArrayList list;
	
	
	
	public shoppingCart(String customer){
		customerID=customer;
		cart= new String[0][0];
		list = new ArrayList();
		items=0;
	}
	
	public String getCustomer(){
		return customerID;
	}
	public void setCustomer(String customer){
		customerID=customer;
		
	}
	public void add(String product, int quantity){
		items++;
		
		//cart= new String[items][2];
		
	}
	public void remove(String product){
		
	}
	public void buy(String productID, int quantity, int price) throws Exception{
		int totalPrice=price*quantity;
		int id=PgTest.addPurchase(customerID, totalPrice);
		PgTest.addPurchaseItem(id, productID, price, quantity);
	}
	public void checkout(){
		
	}
	
	

}
