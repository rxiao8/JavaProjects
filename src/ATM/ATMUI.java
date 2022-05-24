package ATM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ATM.ATMcomparators.amountComparator;

public class ATMUI {
	static ATMManager atm = ATMManager.getInstance();

	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		while (!valid) {
			System.out.println("Please enter your first and last name:");
			String name = in.nextLine();
			String[] arr = name.split(" ");

			// Regular Expression. Found example on JavaTutorials
			String regex = "[a-zA-Z]";
			// Compile regular expression to get the pattern
			Pattern patternN = Pattern.compile(regex);

			Matcher matcherFirst = patternN.matcher(arr[0]);
			Matcher matcherLast = patternN.matcher(arr[1]);

			// checks if the name only consist of letters
			if ((!(matcherFirst.matches() && matcherLast.matches())) || arr.length != 2) {
				System.out.println("Invalid name format. Try again.");
			}
			else {
				System.out.println("Please enter your pin.");
				String pin = in.next();
				String regexPin = "[0-9]{4}";

				Pattern patternP = Pattern.compile(regexPin);

				Matcher matcherPin = patternP.matcher(pin);
				if (!matcherPin.matches()) {
					System.out.println("Invalid pin format. Try again.");
				}
				else {
					if (!atm.login(arr[0], arr[1], pin)) {
						System.out.println("User does not exist.");
					}
					else {
						System.out.println("Logged in.");
						valid = true;
					}
				}
			}
		}

		// logged in. Show the options.
		boolean quit = false;
		while (!quit) {
			System.out.println("Enter the number next to the action to execute.");
			System.out.println("1. Withdraw\n 2. Deposit\n 3. Check Balance\n 4. Print Statements\n 5. Quit");
			int input = in.nextInt();
			if (input > 5 || input < 0) {
				System.out.println("Invalid option. Try again.");
			}
			else {
				// loop through the state as the user
				boolean loop = true;
				while (loop) {
					switch (input) {
					case 1:
						atm.input("WITHDRAWL");
						System.out.println("Enter the amount to widthdraw: ");
						double amt = in.nextDouble();
						boolean flagW = atm.createTransaction(null, amt);
						if (!flagW) {
							System.out.println("Error. Withdraw amount selected was higher than balance.");
						}
						System.out.println("3. Check Balance\n 4. Print Statements\n 5. Home");
						break;
					case 2:
						atm.input("DEPOSIT");
						System.out.println("Enter the amount to deposit: ");
						double amtD = in.nextDouble();
						boolean flagD = atm.createTransaction(null, amtD);
						System.out.println("3. Check Balance\n 4. Print Statements\n 5. Home");
						break;
					case 3:
						atm.input("CHECK");
						System.out.println(atm.getCurr().getBalance());
						break;
					case 4:
						atm.input("PRINT");
						System.out.println("1. Sort by recent\n 2. Sort by transaction amount\n");
						int answer = in.nextInt();
						if (answer == 1) {
							atm.printTransaction(null);
						}
						else {
							atm.printTransaction(new amountComparator());
						}
						System.out.println("5. Home\n 6. Quit");
						break;
					case 5:
						atm.input("HOME");
						loop = false;
					case 6:
						atm.input("HOME");
						System.out.println("Have a day!");
						loop = false;
						quit = true;
						break;
					}
				}
			}

		}
		in.close();
	}

}
