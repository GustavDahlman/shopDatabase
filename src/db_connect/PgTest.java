package db_connect;

import java.sql.*;

import java.util.*;
/** Class containing all the methods for accessing the database
 * 
 * TO DO: Clean code
 */

public class PgTest {
	
	private static String dbAdress = "jdbc:postgresql://localhost/postgres?user=postgres&password=123&ssl=true";
	public static Object[][] searchByProductName(String name) throws Exception {

		Object[][] answer;
		String str = "'%" + name + "%'";
		int length = 0;
		
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		

		PreparedStatement stmt = conn.
		
				prepareStatement("select* from product where productName like" + str, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		answer = new Object[rows][length];
		while (rs.next()) {
			
			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				res = rs.getString(i);
				// data =rs.getMetaData();
				label = data.getColumnLabel(i);
				// rs.getMetaData();
				System.out.print(label + ":" + res + " ");
			}

		}
		conn.close();
		return answer;

	}

	public static void searchByProductID(int id) throws Exception {

		String[] answer;
		// String str="'%"+name+"%'";
		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);



		PreparedStatement stmt = conn.
		
				prepareStatement("select* from product where productID=" + id);
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		while (rs.next()) {
			
			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				res = rs.getString(i);
				
				label = data.getColumnLabel(i);
				
				System.out.print(label + ":" + res + " ");
			}

		}
		conn.close();

	}

	public static void addProduct(String productName, int stock, int price, String manufacturer) throws Exception {
		// int id=1;
		String name = "'" + productName + "'";
		String manu = "'" + manufacturer + "'";

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("insert into product(productName,stock,price,manufacturer)"
				+ " values (" + name + "," + stock + "," + price + "," + manu + ")");

		stmt.executeUpdate();

		stmt = conn.prepareStatement("select productName from product where productName=" + name);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("productName") + " was succesfully added to the database");
		}
		conn.close();

	}

	public static Object[][] searchByPrice(int min, int max) throws Exception {

		// Object[][] answer;

		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		// String begins = "L";

		PreparedStatement stmt = conn.
		// prepareStatement("select* from dog where name="+str);
				prepareStatement("select* from product where price<" + max + "AND price>" + min,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {
			// res=rs.getString(1);

			// label=data.getColumnLabel(1);
			// rs.getMetaData();
			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);
				// data =rs.getMetaData();
				label = data.getColumnLabel(i);
				// rs.getMetaData();
				// System.out.print(label+":"+res+" ");
			}

		}
		conn.close();
		return answer;

	}

	public static void addSupplier(String supplier, String telephone, String website) throws Exception {

		String theSupplier = "'" + supplier + "'";
		String theWebsite = "'" + website + "'";
		String theTelephone = "'" + telephone + "'";

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("insert into supplier(supplier,telephone,webpage)" + " values ("
				+ theSupplier + "," + theTelephone + "," + theWebsite + ")");

		stmt.executeUpdate();

		stmt = conn.prepareStatement("select supplier from supplier where supplier=" + theSupplier);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("supplier") + " was succesfully added to the database");
		}
		conn.close();
	}

	public static void addSupplierProduct(int productID, String supplier, int price) throws Exception {

		String theSupplier = "'" + supplier + "'";

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("insert into supplierProduct(productID,supplier,supplierPrice)"
				+ " values (" + productID + "," + theSupplier + "," + price + ")");

		stmt.executeUpdate();
		System.out.println("check");

		stmt = conn.prepareStatement("select supplier from supplier where supplier=" + theSupplier);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("supplier") + " was succesfully added to the database");
		}
		conn.close();

	}

	public static void addCustomer(String customerid, String name, String adress, String mail) throws Exception {

		String thename = "'" + name + "'";
		String theadress = "'" + adress + "'";
		String themail = "'" + mail + "'";

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("insert into customer(customerid,name,adress,email)"
				+ " values (" + customerid + "," + thename + "," + theadress + "," + themail + ")");

		stmt.executeUpdate();
		System.out.println("check");

		conn.close();

	}

	public static void editProduct(int id, String column, String value) throws Exception {
		String theValue;
		if (column.equals("productname")) {
			theValue = "'" + value + "'";
		} else if (column.equals("stock")) {
			theValue = value;
		} else if (column.equals("price")) {
			theValue = value;
		} else if (column.equals("manufacturer")) {
			theValue = "'" + value + "'";
		} else {
			return;
		} // invalid argument

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn
				.prepareStatement("UPDATE product SET " + column + "=" + theValue + " WHERE productid=" + id);

		stmt.executeUpdate();

		conn.close();
	}

	public static void editCustomer(int id, String column, String value) throws Exception {
		String theValue;
		if (column.equals("name")) {
			theValue = "'" + value + "'";
		} else if (column.equals("adress")) {
			theValue = "'" + value + "'";
		} else if (column.equals("email")) {
			theValue = "'" + value + "'";
		} else {
			return;
		} // invalid argument

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn
				.prepareStatement("UPDATE customer SET " + column + "=" + theValue + " WHERE customerid=" + id);

		stmt.executeUpdate();

		conn.close();
	}

	public static void editSupplier(String supplier, String column, String value) throws Exception {
		String theValue;
		if (column.equals("supplier")) {
			theValue = "'" + value + "'";
		} else if (column.equals("telephone")) {
			theValue = value;
		} else if (column.equals("webpage")) {
			theValue = value;
		} else {
			return;
		} // invalid argument

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(
				"UPDATE supplier SET " + column + "=" + theValue + " WHERE supplier='" + supplier + "'");

		stmt.executeUpdate();

		conn.close();
	}

	public static void sqlQuerry(String command) throws Exception {

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(command);

		stmt.executeUpdate();

		conn.close();
	}

	public static Object[][] customerSearch(String id) throws Exception {

		String statement;

		if (id != null) {
			statement = "select* from customer where customerid=" + id;
		} else {
			statement = "select* from customer";
		}
		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		// String begins = "L";

		PreparedStatement stmt = conn.
		// prepareStatement("select* from dog where name="+str);
				prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {
			// res=rs.getString(1);

			// label=data.getColumnLabel(1);
			// rs.getMetaData();
			System.out.println("\n");

			for (int i = 1; i <= length; i++) {

				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);

				label = data.getColumnLabel(i);

			}
		}
		conn.close();
		return answer;

	}

	public static Object[][] productSearch(String id, String name) throws Exception {
		String statement;
		if (id != null && name != null) {
			statement = "select* from product where productid=" + id + "and productname='" + name + "'";
		} else if (id != null) {
			statement = "select* from product where productid=" + id;
		} else if (name != null) {
			statement = "select* from product where productname='" + name + "'";
		} else {
			statement = "select* from product";

		}

		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {

			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);

				label = data.getColumnLabel(i);

			}
		}
		conn.close();
		return answer;

	}

	public static Object[][] supplierSearch(String supplier) throws Exception {

		String statement;
		if (supplier != null) {
			statement = "select* from supplier where supplier='" + supplier + "'";
		} else {
			statement = "select* from supplier";
		}
		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		// String begins = "L";

		PreparedStatement stmt = conn.
		// prepareStatement("select* from dog where name="+str);
				prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {
			// res=rs.getString(1);

			// label=data.getColumnLabel(1);
			// rs.getMetaData();
			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);
				// data =rs.getMetaData();
				label = data.getColumnLabel(i);
				// rs.getMetaData();
				// System.out.print(label+":"+res+" ");
			}
		}
		conn.close();
		return answer;

	}

	public static Object[][] purchaseSearch(String purchaseid, String customerid) throws Exception {
		String statement;
		if (purchaseid == null && customerid == null) {
			System.out.println("mannen");
			statement = "select* from purchase";
		} else {
			if (purchaseid.length() != 0 && customerid.length() != 0) {
				System.out.println("case1");
				statement = "select* from purchase where purchaseid=" + purchaseid + " and customerid=" + customerid;
			} else if (purchaseid.length() != 0) {
				System.out.println(purchaseid);
				System.out.println(purchaseid.length());
				statement = "select* from purchase where purchaseid=" + purchaseid;
			} else if (customerid.length() != 0) {
				System.out.println("customer");
				System.out.println(customerid.length());
				statement = "select* from purchase where customerid=" + customerid;
			} else {
				statement = "select* from purchase";
			}
		}

		int length = 0;
		// int owner=0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.
		// prepareStatement("select* from dog where name="+str);
				prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {
			// res=rs.getString(1);

			System.out.println("\n");

			for (int i = 1; i <= length; i++) {
				// System.out.println("check");
				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);
				// data =rs.getMetaData();
				label = data.getColumnLabel(i);
				// rs.getMetaData();
				// System.out.print(label+":"+res+" ");
			}
		}
		conn.close();
		return answer;

	}

	public static Object[][] purchaseDetails(String purchaseid) throws Exception {

		String statement = "select* from purchaeditem where purchaseid=" + purchaseid;

		int length = 0;
		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {

			System.out.println("\n");

			for (int i = 1; i <= length; i++) {

				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);

				label = data.getColumnLabel(i);

			}
		}
		conn.close();
		return answer;

	}

	/**
	 * returns cheapest supplier for specified product
	 * 
	 * @param productid
	 * @return cheapest price and supplier
	 * @throws Exception
	 */

	public static Object[][] productDetails(String productid) throws Exception {

		String statement = "select* from (select* from supplierproduct where productid=" + productid
				+ " ORDER BY supplierprice ASC limit 1) as res";

		int length = 0;

		String res;
		String label;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		// String begins = "L";

		PreparedStatement stmt = conn.
		// prepareStatement("select* from dog where name="+str);
				prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery();

		ResultSetMetaData data = rs.getMetaData();
		length = data.getColumnCount();
		rs.last();
		int rows = rs.getRow();
		rs.beforeFirst();
		Object[][] answer = new Object[rows][length];
		while (rs.next()) {

			System.out.println("\n");

			for (int i = 1; i <= length; i++) {

				answer[rs.getRow() - 1][i - 1] = rs.getObject(i);

				res = rs.getString(i);

				label = data.getColumnLabel(i);

			}

		}
		conn.close();
		return answer;

	}

	public static void removeSupplier(String supplier) throws Exception {

		String theSupplier = "'" + supplier + "'";

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("delete from supplier where supplier=" + theSupplier);

		stmt.executeUpdate();

		conn.close();
	}

	public static void removeCustomer(String customerid) throws Exception {

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("delete from customer where customerid=" + customerid);

		stmt.executeUpdate();

		conn.close();
	}

	public static void removeProduct(String productid) throws Exception {

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("delete from product where productid=" + productid);

		stmt.executeUpdate();

		conn.close();
	}

	public static void removePurchase(String purchaseid) throws Exception {

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("delete from purchase where purchaseid=" + purchaseid);

		stmt.executeUpdate();

		conn.close();
	}

	public static void removeSupplierProduct(String supplier, String productid) throws Exception {

		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(
				"delete from supplierproduct where productid=" + productid + " " + "AND supplier='" + supplier + "'");

		stmt.executeUpdate();

		conn.close();
	}

	public static void printRes(Object[][] res) {

		for (int i = 0; i < res.length; i++) {
			// System.out.println(test[i][0]);
			System.out.println("\n");
			for (int k = 0; k < res[0].length; k++) {
				System.out.print(res[i][k] + "  ");
			}
		}
	}

	public static String supplierProductString(Object[][] res) {
		String r = "product id: " + res[0][0] + "\nSupplier: " + res[0][1] + "\nPrice: " + res[0][2];
		return r;

	}
	public static String purchaseProductString(Object[][] res){
		String r = "purchase id: " + res[0][0] + "\nProduct id: " + res[0][1] + "\nPaid:" + res[0][2]
				+ "\nQuantity: " + res[0][3];
		return r;
	}

	public static String resToString(Object[][] res) {
		String r = new String();
		for (int i = 0; i < res.length; i++) {
			// System.out.println(test[i][0]);
			// r+=" ";
			// System.out.println("\n");
			for (int k = 0; k < res[0].length; k++) {
				// System.out.print(res[i][k]+" ");
				r += res[i][k];
				r += "\n";
			}
		}
		return r;

	}

	public static int addPurchase(String customerID, int totalPrice) throws Exception {

		int res = 0;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement(
				"insert into purchase(customerid,totalprice)" + " values (" + customerID + "," + totalPrice + ")");

		stmt.executeUpdate();
		System.out.println("check");

		stmt = conn.prepareStatement("select max(purchaseid) from purchase as purchase");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			// System.out.println(rs.getInt("purchaseid"));
			res = rs.getInt(1);
		}
		conn.close();
		return res;

	}

	public static void addPurchaseItem(int purchaseID, String productID, int paidPrice, int amount) throws Exception {

		int res = 0;
		Class.forName("org.postgresql.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection(dbAdress);

		PreparedStatement stmt = conn.prepareStatement("insert into purchaeditem(purchaseid,productid,paidprice,amount)"
				+ " values (" + purchaseID + "," + productID + "," + paidPrice + "," + amount + ")");

		stmt.executeUpdate();
		System.out.println("check");
		stmt = conn.prepareStatement("UPDATE product SET stock = stock-" + amount + "where productid=" + productID);
		stmt.executeUpdate();

		// stmt= conn.prepareStatement("select max(purchaseID) from purchase");
		// ResultSet rs= stmt.executeQuery();
		// while (rs.next()){
		// System.out.println(rs.getInt("purchaseid"));
		// res=rs.getInt("purchaseid");
		// }
		 conn.close();
	}

	public static void main(String[] args) throws Exception {

		// editProduct(1,"productname","kniv");
		// addProduct("white widow",100,100,"motherEarth");
		// addSupplier("Hassan","0745382921",null);
		// addSupplierProduct(3,"ahmed",80);
		// addSupplierProduct(3,"Hassan",90);
		// searchByProductID(2);

		Object[][] test = productSearch(null, null);
		for (int i = 0; i < test.length; i++) {
			// System.out.println(test[i][0]);
			System.out.println("\n");
			for (int k = 0; k < test[0].length; k++) {
				System.out.print(test[i][k] + "  ");
			}
		}

		// addCustomer("9308287250","gustav","vendelsfridsg4b","gaus_93@hotmail.com");
		// customerSearch("9308287250");
		// removeCustomer("9308287250");
	}
}
