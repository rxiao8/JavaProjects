package TicTac;

public class GameBoard {

	private char[][] board;
	private final int SIZE = 3;
	private int count;

	public GameBoard() {
		count = 0;
		board = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = ' ';
			}
		}

	}

	/**
	 * @return the markedBoard
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * Return board size
	 * 
	 * @return
	 */
	public int getSize() {
		return SIZE;
	}

	public int getCt() {
		return count;
	}

	/**
	 * makes a new board and reset everything
	 */
	public void clearBoard() {
		count = 0;
		board = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = ' ';
			}
		}

	}

	/**
	 * marks the board with ints
	 * 
	 * @return 1 if successful,, -1 if not,, 0 if already marked
	 */
	public int markIntBoard(int row, int col, User u) {
		if (row >= SIZE || col >= SIZE) {
			return -1;
		}
		if (board[row][col] != ' ') {
			return -1;
		}
		board[row][col] = u.getSymbol();
		count++;
		return 1;
	}

	/**
	 * checks for winner
	 */
	public boolean winnerCheck(User u) {
		char letter = u.getSymbol();
		for (int i = 0; i < SIZE; i++) {
			if (board[i][0] == letter && board[i][1] == letter && board[i][2] == letter) {
				return true;
			}
		}
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[0][j] == letter && board[1][j] == letter && board[2][j] == letter) {
					return true;
				}
			}
		}
		if (board[0][0] == letter && board[1][1] == letter && board[2][2] == letter) {
			return true;
		}
		if (board[0][2] == letter && board[1][1] == letter && board[2][0] == letter) {
			return true;
		}
		return false;
	}

}
