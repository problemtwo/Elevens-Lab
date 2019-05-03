import java.util.List;
import java.util.ArrayList;

public class Deck {
	private List<Card> cards;
	private int size;

	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		this.cards = new ArrayList<Card>();
		for(int i=0;i<suits.length;i++) {
			for(int j=0;j<ranks.length;j++) {
				this.cards.add(new Card(ranks[j],suits[i],pointValues[j]));
			}
		}
		this.size = this.cards.size();

		this.shuffle();
	}

	public void shuffle() {
		/* TODO: Implement in Activity 4 */
	}

	public boolean isEmpty() { return this.size() == 0; }
	public int size() { return this.size; }
	public Card deal() {
		if(size - 1 < 0) { return null; }
		return cards.get((size--) - 1);
	}
}
