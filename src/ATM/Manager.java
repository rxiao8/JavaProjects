package ATM;

import java.util.Comparator;

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
	public User login(String first, String last) {
		user = data.retrieveUser(first, last);
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
	public void createUser(String first, String last, String email, String phone, double init) {
		User u = new User(first, last, email, phone, init);
		data.addUser(u);

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

	public void clearData() {
		data.destroy();
	}

	public int getSize() {
		return data.getSize();
	}
}
