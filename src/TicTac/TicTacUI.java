package TicTac;

import java.util.Scanner;

public class TicTacUI {
	static Scanner in = new Scanner(System.in);
	static TicTacToe t;

	public static void gameplay() {
		boolean quit = false;

		boolean invalid = true;

		do {
			System.out.println("Tic Tac Toe");
			System.out.println("Player One's name: ");
			String userO = in.next();
			System.out.println("Player One's symbol: ");
			char charO = in.next().charAt(0);
			System.out.println("Player Two's name: ");
			String userT = in.next();
			System.out.println("Player Two's symbol: ");
			char charT = in.next().charAt(0);

			try {
				t = new TicTacToe(userO, userT, charO, charT);
				invalid = false;

			} catch (IllegalArgumentException e) {
				System.out.println("Invalid arguments. Try again.");
			}

		} while (invalid);

		while (!quit) {
			System.out.println("Game begins!");
			t.display();

			boolean flag = repeat(t);

			if (flag) {
				System.out.println("Player " + t.winner().getName() + " wins!");
			}
			else {
				System.out.println("A tie!");
			}

			System.out.println("Play again? yes/no");
			String verdict = in.next();
			if (verdict.equalsIgnoreCase("no")) {

				t.printResults();
				quit = true;
			}
			t.newGame();
			t.swap();

		}
		System.out.println("See you next time!");
	}

	public static boolean repeat(TicTacToe temp) {
		boolean over = false;
		while (!over) {

			System.out.println("Player " + temp.getUser().getName() + " enter your move(row column):");
			int row = in.nextInt();
			int col = in.nextInt();
			int m = temp.move(row, col);

			boolean valid = false;
			while (!valid) {
				if (m == -1) {
					System.out.println("Invalid move. Try again.");
					System.out.println("Player " + temp.getUser().getName() + " enter your move(row column):");
					row = in.nextInt();
					col = in.nextInt();
					m = temp.move(row, col);
				}

				else {
					valid = true;
				}
			}
			temp.display();
			if (temp.getGameOver()) {
				return true;
			}
			temp.swap();
			if (temp.tie()) {
				break;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		gameplay();

	}
}
