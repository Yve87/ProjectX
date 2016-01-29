package application;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	
	public static java.sql.Connection connecten() throws InstantiationException, IllegalAccessException, 
	ClassNotFoundException, SQLException{

	String urlPrefix = "jdbc:mysql://";
	String dbName = "mydb";
	String dbTableName = "info";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password ="";
	String port = "3306";
	String host = "localhost";
	
	Class.forName(driver).newInstance();
	java.sql.Connection conn = DriverManager.getConnection(urlPrefix + host + ":" + port + "/" + 
	dbName, userName, password);
	
	return conn;
	}
}
