package gr.codelearn.core.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		var u1 = new User("Costas", "Giannacoulis", "c.giannacoulis@codelearn.gr");
		var u2 = new User("Costas", "Giannacoulis", "c.giannacoulis@codelearn.gr");
		System.out.println(u1);
		System.out.println(u2);
		u1.changeConstant(15);
		System.out.println(u1);
		System.out.println(u2);

		int[] intArray = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + ",");
		}
		intArray[9] = 110;
		System.out.println();
		for (int i : intArray) {
			System.out.print(i + ",");
		}

		NotificationService notificationService = new NotificationServiceImpl();

		//		var u3 = new User("Nikos", "Nikolaou", "n.nikolaou@codelearn.gr")
	}
}
