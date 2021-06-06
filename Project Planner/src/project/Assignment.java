package project;

import java.time.LocalDate;

public class Assignment {

	private String name;
	private String person;
	private LocalDate initialDate;
	private LocalDate dueDate;
	private boolean status;
	// Parameters of the Assignment class

	public Assignment(String name, String person, LocalDate initialDate, LocalDate dueDate, boolean status) {
		this.name = name;
		this.person = person;
		this.initialDate = initialDate;
		this.dueDate = dueDate;
		this.status = status;
	}
	// Public constructor for the Assignment class

	public String toString() {
		String s = name + "\t";
		s += person + "\t";
		s += initialDate + "\t";
		s += dueDate + "\t";
		s += status;
		return s;
	}

	// toString method
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Get and set methods for the name argument
	/**
	 * @return the person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	// Get and set methods for the person argument
	/**
	 * @return the initialDate
	 */
	public LocalDate getInitialDate() {
		return initialDate;
	}

	/**
	 * @param initialDate the initialDate to set
	 */
	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	// Get and set methods for the initialDate argument
	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	// Get and set methods for the dueDate argument
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	// Get and set methods for the status argument

}