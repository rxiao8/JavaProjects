package TicTac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
	private TicTacToe game;
	private String userO = "One";
	private String userT = "Two";
	private char one = 'O';
	private char two = 'T';

	@Before
	public void setUp() {
		game = new TicTacToe(userT, userO, one, two);
		game.display();
		game.printResults();

	}

	/**
	 * make moves,, checks for winners,, prints results
	 */
	@Test
	public void moveBoard() {
		assertFalse(game.getGameOver());
		assertFalse(game.tie());
		game.move(0, 0);
		game.move(2, 1);
		game.move(1, 1);
		game.move(1, 2);
		game.move(2, 2);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("One", game.winner().getName());

	}

	@Test
	public void clearBoard() {
		assertFalse(game.getGameOver());
		assertFalse(game.tie());
		game.move(0, 0);
		game.move(2, 1);
		game.move(1, 1);
		game.move(1, 2);
		game.move(2, 2);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("One", game.winner().getName());
		game.printResults();

		game.newGame();
		assertFalse(game.getGameOver());
		assertFalse(game.tie());

	}

	@Test
	public void repeat() {
		assertFalse(game.getGameOver());
		assertFalse(game.tie());
		game.move(0, 0);
		game.move(2, 1);
		game.move(1, 1);
		game.move(1, 2);
		game.move(2, 2);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("One", game.winner().getName());

		game.newGame();
		game.move(1, 0);
		game.move(0, 0);
		game.move(1, 1);
		game.move(2, 1);
		game.move(1, 2);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("One", game.winner().getName());

		game.newGame();
		game.move(1, 2);
		game.move(1, 1);
		game.move(0, 2);
		game.move(2, 1);
		game.move(2, 2);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("One", game.winner().getName());

		game.newGame();
		game.move(1, 2);
		game.move(1, 1);
		game.move(0, 2);
		game.move(2, 2);
		game.move(0, 1);
		game.move(0, 0);

		game.display();
		assertTrue(game.getGameOver());
		assertFalse(game.tie());
		assertEquals("Two", game.winner().getName());
		game.printResults();

		game.newGame();
		game.move(1, 2);
		game.move(0, 0);
		game.move(1, 0);
		game.move(1, 1);
		game.move(2, 2);
		game.move(0, 2);
		game.move(2, 0);
		game.move(2, 1);
		game.move(0, 1);

		game.display();
		assertTrue(game.getGameOver());
		assertTrue(game.tie());
		game.printResults();

	}
}
