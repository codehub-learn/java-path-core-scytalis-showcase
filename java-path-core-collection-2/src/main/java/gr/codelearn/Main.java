package gr.codelearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		//arrayListShowcase();
		//linkedListShowcase();
		//queueShowcase();
		//setShowcase();
		mapShowcase();
	}

	private static void mapShowcase() {
		HashMap<String, Integer> studentGradesMap = new HashMap<>();
		//studentGradesMap.put("Ioannis", 0);
		studentGradesMap.put("Alejandro", 52);
		//studentGradesMap.put("Ioannis", 10);
		logger.info("{}", studentGradesMap.get("Alejandro"));
		Integer pedroGrade = studentGradesMap.getOrDefault("Pedro", 0);
		increaseFrequency(studentGradesMap, "Ioannis");
		increaseFrequency(studentGradesMap, "Ioannis");
		increaseFrequency(studentGradesMap, "Ioannis");
		increaseFrequency(studentGradesMap, "Ioannis");
		logger.info("{}", pedroGrade);
		studentGradesMap.merge("Ioannis", 10, new BiFunction<Integer, Integer, Integer>() {
			@Override
			public Integer apply(final Integer currentValue, final Integer toBeAddedValue) {
				return currentValue + toBeAddedValue;
			}
		});
		logger.info("{}", studentGradesMap);
	}

	private static void increaseFrequency(HashMap<String, Integer> studentGradesMap, String key){
		studentGradesMap.put(key, studentGradesMap.getOrDefault(key, 0) + 1);
	}

	private static void setShowcase() {
		final Set<String> names = new HashSet<>();
		names.add("Ioannis");
		names.add("Alexandros");
		names.add("Ioannis");
		names.add("Ioannis");
		names.add("Ioannis");
		names.add("Ioannis");
		names.add("Ioannis");
		logger.info("{}", names);
	}

	private static void queueShowcase() {
		final Queue<String> linkedList = new LinkedList<>();
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		logger.info("{}", linkedList.peek());
		logger.info("{}", linkedList.size());
		logger.info("{}", linkedList.poll());
		logger.info("{}", linkedList.size());
		linkedList.poll();
		linkedList.remove();

		final PriorityQueue<String> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer("4");
		priorityQueue.offer("a");
		priorityQueue.offer("77");
		priorityQueue.offer("b");
		priorityQueue.offer("2");
		priorityQueue.offer("@");
		logger.info("{}", priorityQueue.poll());
		logger.info("{}", priorityQueue.poll());
		logger.info("{}", priorityQueue.poll());
		logger.info("{}", priorityQueue.poll());
		logger.info("{}", priorityQueue.poll());
		logger.info("{}", priorityQueue.poll());

		final PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>(new Comparator<Employee>() {
			@Override
			public int compare(final Employee o1, final Employee o2) {
				// > 0 left part is bigger
				// = 0 equal
				// < 0 right part is bigger
				return o2.getAge() - o1.getAge();
			}
		});
		employeePriorityQueue.offer(new Employee("Ioannis", 45));
		employeePriorityQueue.offer(new Employee("Ioannis2", 15));
		employeePriorityQueue.offer(new Employee("Ioannis3", 35));
		employeePriorityQueue.offer(new Employee("Ioannis4", 75));
		logger.info("{}", employeePriorityQueue.poll());
	}

	private static void arrayListShowcase() {
		ArrayList<String> arrayList = new ArrayList<>(1000);
		System.out.println("hello");
		arrayList.add("123");
		arrayList.add("444");
		arrayList.add("444");
		arrayList.add("467");
		arrayList.add("444");
		arrayList.add("123");
		arrayList.remove(2);
		arrayList.remove("123");
		arrayList.removeIf(new Predicate<String>() {
			@Override
			public boolean test(final String s) {
				return s.equals("123");
			}
		});
		logger.info("{}", arrayList);
	}

	private static void linkedListShowcase() {
		final List<String> linkedList = new LinkedList<>();
		System.out.println("hello");
		linkedList.add("123");
		linkedList.add("444");
		linkedList.add("444");
		linkedList.add("467");
		linkedList.add("444");
		linkedList.add("123");
		linkedList.remove(2);
		linkedList.remove("123");
		linkedList.removeIf(new Predicate<String>() {
			@Override
			public boolean test(final String s) {
				return s.equals("123");
			}
		});
		logger.info("{}", linkedList);
	}

}
