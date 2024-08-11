package playground;

public class Card {

	private int number;
	private String suite;

	public Card(int number, String suite) {
		this.number = number;
		this.suite = suite;
	}

	public int getNumber() {
		return number;
	}

	public String getSuite() {
		return suite;
	}
}
