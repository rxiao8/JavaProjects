package ATM.ATMTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ATM.Command;
import ATM.Manager;

public class ManagerTest {
	private Manager instance;

	@Before
	public void setUp() {
		instance = Manager.getInstance();
		instance.clearData();

	}

	@Test
	public void testManager() {
		assertNull(instance.login("Rose", "Xiao"));
		instance.createUser("Rose", "Xiao", "rose@email", "6669994420", 500);
		assertEquals("Rose", instance.login("Rose", "Xiao").getFirst());
		assertTrue(1 == instance.getSize());

		instance.input("DEPOSIT");
		Command cmd = new Command("DEPOSIT");
		instance.createTransaction(cmd, 100);
		instance.input("PRINT");

		// not printing out the rest of the stuff
		instance.printTransaction(null);
		cmd = new Command("HOME");
		cmd = new Command("DEPOSIT");
		instance.createTransaction(cmd, 90);
		cmd = new Command("HOME");
		cmd = new Command("WITHDRAWL");
		instance.createTransaction(cmd, 30);
		cmd = new Command("PRINT");
		instance.printTransaction(null);
	}
}
