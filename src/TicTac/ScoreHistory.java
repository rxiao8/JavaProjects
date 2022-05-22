package TicTac;

import java.io.IOException;
import java.util.Formatter;

public class ScoreHistory {

	public static void printResults(User user1, User user2) throws IOException {
		// File file = new File(filename);
		// file.getParentFile().mkdirs();
		// file.createNewFile();
		//
		// FileWriter writer = new FileWriter(file);
		StringBuilder builder = new StringBuilder("Score Board:\n");

		Formatter format = new Formatter();
		format.format("Player One: %s\n" + "Wins: %d\n", user1.getName(), user1.getWinCt());
		builder.append(format);
		format.format("Player Two: %s\n" + "Wins: %d\n", user2.getName(), user2.getWinCt());
		builder.append(format);
		format.close();
		System.out.println(builder);
		// writer.append(builder);
		// writer.close();
	}

}
