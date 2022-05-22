package ATM.ATMcomparators;

import java.util.Comparator;

import ATM.Transaction;

public class timeDateComparator implements Comparator<Transaction> {

	/**
	 * Compares the Transactions based on their time and date.
	 */
	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getTimeDate().compareTo(o2.getTimeDate()) < 0) {
			return -1;
		}
		if (o1.getTimeDate().compareTo(o2.getTimeDate()) < 0) {
			return 1;
		}
		return 0;
	}

}
