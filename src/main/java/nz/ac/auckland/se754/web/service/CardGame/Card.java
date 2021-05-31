package nz.ac.auckland.se754.web.service.CardGame;

public class Card {
    // Suit: 0 = Diamond, 1 = Hearts, 2 = Club, 3 = Spade
    private int suit;

    //Ace = 0 - King = 12
    private int value;
    private String wordSuit;
    private String wordValue;
    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
        this.wordSuit=this.getWordSuit();
        this.wordValue=this.getWordValue();
    }

    public int getSuit(){
        return this.suit;
    }
    public String getWordSuit(){
        if(this.getSuit()==0){
            return "Diamonds";
        }
        else if(this.getSuit()==1){
            return "Hearts";
        }
        else if (this.getSuit() == 2){
            return "Clubs";
        }
        else{
            return "Spades";
        }
    }
    public int getValue(){
        return this.value;
    }
    public String getWordValue(){
        int valToString = this.getValue();
        if(valToString > 9|| valToString == 0){
            if(valToString == 0){
                return "Ace";
            }
            else if(valToString==10){
                return "Jack";
            }
            else if(valToString==11){
                return "Queen";
            }
            else{
                return "King";
            }
        }
        else{
            return Integer.toString(this.getValue()+1);
        }
    }

}
