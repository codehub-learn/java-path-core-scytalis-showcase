package gr.codelearn;

import gr.codelearn.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQLConnection");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();

		final Customer customer = Customer.builder().firstname("Ioannis").lastname("Daniil").address("Athens 15 Av.")
										  .email("daniil@gmail.com").customerCategory(CustomerCategory.INDIVIDUAL).age(
						56).build();
		performSave(entityManager, customer);
		logger.info("{}", customer.getId());
		customer.setLastname("Daniel");
		performSave(entityManager, customer);
		final Customer customer2 = Customer.builder().firstname("Ioannis2").lastname("Daniil2").address(
												   "Athens 15 Av.2").email("daniil@gmail2.com").customerCategory(CustomerCategory.INDIVIDUAL).age(55)
										   .build();
		performSave(entityManager, customer2);

		final Category category = Category.builder().description("Vegetables").build();
		performSave(entityManager, category);

		final Product product = Product.builder().serial("AA12").price(BigDecimal.TEN).name("Potatoes").category(
				category).build();
		performSave(entityManager, product);

		final Product product2 = Product.builder().serial("AA13").price(BigDecimal.TEN).name("Tomatoes").category(
				category).build();
		performSave(entityManager, product2);

		final Product product3 = Product.builder().serial("AA14").price(BigDecimal.TEN).name("Lettuce").build();
		performSave(entityManager, product3);

		final Order order = Order.builder().customer(customer2).paymentMethod(PaymentMethod.CREDIT_CARD).submitDate(
				new Date()).totalPrice(BigDecimal.TEN).build();

		final List<OrderItem> orderItems = List.of(OrderItem.builder().order(order).quantity(5).price(BigDecimal.ZERO)
															.product(product).build(), OrderItem.builder().order(order)
																								 .quantity(5).price(
						BigDecimal.ZERO).product(product2).build(), OrderItem.builder().order(order).quantity(5).price(
				BigDecimal.ZERO).product(product2).build());

		order.setOrderItems(orderItems);

		performSave(entityManager, order);

		entityManager.close();
		entityManagerFactory.close();

	}

	public static void performSave(EntityManager entityManager, Object o) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(o);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			logger.error(e.getMessage());
		}
	}
}
