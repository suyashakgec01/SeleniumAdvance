package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionExample {

	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
	}

	@Test
	public void m2() {
		String expData = "Qspiders";
		String actData = "Qspiders";
		Assert.assertEquals(actData, expData);
//		Assert.assertEquals(actData, expData, "Both data are different");
	}
}
