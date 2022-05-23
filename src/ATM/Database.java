package ATM;

import java.util.ArrayList;

/**
 * List of all users in the bank certified to use the atm Refactor to map soon
 * 
 * @author Rozie
 */
public class Database {
	/** ArrayList of all the users */
	private ArrayList<User> table;

	public Database() {
		table = new ArrayList<User>();

	}

	public int getSize() {
		return table.size();
	}

	/**
	 * Adds user to the table. If changing user attributes,, then the User will be
	 * updated and added to the end of the list
	 * 
	 * @param  u
	 * @return
	 */
	public boolean addUser(User u) {
		if (!findUser(u)) {
			table.add(u);
			return true;
		}
		return false;
	}

	/**
	 * Removes user from the table
	 * 
	 * @param  u
	 * @return
	 */
	public boolean removeUser(User u) {
		if (findUser(u)) {
			return table.remove(u);

		}
		return false;
	}

	/**
	 * Checks if the user already exists
	 * 
	 * @param  u
	 * @return
	 */
	public boolean findUser(User u) {
		return table.contains(u);
	}

	/**
	 * Retrieves the user from the table
	 * 
	 * @param  u
	 * @return
	 */
	public User retrieveUser(String first, String last, String pin) {
		for (User user : table) {
			if (user.getFirst().equalsIgnoreCase(first) && user.getLast().equalsIgnoreCase(last)
					&& user.getPin().equalsIgnoreCase(pin)) {
				return user;
			}
		}

		return null;
	}

	/**
	 * Clears the table
	 */
	public void destroy() {
		table.clear();
	}
}
