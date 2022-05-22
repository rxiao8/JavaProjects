package ATM.ATMcomparators;

import java.util.Comparator;

import ATM.Transaction;

public class amountComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction o1, Transaction o2) {
		if (o1.getAmount() < o2.getAmount()) {
			return -1;
		}
		if (o1.getAmount() > o2.getAmount()) {
			return 1;
		}
		else {
			timeDateComparator t = new timeDateComparator();
			return t.compare(o1, o2);
		}
	}

}
