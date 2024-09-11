package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadingDataFromDatabase {
	public static void main(String[] args) throws Throwable {
		// Step 1: Register/Load SQL database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		// Step 2: Get connection of the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "tiger123");

		// Step 3: Create A SQL Statement
		Statement sat = con.createStatement();
		String query = "SELECT * FROM SELENIUM";

		// Step 4: Execute Statement/Query
		ResultSet rs = sat.executeQuery(query);

		// Step 5:Fetch Data from ResultSet
		while (rs.next()) {
			System.out.println(
					rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t");
		}

	}

}
