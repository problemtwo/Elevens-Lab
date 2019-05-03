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
		Card temp;
		int r;
		for(int k = this.size() - 1; k >= 0; k--) {
			r = (int)(Math.random() * (k + 1));
			temp = this.cards.get(k);
			this.cards.set(k,this.cards.get(r));
			this.cards.set(r,temp);
		}
		this.size = this.cards.size();
	}

	public boolean isEmpty() { return this.size() == 0; }
	public int size() { return this.size; }
	public Card deal() {
		if(size - 1 < 0) { return null; }
		return cards.get((size--) - 1);
	}

	@Override
		public String toString() {
			String rtn = "size = " + size + "\nUndealt cards: \n";

			for (int k = size - 1; k >= 0; k--) {
				rtn = rtn + cards.get(k);
				if (k != 0) {
					rtn = rtn + ", ";
				}
				if ((size - k) % 2 == 0) {
					// Insert carriage returns so entire deck is visible on console.
					rtn = rtn + "\n";
				}
			}

			rtn = rtn + "\nDealt cards: \n";
			for (int k = cards.size() - 1; k >= size; k--) {
				rtn = rtn + cards.get(k);
				if (k != size) {
					rtn = rtn + ", ";
				}
				if ((k - cards.size()) % 2 == 0) {
					// Insert carriage returns so entire deck is visible on console.
					rtn = rtn + "\n";
				}
			}

			rtn = rtn + "\n";
			return rtn;
		}
}
