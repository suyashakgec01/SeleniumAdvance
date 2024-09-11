package TestNGPractice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

	@Test
	public void m1() {

		System.out.println("step1");
		System.out.println("step2");
		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(false, true);
		soft.assertEquals(false, true, "Assertion Fail Msg");

		System.out.println("step3");
		System.out.println("step4");
		soft.assertAll();
	}

}
