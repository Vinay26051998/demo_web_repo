 package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class DatabaseUtility implements IAutoConstents{
	
	Connection connection=null;
	/**
	 * This Method is developed to establish the connection between the database
	 */
	public void establishingTheConnection() {
		Driver dbdriver=null;
		try {
			dbdriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(DATABASE_URL, DATABASE_UN, DATABASE_PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is developed to read the data from Database
	 * And returning the data in the form of Arraylist
	 * @param query
	 * @param columnName
	 * @return Arraylist
	 */
	public ArrayList readingTheDataFromDatabase(String query,String columnName) {
		Statement statement=null;
		ResultSet result=null;
		ArrayList list=new ArrayList();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (result.next()) {
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * This method is used to close the connection between the Database
	 */
	public void closingTheConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
