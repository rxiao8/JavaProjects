package ATM;

/**
 * Command object based on the user's input
 * 
 * @author Rozie
 */
public class Command {
	/** String for the command */
	private String cmd;
	/** The Stage type */
	private Stage type;

	/** Inits a new Command object */
	public Command(String cmd) {
		this.cmd = cmd;
		setCMDVal();
	}

	public enum Stage {
		HOME, WITHDRAWL, DEPOSIT, CHECK, PRINT
	}

	/** Returns the command string */
	public String getCMD() {
		return cmd;
	}

	/** Returns the Stage type */
	public Stage getVal() {
		return type;
	}

	/**
	 * Sets the Stage value for the command
	 */
	public void setCMDVal() {
		switch (cmd) {
		case "HOME":
			type = Stage.HOME;
			break;
		case "WITHDRAWL":
			type = Stage.WITHDRAWL;
			break;
		case "DEPOSIT":
			type = Stage.DEPOSIT;
			break;
		case "CHECK":
			type = Stage.CHECK;
			break;
		case "PRINT":
			type = Stage.PRINT;
			break;
		}
	}
}
