
package ATM.ATMTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ATM.Command;
import ATM.Transaction;
import ATM.User;
import ATM.ATMcomparators.amountComparator;

public class UserTest {
	// private timeDateComparator timeDate = new timeDateComparator();
	private amountComparator amount = new amountComparator();
	private String firstN = "Rose";
	private String lastN = "Xiao";
	private String validEmail = "rose@email";
	private String invalidEmail = ".Rose@";
	private String validPhone = "3335554444";
	private String invalidPhone1 = "333554444";
	private String invalidPhone2 = "phone";
	private String invalidPhone3 = "33355554444";
	private String pin = "1234";
	private String invalidPin = "12";
	private String invalidPin2 = "12345";
	private double deposit = 500;

	/** The commands */
	private Command cmdOne = new Command("HOME");
	private Command cmdTwo = new Command("WITHDRAWL");
	private Command cmdThree = new Command("DEPOSIT");
	private Command cmdFour = new Command("CHECK");
	private Command cmdFive = new Command("PRINT");

	/** The Transactions */
	private Transaction oneT = new Transaction(cmdOne, 0);
	private Transaction twoT = new Transaction(cmdTwo, 30);
	private Transaction threeT = new Transaction(cmdThree, 30);
	private Transaction fourT = new Transaction(cmdFour, 0);
	private Transaction fiveT = new Transaction(cmdFive, 0);

	@Test
	public void makeUser() {
		User u = new User(firstN, lastN, validEmail, validPhone, deposit, pin);
		assertEquals("Rose", u.getFirst());
		assertEquals("Xiao", u.getLast());
		assertEquals("rose@email", u.getEmail());
		assertEquals("3335554444", u.getPhone());
		assertEquals("1234", u.getPin());
		assertTrue(500 == u.getBalance());

		u.addBalance(500);
		assertTrue(1000 == u.getBalance());
		try {
			u.setEmail(invalidEmail);
			u.setEmail(null);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid email", e.getMessage());
		}
		try {
			u.setPhone(invalidPhone1);
			u.setPhone(invalidPhone2);
			u.setPhone(invalidPhone3);
			u.setPhone(null);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid phone format", e.getMessage());
		}
		try {
			u.setPin(invalidPin);
			u.setPin(invalidPin2);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid pin", e.getMessage());
		}

		u.addAct(oneT);
		assertTrue(1 == u.getActivities().size());
		u.addAct(twoT);
		u.addAct(threeT);
		assertTrue(3 == u.getActivities().size());
		u.addAct(fourT);
		u.addAct(fiveT);
		assertTrue(5 == u.getActivities().size());

		u.addAct(new Transaction(new Command("DEPOSIT"), 40));

		u.print(null);
		u.print(amount);

		assertTrue(0 == u.getAcctNum());

	}

}
