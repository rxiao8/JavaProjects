package ATM.ATMTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ATM.Command;
import ATM.State;

public class StateTest {
	private State temp;
	private Command cmd;
	private String h = "HOME";
	private String w = "WITHDRAWL";
	private String d = "DEPOSIT";
	private String c = "CHECK";
	private String p = "PRINT";

	public StateTest() {
		temp = new State();
		cmd = null;
	}

	@Test
	public void testTransition() {
		// Test transitioning from Home
		assertEquals(h, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// testing to transition to itself
		cmd = new Command(h);
		try {
			temp.update(cmd);
		} catch (IllegalAccessError e) {
			assertEquals("Invalid transition.", e.getLocalizedMessage());
		}
		// h->w
		cmd = new Command(w);
		temp.update(cmd);
		assertEquals(w, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// w->h
		cmd = new Command(h);
		temp.update(cmd);
		assertEquals(h, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// h->d
		cmd = new Command(d);
		temp.update(cmd);
		assertEquals(d, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// d->p
		cmd = new Command(p);
		temp.update(cmd);
		assertEquals(p, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(d, temp.getStateName());

		// p->h
		cmd = new Command(h);
		temp.update(cmd);
		assertEquals(h, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// h->c
		cmd = new Command(c);
		temp.update(cmd);
		assertEquals(c, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// c->h
		cmd = new Command(h);
		temp.update(cmd);
		assertEquals(h, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// h->c
		cmd = new Command(c);
		temp.update(cmd);
		assertEquals(c, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// c->h
		cmd = new Command(h);
		temp.update(cmd);
		assertEquals(h, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(w, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

		// c->w
		cmd = new Command(w);
		temp.update(cmd);
		assertEquals(w, temp.getStateName());
		assertNotEquals(d, temp.getStateName());
		assertNotEquals(h, temp.getStateName());
		assertNotEquals(c, temp.getStateName());
		assertNotEquals(p, temp.getStateName());

	}
}
