package com.wei.JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
    import java.sql.Statement;

	public class CreateCoffees {
		public static void main(String []args) throws InstantiationException, IllegalAccessException{
			Connection con;
			String createString;
			createString="create table COFFEES"+
						"(COF_NAME VARCHAR(32),"+
						"SUP_ID INTEGER"+
						"PRICE FLOAT"+
						"SALES INTEGER"+
						"TOTAL INTEGER)";
			Statement stmt;
			try{
				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			}catch(java.lang.ClassNotFoundException e){
				System.out.println("ClassNotFoundException:");
				System.out.println(e.getMessage());
			}
			try{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=wang0314");
				stmt=con.createStatement();
				stmt.executeUpdate(createString);
				stmt.close();
				con.close();
			}catch(SQLException ex){
				System.out.println("SQLException"+ex.getMessage());
			}
		}
	}


