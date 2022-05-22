package ATM.ATMcomparators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 * 
 * @author     Dr. King
 * @param  <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class mergeSorter<E extends Comparable<E>> {

	/** The comparator to be used during sorting */
	private Comparator<E> comparator;

	/**
	 * Constructs a new MergeSorter with a specified custom Comparator
	 * 
	 * @param comparator a custom Comparator to use when sorting
	 */
	public mergeSorter(Comparator<E> comparator) {
		if (comparator == null) {
			this.comparator = new NaturalOrder();
		}
		else {
			this.comparator = comparator;
		}
	}

	/**
	 * Constructs a new MergeSorter with comparisons based on the element's natural
	 * ordering
	 */
	public mergeSorter() {
		this(null);
	}

	public void sort(E[] data) {
		// if n < 2 then
		// return T

		if (data.length < 2) {
			return;
		}

		// mid <-- n/2
		// left <-- copyArray(T, 0, mid-1);
		// right <-- copyArray(T, mid, n-1);

		int mid = (int) Math.floor(data.length / 2);
		E[] leftArr = Arrays.copyOfRange(data, 0, mid);
		// for (int i = 0; i < leftArr.length; i++) {
		// System.out.println(leftArr[i].toString());
		// }
		E[] rightArr = Arrays.copyOfRange(data, mid, data.length);

		// mergeSort(left)
		// mergeSort(right)

		sort(leftArr);
		sort(rightArr);
		// merge(left, right, T)

		merge(leftArr, rightArr, data);
	}

	/**
	 * Merges the different sub arrays of the passed array in sorted order using the
	 * merging algorithm.
	 * 
	 * @param lArr the left array
	 * @param rArr the right array
	 * @param data the original array
	 */
	public void merge(E[] lArr, E[] rArr, E[] data) {
		//
		// leftIndex <-- 0
		// rightIndex <-- 0
		int leftIndex = 0;
		int rightIndex = 0;
		// while leftIndex + rightIndex < n do

		while (leftIndex + rightIndex < data.length) {
			// if rightIndex = length(right) OR ( leftIndex < length(left) AND //
			// left[leftIndex] < right[rightIndex] ) then

			if ((rightIndex == rArr.length)
					|| (leftIndex < lArr.length) && (compare(lArr[leftIndex], rArr[rightIndex]) < 0)) {
				data[leftIndex + rightIndex] = lArr[leftIndex];
				leftIndex++;
			}

			else {
				data[leftIndex + rightIndex] = rArr[rightIndex];
				// rightIndex = rightIndex + 1;
				rightIndex++;
			}
		}

	}

	/**
	 * An ordering defined by implementing the compareTo(E other) method in the
	 * Comparable interface.
	 */
	private class NaturalOrder implements Comparator<E> {
		/**
		 * Compares the two parameters and delegates to the Comparable's compareTo
		 * method.
		 * 
		 * @param  first  the first Object to compare
		 * @param  second the second Object to compare
		 * @return        an integer value based on the following rules: negatvie values
		 *                    if first comes before second, positive values if first
		 *                    comes after, and 0 if the two parameters are equal.
		 */
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}

	/**
	 * Comparing the sorting the elements based on the comparator called. This can
	 * be either natural ordering or a custom sorting.
	 * 
	 * @param  data1 one element being compared
	 * @param  data2 second element being compared with
	 * @return       an integer based on whether the first parameter comes before,
	 *                   after, or is equal to the second parameter
	 */
	public int compare(E data1, E data2) {
		return comparator.compare(data1, data2);
	}

}
