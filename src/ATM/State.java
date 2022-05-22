package ATM;

import ATM.Command.Stage;

public class State {
	/** Keeps track of the current ATM state */
	private StateInterface curr;
	/** Home state object */
	private StateInterface home = new Home();
	/** Withdrawl state object */
	private StateInterface withdrawl = new Withdrawl();
	/** Deposit state object */
	private StateInterface deposit = new Deposit();
	/** Check state object */
	private StateInterface check = new Check();
	/** Print state object */
	private StateInterface print = new Print();
	/** The User's input */
	private Command cmd;

	public State() {
		curr = home;
		cmd = null;
	}

	/** Returns the current state name */
	public String getStateName() {
		return curr.getStateName();
	}

	/**
	 * @param type2 the type to set
	 */
	public void update(Command c) {
		cmd = c;
		curr.update();
	}

	/** Retrieves the current state */
	public StateInterface getState() {
		return curr;
	}

	/**
	 * The Home state of the ATM
	 * 
	 * @author Rozie
	 */
	private class Home implements StateInterface {
		// can go to w, d, c, p
		private String stateName = "HOME";
		private Stage stage = Command.Stage.HOME;

		@Override
		public void update() {
			if (cmd.getVal().equals(stage)) {
				throw new IllegalAccessError("Invalid transition.");
			}
			if (cmd.getVal() == Command.Stage.WITHDRAWL) {
				curr = withdrawl;
			}
			else if (cmd.getVal() == Command.Stage.DEPOSIT) {
				curr = deposit;
			}
			else if (cmd.getVal() == Command.Stage.CHECK) {
				curr = check;
			}
			else {
				curr = print;
			}
		}

		@Override
		public String getStateName() {
			return stateName;
		}

	}

	/**
	 * The Withdrawl state of the ATM
	 * 
	 * @author Rozie
	 */
	private class Withdrawl implements StateInterface {
		// can go to c, p, h
		private String stateName = "WITHDRAWL";
		private Stage stage = Command.Stage.WITHDRAWL;

		@Override
		public void update() {
			if (cmd.getVal().equals(stage)) {
				throw new IllegalAccessError("Invalid transition.");
			}
			else if (cmd.getVal() == Command.Stage.HOME) {
				curr = home;
			}
			else if (cmd.getVal() == Command.Stage.DEPOSIT) {
				throw new IllegalAccessError("Invalid transition.");
			}
			else if (cmd.getVal() == Command.Stage.CHECK) {
				curr = check;
			}
			else {
				curr = print;
			}

		}

		@Override
		public String getStateName() {
			return stateName;
		}

	}

	/**
	 * The Deposit state of the ATM
	 * 
	 * @author Rozie
	 */
	private class Deposit implements StateInterface {
		// can go to c, p, h. Must go to h before w
		private String stateName = "DEPOSIT";
		private Stage stage = Command.Stage.DEPOSIT;

		@Override
		public void update() {
			if (cmd.getVal().equals(stage)) {
				throw new IllegalAccessError("Invalid transition.");
			}
			else if (cmd.getVal() == Command.Stage.HOME) {
				curr = home;
			}
			else if (cmd.getVal() == Command.Stage.WITHDRAWL) {
				throw new IllegalAccessError("Invalid transition.");
			}
			else if (cmd.getVal() == Command.Stage.CHECK) {
				curr = check;
			}
			else {
				curr = print;
			}

		}

		@Override
		public String getStateName() {
			return stateName;
		}

	}

	/**
	 * The Check state of the ATM
	 * 
	 * @author Rozie
	 */
	private class Check implements StateInterface {
		// can go to w, c, p, h
		private String stateName = "CHECK";
		private Stage stage = Command.Stage.CHECK;

		@Override
		public void update() {
			if (cmd.getVal().equals(stage)) {
				throw new IllegalAccessError("Invalid transition.");
			}
			else if (cmd.getVal() == Command.Stage.HOME) {
				curr = home;
			}
			else if (cmd.getVal() == Command.Stage.WITHDRAWL) {
				curr = withdrawl;
			}
			else if (cmd.getVal() == Command.Stage.DEPOSIT) {
				curr = deposit;
			}
			else {
				curr = print;
			}

		}

		@Override
		public String getStateName() {
			return stateName;
		}

	}

	/**
	 * The Print state of the ATM
	 * 
	 * @author Rozie
	 */
	private class Print implements StateInterface {
		// can go to h
		private String stateName = "PRINT";
		private Stage stage = Command.Stage.PRINT;

		@Override
		public void update() {
			if (cmd.getVal().equals(stage)) {
				throw new IllegalAccessError("Invalid transition.");
			}
			if (cmd.getVal() == Command.Stage.WITHDRAWL || cmd.getVal() == Command.Stage.DEPOSIT
					|| cmd.getVal() == Command.Stage.CHECK) {
				throw new IllegalAccessError("Invalid transition.");
			}
			if (cmd.getVal() == Command.Stage.HOME) {
				curr = home;
			}
			else {
				curr = print;
				// do printing stuff
			}

		}

		@Override
		public String getStateName() {
			return stateName;
		}

	}

}
