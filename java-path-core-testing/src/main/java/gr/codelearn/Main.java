package gr.codelearn;

import java.math.BigDecimal;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String name = "Ioannis";
		final BigDecimal bigDecimal = new BigDecimal("2");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		customMethod("Ioannis", "Ioannis2", "Ioannis3");

		final List<String> ioannis = List.of("Ioannis", "Ioannis2", "Ioannis4", "Ioannis5", "Ioannis2", "Ioannis23",
											 "Ioannis33", "Ioannis42", "Ioannis3");
		String name2 = "Ioannis";
		String substring = name2.substring(0, 4);
		List<String> strings = ioannis.stream()
				.map(s -> s.substring(0, 4))
									  .sorted()
									  .distinct()
									  .limit(1)
											.toList();
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
		System.out.println("Hello world!");
	}

	private static void customMethod(String... names){
		System.out.println(names.length);
		System.out.println(names[0]);
		// var args
	}
}
