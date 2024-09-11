package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

	// DataProvider: -Executing same method/script multiple times with different set
	// of data
	// Return Two Dimentional Object Array

	// Booking Bus Tickets
	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src, String dest) {
		System.out.println("Book Tickets from " + src + " to " + dest);
	}

	@DataProvider
	public Object[][] dataProvider_BookTickets() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";

		objArr[1][0] = "Bangalore";
		objArr[1][1] = "Mysore";

		objArr[2][0] = "Bangalore";
		objArr[2][1] = "Chennail";
		return objArr;
	}

}
