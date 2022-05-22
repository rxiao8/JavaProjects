package TicTac;

import java.util.Formatter;

/**
 * Making a quick TicTacToe game
 * 
 * @author Rozie
 */
public class TicTacToe {
	/**
	 * user interface click play game User1 selects symbol and User2 selects
	 * symbol,, select the desired dimensions and the console outputs an empty
	 * matrix (3x3 or 5x5) User takes turn inputting their symbol,, receving error
	 * messages if their input is not their symbol or not within bounds or taken
	 * Winner if diagonally,, vertically,, or horizontally matches Can choose to
	 * keep track of the wins between same players or restart the board
	 */

	/**
	 * GUI/UI displays the messages,, matrix,, and scores
	 */
	/**
	 * Input and Output deals with reading in user's input and checking for
	 * exceptions
	 */
	/**
	 * Game Board 2D array
	 */
	/**
	 * Score History keeps track of the scoreboard
	 */
	private GameBoard board;

	private User one;
	private User two;
	private User curr;

	private boolean gameOver = false;

	public TicTacToe(String user1, String user2, char symb1, char symb2) throws IllegalArgumentException {
		board = new GameBoard();

		if (user1.equalsIgnoreCase(user2) || symb1 == symb2) {
			throw new IllegalArgumentException();
		}
		one = new User(user1, symb1);
		two = new User(user2, symb2);
		curr = one;

	}

	public void display() {
		for (int i = 0; i < board.getSize(); i++) {

			for (int k = 0; k < board.getSize(); k++) {
				if (k == board.getSize() - 1) {
					System.out.print(board.getBoard()[i][k]);
					;
				}
				else {
					System.out.print(board.getBoard()[i][k] + "|");
				}
			}
			System.out.print("\n");
			if (i == board.getSize() - 1) {
				continue;
			}
			System.out.print("-----\n");
		}
		System.out.println("");
	}

	public int move(int a, int b) {
		int num = board.markIntBoard(a, b, curr);
		return num;
	}

	public void swap() {
		if (curr.equals(one)) {
			curr = two;
		}
		else {
			curr = one;
		}
	}

	public User getUser() {
		return curr;
	}

	public boolean tie() {
		if (board.getCt() == board.getSize() * board.getSize()) {
			return true;
		}
		return false;
	}

	public User winner() {
		int currCt = curr.getWinCt();
		currCt++;
		curr.setWinCt(currCt);
		return curr;
	}

	public boolean getGameOver() {
		if (board.winnerCheck(curr)) {
			int wins = curr.getWinCt();
			curr.setWinCt(wins++);
			gameOver = true;
		}
		return gameOver;
	}

	public void printResults() {

		StringBuilder builder = new StringBuilder("Score Board:\n");

		Formatter format = new Formatter();
		// this is repeating twice for some reason
		format.format("Player here %s\n" + "Wins: %d\n", one.getName(), one.getWinCt());
		builder.append(format);
		format.format("Player %s\n" + "Wins: %d\n", two.getName(), two.getWinCt());
		builder.append(format);
		format.close();
		System.out.println(builder);

	}

	public void newGame() {
		gameOver = false;
		board.clearBoard();
	}

}
