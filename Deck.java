package assignment_4;

import java.util.Scanner;
import java.util.Vector;

public class Deck {
    private Vector<Card> cards;

    public Deck() {
        cards = new Vector<Card>(52);
    }

    public void createDeck() {
        cards.clear(); // Clear existing cards if any

        // Populate the deck with cards
        for (int rank = 1; rank <= 13; rank++) {
            for (String suit : Card.suits) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
        System.out.println("Deck created with 52 cards.");
    }

    public void printDeck() {
        System.out.println("Printing deck:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public void printCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the card to print: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index >= 0 && index < cards.size()) {
            System.out.print("Card at index " + index + ": ");
            System.out.println(cards.get(index));
        } else {
            System.out.println("Invalid index.");
        }

        scanner.close();
    }

    public void sortDeck() {
        // Sort the deck
        cards.sort(null);
        System.out.println("Deck sorted.");
    }

    public int findCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter suit (0-3): ");
        int suit = scanner.nextInt();
        System.out.print("Enter rank (1-13): ");
        int rank = scanner.nextInt();
        Card cardToFind = new Card(rank, Card.suits[suit]);

        int index = cards.indexOf(cardToFind);
        if (index != -1) {
            System.out.println("Card found at index " + index + " in the deck.");
        } else {
            System.out.println("Card not found in the deck.");
        }

        scanner.close();
        return index;
    }

    public void dealCards() {
        if (cards.size() < 5) {
            System.out.println("Not enough cards in the deck to deal.");
            return;
        }

        System.out.println("Dealing 5 random cards:");
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * cards.size());
            Card card = cards.get(index);
            System.out.println(card);
            cards.remove(index);
        }
    }

    public void sameCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of the first card:");
        Card card1 = inputCard(scanner);
        System.out.println("Enter details of the second card:");
        Card card2 = inputCard(scanner);
        boolean result = card1.sameCard(card2);
        System.out.println("The two cards are" + (result ? "" : " not") + " the same.");
        scanner.close();
    }

    public void compareCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of the first card:");
        Card card1 = inputCard(scanner);
        System.out.println("Enter details of the second card:");
        Card card2 = inputCard(scanner);
        int result = card1.compareCard(card2);
        if (result < 0)
            System.out.println("Card 1 is lower than Card 2.");
        else if (result > 0)
            System.out.println("Card 1 is higher than Card 2.");
        else
            System.out.println("Both cards are equal.");
        scanner.close();
    }

    private Card inputCard(Scanner scanner) {
        System.out.print("Enter suit (0-3): ");
        int suit = scanner.nextInt();
        System.out.print("Enter rank (1-13): ");
        int rank = scanner.nextInt();
        return new Card(rank, Card.suits[suit]);
    }
}

