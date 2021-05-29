package nz.ac.auckland.se754.web.service.CardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private boolean deckEmpty = false;
    public Deck(){
        deck = new ArrayList<Card>();
    }
    public Deck(int noPlayers){
        deck = new ArrayList<Card>();
        int numberOfDecks = (noPlayers/7) + 1;
        for(int i =0; i<numberOfDecks; i++){
            for(int suit = 0; suit < 4; suit++){
                for(int value = 0; value< 13; value++){
                    deck.add(new Card(suit, value));
                }
            }
        }
        shuffleDeck();

    }
    public Card getTopCard(){
        int cardLocation = deck.size()-1;
        Card topCard = deck.get(cardLocation);
        return topCard;
    }

    public Card pullTopCard(){
        int cardLocation = deck.size()-1;
        Card topCard = getTopCard();
        deck.remove(cardLocation);
        if(deck.size() == 0) {
            this.deckEmpty = true;
        }

        return topCard;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    public boolean getDeckEmpty(){
        return this.deckEmpty;
    }
    public void refreshDeck(PlacedDeck placedDeck){
        if(this.getDeckEmpty()){
            while(placedDeck.getPlacedDeck().size() != 1){
                this.deck.add(placedDeck.getPlacedDeck().get(0));
                placedDeck.getPlacedDeck().remove(0);
            }
            this.deckEmpty = false;
            shuffleDeck();
        }

    }
}
