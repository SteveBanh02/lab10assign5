public class Deck {

    //This class is for building our deck of cards
    private Card[] deck;

    //constructors
    public Deck(){
        //created a deck of cards object
        deck = new Card[54];

        //loop to create the deck of cards
        int position = 0; 
        for(int i = 1; i <= 4; i++){
            //create the cards 0-51
            for(int j = 1; j <= 13; j++){
                Card myCard = new Card(i,j);
                deck[position++] = myCard;
            }
            //hard code the cards 52 and 53 for jokers
            deck[52] = new Joker(5,1);
            deck[53] = new Joker(5,2);
        }
    }

    //methods
    public void shuffle(){
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    //returns the card that is at the specified position
    public Card dealCard(int index){
        return deck[index];
    }


    //main for testing
    // public static void main(String[] args) {
    //     Deck myDeck = new Deck();

    //     for(int i = 0; i < myDeck.deck.length; i++){
    //         System.out.println(myDeck.deck[i]);
    //     }
    // }
}