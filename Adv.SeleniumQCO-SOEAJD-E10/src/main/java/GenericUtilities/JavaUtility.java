package GenericUtilities;

import java.util.Random;

public class JavaUtility {

	public int getRandomNum() {
		Random r = new Random();
		int rn = r.nextInt(1000);
		return rn;

	}

}
