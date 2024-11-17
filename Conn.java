package bank.management.system;

import java.sql.*;

public class Conn
{
	//5 step-
	//register the driver
	//create connection
	//create staement
	//executequery
	//close connection
	
	Connection c;
	Statement s;
	public Conn()
	{
		try
		{
			//Class.forName(com.mysql.cj.jdbc.Driver);
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Sd_92002");
			s= c.createStatement();	
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
