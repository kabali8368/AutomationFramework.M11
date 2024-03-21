package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		
		//Step 1: Register the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Establish connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m11db", "root", "kabali");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute a query
		int result = state.executeUpdate("insert into candidate_info values('spiderman',6,'Newyork');");
		if(result==1)
		{
			System.out.println("Data added");
		}
		
		ResultSet result1 = state.executeQuery("select * from candidate_info;");
		while(result1.next())
		{
			System.out.println(result1.getString(3)+"-"+result1.getInt(2)+"-"+result1.getString(3));
		}
		
		//Step 5: Close the DB
		con.close();

	}

}
