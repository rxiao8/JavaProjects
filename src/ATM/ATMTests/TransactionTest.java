package ATM.ATMTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ATM.Command;
import ATM.Transaction;

public class TransactionTest {
	private Transaction act;
	private Command cmd = new Command("HOME");

	public TransactionTest() {
		act = new Transaction(cmd, 100);
	}

	@Test
	public void testVal() {
		assertEquals(ATM.Command.Stage.HOME, (Command.Stage) act.getType());
		assertTrue(100.0 == act.getAmount());

	}

}
