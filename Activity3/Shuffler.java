public class Shuffler {
	private static final int SHUFFLE_COUNT = 5;
	private static final int VALUE_COUNT = 10;

	public static void main(String[] args) {
		int[] values1 = new int[VALUE_COUNT];
		int[] values2 = new int[VALUE_COUNT];
		for(int i=0;i<VALUE_COUNT;i++) {
			values1[i] = i;
			values2[i] = i;
		}

		System.out.println("Perfect Shuffle");

		for(int i=0;i<SHUFFLE_COUNT;i++) {
			perfectShuffle(values1);
			System.out.print("iteration " + String.valueOf(i) + ": ");
			for(int j=0;j<VALUE_COUNT;j++) {
				System.out.print(String.valueOf(values1[j]) + " ");
			}
			System.out.println();
		}

		System.out.println("Selection Shuffle");

		for(int i=0;i<SHUFFLE_COUNT;i++) {
			selectionShuffle(values2);
			System.out.print("iteration " + String.valueOf(i) + ": ");
			for(int j=0;j<VALUE_COUNT;j++) {
				System.out.print(String.valueOf(values2[j]) + " ");
			}
			System.out.println();
		}
	}

	public static String flip() {
		if(Math.random() <= (1.0/3.0)) {
			return "tails";
		}
		return "heads";
	}

	public static boolean arePermutations(int[] a, int[] b) {
		outerloop: for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i] === b[j]) { continue outerloop; }
			}
			return false;
		}
		return true;
	}

	public static void perfectShuffle(int[] values) {
		if(values.length < 2) { return; }
		int[] nwValues = new int[values.length];
		int pivot = values.length / 2;
		int j = 0;
		int k = 0;
		for(int i=0;i<values.length;i++) {
			if(i % 2 == 0) {
				nwValues[i] = values[j++];
			}
			else {
				nwValues[i] = values[pivot + k++];
			}
		}
		for(int i=0;i<values.length;i++) {
			values[i] = nwValues[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
			for( int k = VALUE_COUNT - 1; k >= 0; k-- ) {
					int r = (int)(Math.random() * k);
					int tmp = values[r];
					values[r] = values[k];
					values[k] = tmp;
			}
	}
}
