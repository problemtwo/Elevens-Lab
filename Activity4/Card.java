public class Card {
	private String rank;
	private String suit;
	private int pointValue;

	public Card(String rank, String suit, int pointValue) {
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}

	public String getRank() { return this.rank; }
	public String getSuit() { return this.suit; }

	public int getPointValue() {
		return this.pointValue;
	}

	public boolean matches(Card other) {
		return other.getRank().equals(this.getRank()) && other.getSuit().equals(this.getSuit()) &&
		       other.getPointValue() == this.getPointValue();
	}

	@Override
	public String toString() {
		return this.getRank() + " of " + this.getSuit() + " (point value = " +
		       String.valueOf(this.getPointValue()) + ")";
	}
}
