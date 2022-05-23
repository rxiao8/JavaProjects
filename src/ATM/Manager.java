package ATM;

import java.util.Comparator;

import ATM.IO.DatabaseIO;

/**
 * A singleton design to ensure only one instance of the ATM exist throughout
 * the entire program. This ensures security as well as confidentiality as the
 * data will be stored without confusion.
 * 
 * @author Rozie
 */
public class Manager {
	/** The single instance of manager */
	private static Manager instance;
	/** The ATM state */
	private State state;
	/** Current user */
	private User user = null;
	/** A database of the Users */
	private Database data;
	/** Tracks to see if another user is in */
	private boolean login = false;

	/**
	 * Account number assigned to each new user. Since it's a singleton,, it's a
	 * public static value
	 */
	public static int num = 0;

	/** A private constructor of the manager to ensure the design pattern */
	private Manager() {
		state = new State();
		data = new Database();
	}

	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	/**
	 * Retrieves the User from the data
	 * 
	 * @param  first
	 * @param  last
	 * @return
	 */
	public User login(String first, String last, String pin) {
		if (login) {
			throw new IllegalAccessError("Currently logged in");
		}
		user = data.retrieveUser(first, last, pin);
		if (user != null) {
			login = true;
		}
		return user;
	}

	/**
	 * Creates a new User
	 * 
	 * @param first
	 * @param last
	 * @param email
	 * @param phone
	 */
	public boolean createUser(String first, String last, String email, String phone, double init, String pin) {

		User u = new User(first, last, email, phone, init, pin);
		// sets their account number based on the order they were created
		if (u.equals(user)) {
			return false;
		}
		boolean flag = data.addUser(u);
		// if user was successfully created,, increment the account num
		if (flag) {
			u.setAcctNum(num);
			num++;
		}
		return flag;

	}

	/**
	 * Returns the account number of the user
	 */
	public int getAcctNum() {
		return user.getAcctNum();
	}

	/**
	 * Puts in the command by the user
	 * 
	 * @param input
	 */
	public void input(String input) {
		Command cmd = new Command(input);
		state.update(cmd);

	}

	/**
	 * Creates a Transaction if the command is withdrawl or deposit
	 * 
	 * @param amt
	 */
	public void createTransaction(Command c, double amt) {
		if (state.getStateName().equalsIgnoreCase("withdrawl") || state.getStateName().equalsIgnoreCase("deposit")) {
			Transaction t = new Transaction(c, amt);
			user.addAct(t);
			if (state.getStateName().equalsIgnoreCase("deposit")) {
				user.addBalance(amt);
			}
			else {
				user.addBalance(0 - amt);
			}

		}
	}

	/**
	 * Prints the activities if the command is to print
	 * 
	 * @param sort
	 */
	public void printTransaction(Comparator<Transaction> c) {
		if (state.getStateName().equalsIgnoreCase("print")) {
			user.print(c);
		}
	}

	/**
	 * Logs current user out
	 */
	public void logout() {
		if (!login) {
			throw new IllegalArgumentException("No current user logged in ");
		}
		user = null;
		login = false;

	}

	/**
	 * Reads in a file of users and adds them to the table
	 * 
	 * @param filename
	 */
	public void readFile(String filename) {
		try {
			DatabaseIO.readData(data, filename);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("File cannot be found.");
		}
		num = data.getSize();
	}

	/**
	 * Clears the database
	 */
	public void clearData() {
		data.destroy();
	}

	/**
	 * Returns the current user logged in
	 * 
	 * @return
	 */
	public User getCurr() {
		return user;
	}

	public int getSize() {
		return data.getSize();
	}
}
