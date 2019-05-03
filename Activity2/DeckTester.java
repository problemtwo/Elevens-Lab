public class DeckTester {
	public static void main(String[] args) {
		String[] ranks = {"1","2","3","4","5"};
		String[] suits = {"Club","Heart","Diamond","Spade"};
		int[] pointValues = {1,2,3,4,5};
		Deck d = new Deck(ranks,suits,pointValues);
		// Should never raise a NullPointerException.
		while(!d.isEmpty()) {
			System.out.println(d.deal().toString());
		}
	}
}
