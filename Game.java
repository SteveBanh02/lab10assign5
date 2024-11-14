import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println(
            """
            Welcome to the card game of War!

            The player has to satisfy one of the following conditions:
                - The player must successfully guess the card that they picked
                - If the player picks a joker, they automatically wins
            The player has 5 rounds to win. 
                    """
        );

        Deck cardDeck = new Deck();

        boolean win = false;
        for(int round = 0; round < 5; round++){
            //cardDeck.shuffle();

            System.out.println("Please guess a card (except the joker cards), mentioning the value first, and then the suit.");
            String cardGuess = input.nextLine();

            System.out.println("Please pick a card from the deck. Enter a number between 0-53.");
            int pickCard = input.nextInt();
            System.out.println("You have picked " + cardDeck.dealCard(pickCard));

            input.nextLine();

            String cardPicked = String.valueOf(cardDeck.dealCard(pickCard));
            
            if(cardGuess.equalsIgnoreCase(cardPicked)){
                System.out.println("Congradulation, you won! You picked your guessed card.");
                win = true;
                break;
            }else if(cardPicked.equalsIgnoreCase("\"1\" of joker") || cardPicked.equalsIgnoreCase("\"2\" of joker")){
                System.out.println("Congradulation, you won! You picked a joker card.");
                win = true;
                break;
            }else{
                if(round < 4){
                    System.out.println("Try again");
                }
            }
        }
        if(!win){
             System.out.println("You lost the game.");
        }
    }
}