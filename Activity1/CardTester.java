public class CardTester {
	public static void main(String[] args) {
		Card a = new Card("Heart","4",4);
		Card b = new Card("Heart","7",7);
		Card c = new Card("Heart","7",7);
		System.out.println(c.toString());
		System.out.println("A and B do NOT match: " + String.valueOf(!a.equals(b)));
		System.out.println("B and C DO match: " + String.valueOf(b.equals(c)));
	}
}
