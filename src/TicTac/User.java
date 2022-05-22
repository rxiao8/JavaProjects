package TicTac;

/**
 * Contains the basic information of each player
 * 
 * @author Rozie
 */
public class User {
	private int winCt;
	private String name;
	private char symbol;

	public User(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
		setWinCt(0);
	}

	/**
	 * @return the winCt
	 */
	public int getWinCt() {
		return winCt;
	}

	/**
	 * @param winCt the winCt to set
	 */
	public void setWinCt(int winCt) {
		this.winCt = winCt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}
