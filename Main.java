package assignment_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create a new deck");
            System.out.println("2. Print a card");
            System.out.println("3. Print the entire deck");
            System.out.println("4. Check if two cards are the same");
            System.out.println("5. Compare two cards");
            System.out.println("6. Sort the deck");
            System.out.println("7. Find a card in the deck");
            System.out.println("8. Deal 5 random cards");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    deck.createDeck();
                    break;
                case 2:
                    deck.printCard();
                    break;
                case 3:
                    deck.printDeck();
                    break;
                case 4:
                    deck.sameCard();
                    break;
                case 5:
                    deck.compareCard();
                    break;
                case 6:
                    deck.sortDeck();
                    break;
                case 7:
                    deck.findCard();
                    break;
                case 8:
                    deck.dealCards();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
