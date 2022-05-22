package ATM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ATM.ATMcomparators.mergeSorter;

public class User {
	private double balance;
	private String first;
	private String last;
	private String email;
	private String phone;
	// private int id;
	// ordered by newest by default
	private ArrayList<Transaction> activities;
	private mergeSorter<Transaction> sorter = new mergeSorter<>();

	public User(String first, String last, String email, String phone, double initDeposit) {
		setBalance(initDeposit);
		setFirst(first);
		setLast(last);
		setEmail(email);
		setPhone(phone);
		activities = new ArrayList<Transaction>();

	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if (balance < 500 || balance > 10000) {
			throw new IllegalArgumentException();
		}
		this.balance = balance;
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		if (first == null) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.first = first;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		if (last == null) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.last = last;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Invalid email");
		}
		// Regular Expression. Found example on JavaTutorials
		String regex = "^(.+)@(.+)$";
		// Compile regular expression to get the pattern
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Invalid phone format");
		}
		// Regular Expression. Found example on JavaTutorials
		String regex = "[0-9]{10}";
		// Compile regular expression to get the pattern
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Invalid phone format");
		}
		this.phone = phone;
	}

	/**
	 * Adding an activity in descending order by time
	 */
	public void addAct(Transaction t) {
		activities.add(0, t);

	}

	public ArrayList<Transaction> getActivities() {
		return activities;
	}
	// public void setID(int ID) {
	// this.id = ID;
	// }
	//
	// public int getID() {
	// return id;
	// }

	/**
	 * sort list of act. Converts from ArrayList to arrays and uses a comparator if
	 * given
	 */
	public void print(Comparator<Transaction> c) {
		String header = String.format(" %s | %15s | %30s  ", "Transaction Type", "Amount", "Time&Date");
		System.out.println(header);
		if (c != null) {
			Transaction[] temp = activities.toArray(new Transaction[activities.size()]);

			sorter = new mergeSorter<Transaction>(c);

			sorter.sort(temp);

			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
			}
		}
		else {
			for (Transaction t : activities) {
				// will change to outputting to file
				System.out.println(t.toString());
			}
		}
	}

	public void addBalance(double addAmt) {
		if (addAmt <= 0) {
			throw new IllegalArgumentException("Invalid amount");
		}
		balance += addAmt;
	}

}
