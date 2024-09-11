package TestNGPractice;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(invocationCount = 3)
	public void createProductTest() {
		System.out.println("Product Created");
	}

	@Test
	public void modifyProductTest() {
		System.out.println("Product Modified");
	}

	@Test
	public void deleteProductTest() {
		System.out.println("Product Deleted");
	}
}
