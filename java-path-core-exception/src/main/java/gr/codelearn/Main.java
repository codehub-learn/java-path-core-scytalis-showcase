package gr.codelearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		try {
			final String[] strings = new String[10];
			final String string = strings[13];
			Integer.parseInt("5a");
			// ...
			// ...
			// ...
			logger.info("hello");
			logger.info("hello");
		}
		catch(ArrayIndexOutOfBoundsException e){
			logger.error("Array index out of bounds");
		}


		logger.info("outside try");
		try {
			serviceMethod();
		} catch (BusinessException e) {
			// redirect page 404 (for example)
			logger.error(e.getMessage());
		}
	}

	private static void readFile(){
		try {
			final FileReader fileReader = new FileReader("/C://...");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static void connectToDatabase(){
		try {
			final Connection connection = DriverManager.getConnection("...");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static void repositoryMethod() throws SQLException {
		DriverManager.getConnection("...");
	}

	private static void serviceMethod() throws BusinessException {
		try {
			repositoryMethod();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new BusinessException("Cannot connect to database");
		}
	}
}
