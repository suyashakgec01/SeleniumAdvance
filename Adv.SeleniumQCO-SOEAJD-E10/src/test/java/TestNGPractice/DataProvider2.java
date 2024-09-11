package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src, String dest, int noOfPass) {
		System.out.println("Book Tickets from " + src + " to " + dest + "with no. of passenger = " + noOfPass);
	}

	@DataProvider
	public Object[][] dataProvider_BookTickets() {
		Object[][] objArr = new Object[2][3];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";
		objArr[0][2] = 3;

		objArr[1][0] = "Bangalore";
		objArr[1][1] = "Mysore";
		objArr[1][2] = 5;

		return objArr;
	}

}
