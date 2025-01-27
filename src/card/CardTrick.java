//Name: Jashan Sahota
//Student ID: 991726978
//Assignment: ICE1 - CardGame



package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card[] magicHand = new Card[7];
        
        // Generate random cards for the magic hand
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); // Random value between 1-13
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); // Random suit from SUITS array
            magicHand[i] = c;
        }

        // Display the magic hand
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Ask the user for their card
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];

        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for the user's card in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Display the result
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Add the hardcoded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2); // Value: 2
        luckyCard.setSuit(Card.SUITS[2]); // Suit: Clubs

        // Check if the user's card matches the lucky card
        if (userCard.getValue() == luckyCard.getValue() && userCard.getSuit().equals(luckyCard.getSuit())) {
            System.out.println("Congratulations! You found the lucky card: " + luckyCard.getSuit() + " " + luckyCard.getValue());
        }
    }
}
