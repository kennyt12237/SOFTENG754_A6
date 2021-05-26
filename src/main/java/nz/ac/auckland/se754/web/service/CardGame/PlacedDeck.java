package nz.ac.auckland.se754.web.service.CardGame;

import java.util.ArrayList;
import java.util.List;

public class PlacedDeck extends Deck{
    private List<Card> placedDeck = new ArrayList<>();
    public PlacedDeck(){
    }
    public PlacedDeck(Deck deck){
        this.placedDeck.add(deck.pullTopCard());
    }

    public void placeCard(Card card){
        this.placedDeck.add(card);
    }
    public Card getTopCard(){
        int cardLocation = placedDeck.size()-1;
        Card topCard = placedDeck.get(cardLocation);
        return topCard;
    }
    public List<Card> getPlacedDeck(){
        return this.placedDeck;
    }
}
