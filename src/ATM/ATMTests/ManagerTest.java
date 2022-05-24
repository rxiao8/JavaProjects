package ATM.ATMTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ATM.ATMManager;
import ATM.Command;
import ATM.User;
import ATM.ATMcomparators.amountComparator;

public class ManagerTest {
	private ATMManager instance;

	@Before
	public void setUp() {
		instance = ATMManager.getInstance();
		instance.clearData();

	}

	@Test
	public void testManager() {
		assertFalse(instance.login("Rose", "Xiao", "1234"));
		instance.createUser("Rose", "Xiao", "rose@email", "6669994420", 500, "1234");
		assertTrue(instance.login("Rose", "Xiao", "1234"));
		assertTrue(1 == instance.getSize());
		User login = instance.getCurr();

		// testing the Transactions were recorded
		instance.input("DEPOSIT");
		Command cmd = new Command("DEPOSIT");
		instance.createTransaction(cmd, 100);
		instance.input("PRINT");
		instance.printTransaction(null);
		instance.input("HOME");
		cmd = new Command("HOME");
		instance.input("DEPOSIT");
		cmd = new Command("DEPOSIT");
		instance.createTransaction(cmd, 90);
		instance.input("HOME");
		cmd = new Command("HOME");
		instance.input("WITHDRAWL");
		cmd = new Command("WITHDRAWL");
		instance.createTransaction(cmd, 200);
		instance.input("PRINT");
		cmd = new Command("PRINT");
		instance.printTransaction(null);
		assertEquals("Rose", instance.getCurr().getFirst());
		assertEquals(3, instance.getCurr().getActivities().size());

		// testing the amt comparator
		instance.printTransaction(new amountComparator());
		assertEquals(Double.valueOf(490), Double.valueOf(login.getBalance()));
		assertTrue(0 == instance.getCurr().getAcctNum());

		// testing creating a new user
		instance.createUser("Linda", "Xiao", "linda@email", "9998887777", 750, "5123");
		instance.logout();
		instance.login("Linda", "Xiao", "5123");
		assertTrue(1 == instance.getAcctNum());

	}
}
