package ATM.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ATM.Database;
import ATM.ATMManager;
import ATM.User;

public class DatabaseIO {
	public static void readData(Database data, String filename) throws IllegalArgumentException {
		Scanner in;
		try {
			in = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File does not exist.");
		}
		in.useDelimiter("\n");
		while (in.hasNext()) {
			data.addUser(tokens(in.next()));

		}
	}

	private static User tokens(String token) {
		User u = null;
		String[] arr = token.split(",");
		if (arr.length != 5) {
			throw new IllegalArgumentException();
		}
		u = new User(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]), ATMManager.getNum());
		return u;
	}
}
