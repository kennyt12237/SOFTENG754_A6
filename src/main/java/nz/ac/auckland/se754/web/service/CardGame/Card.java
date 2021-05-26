package nz.ac.auckland.se754.web.service.CardGame;

public class Card {
    // Suit: 0 = Diamond, 1 = Hearts, 2 = Club, 3 = Spade
    private int suit;
    //Ace = 0 - King = 12
    private int value;

    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public int getSuit(){
        return this.suit;
    }
    public int getValue(){
        return this.value;
    }

}
