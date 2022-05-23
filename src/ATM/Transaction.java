package ATM;

import java.time.LocalDateTime;

import ATM.Command.Stage;

/**
 * an Object that contains what the user has done in the past action amount date
 * time
 * 
 * @author Rozie
 */
public class Transaction implements Comparable<Transaction> {
	// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private double amount;
	private LocalDateTime timeDate;
	private Stage type;

	public Transaction(Command c, double amount) {
		setType(c);
		setAmount(amount);
		setTimeDate();
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}
		this.amount = amount;
	}

	/**
	 * @return the time
	 */
	public LocalDateTime getTimeDate() {
		return timeDate;
	}

	/**
	 * @param time the time to set
	 */
	public void setTimeDate() {
		timeDate = LocalDateTime.now();
	}

	/**
	 * @return the type
	 */
	public Stage getType() {
		return type;
	}

	/**
	 * @param type2 the type to set
	 */
	public void setType(Command c) {
		this.type = c.getVal();

	}

	/**
	 * Compares the Transactions based on their time and date.
	 */
	@Override
	public int compareTo(Transaction o2) {
		if (this.getTimeDate().compareTo(o2.getTimeDate()) < 0) {
			return -1;
		}
		if (this.getTimeDate().compareTo(o2.getTimeDate()) < 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		String s = String.format("%-15s %20s %40s", getType(), getAmount(), getTimeDate());
		return s;
	}

}
