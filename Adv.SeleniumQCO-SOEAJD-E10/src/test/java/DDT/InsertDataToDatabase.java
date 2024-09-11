package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToDatabase {
	public static void main(String[] args) throws Throwable {
		// Step 1: Register/Load SQL database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		// Step 2: Get connection of the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "tiger123");

		// Step 3: Create A SQL Statement
		Statement sat = con.createStatement();
		String query = "INSERT INTO selenium(first_name,last_name,address)values('Raja','Singh','Delhi');";

		// Step 4: Execute Statement/Query
		int result = sat.executeUpdate(query);

		// Step 5: Checking if Data is added or not
		if (result == 1) {
			System.out.println("Data added");
		} else {
			System.out.println("Data not added");
		}
	}
}
