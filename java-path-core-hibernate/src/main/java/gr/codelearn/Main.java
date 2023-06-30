package gr.codelearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQLConnection");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();



		entityManager.close();
		entityManagerFactory.close();

	}
}
