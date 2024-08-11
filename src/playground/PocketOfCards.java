package playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PocketOfCards {
	public static void main(String[] args) {
		PocketOfCards pocketOfCards = new PocketOfCards();

		List<Card> cards =
				pocketOfCards.generateCards(List.of(1,2,3), List.of("Hearts", "Diamonds", "Clubs", "Spades"));

		for (Card card : cards) {
			System.out.println(card.getNumber() + " " + card.getSuite());

		}

		Random rand = new Random();
		int mid = cards.size() / 2;
		for (int i = 0; i < mid; i++) {
			int j = mid + rand.nextInt(mid); // random index in the second half
			Card temp = cards.get(i);
			cards.set(i, cards.get(i));
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}

		System.out.println("After shuffle: ");

		for (Card card : cards) {
			System.out.println(card.getNumber() + " " + card.getSuite());
		}

	}

	public List<Card> generateCards(List<Integer> numbers,List<String> suites) {
		List<Card> cards = new ArrayList<>();

		for (Integer number : numbers) {
			for (String suite : suites) {
				cards.add(new Card(number, suite));
			}
		}

		return cards;
	}
}


