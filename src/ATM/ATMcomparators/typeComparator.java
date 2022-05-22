package ATM.ATMcomparators;

import java.util.Comparator;

import ATM.Transaction;

public class typeComparator implements Comparator<Transaction> {

	/**
	 * Compares the Transaction by the type,, and if equal,, then sorts them by
	 * their timestamp
	 */
	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getType().compareTo(o2.getType()) > 0) {
			return 1;
		}
		else if (o1.getType().compareTo(o2.getType()) < 0) {
			return -1;
		}
		else {
			timeDateComparator t = new timeDateComparator();
			return t.compare(o1, o2);
		}
	}

}
