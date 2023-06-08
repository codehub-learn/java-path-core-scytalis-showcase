package gr.codelearn.core.basic;

import static java.util.Arrays.asList;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private static Integer CONSTANT = 10;

	public User(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public void changeConstant(final Integer value) {
		CONSTANT = value;
		asList("x1", "x2");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email +
				'\'' + ", CONSTANT=" + CONSTANT + '}';
	}
}
