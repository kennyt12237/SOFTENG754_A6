package nz.ac.auckland.se754.web.service.CardGame;

import nz.ac.auckland.se754.web.service.User;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private User user;
    private List<Card> hand = new ArrayList<Card>();
    private boolean hasWon;
    public Player(){
        this.hasWon = false;
    }
    public Player(User user){
        this.user = user;
        this.hasWon = false;
    }
    //For testing purposes only
    public List<Card> getStartingHand(){
        this.hand.add(new Card(0,1));
        this.hand.add(new Card(1,1));
        this.hand.add(new Card(2,1));
        this.hand.add(new Card(2,2));
        this.hand.add(new Card(0,2));
        this.hand.add(new Card(3,4));
        this.hand.add(new Card(3,11));

        return this.hand;
    }

    public List<Card> getStartingHand(Deck deck){
        for(int i = 0; i<7; i++){
            this.hand.add(deck.pullTopCard());
        }
        return this.hand;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public boolean playCard(Card card, PlacedDeck placedDeck){
        Card topCard = placedDeck.getTopCard();
        if(card.getSuit() != topCard.getSuit() && card.getValue() != topCard.getValue()){
            return false;
        }
        this.hand.remove(card);
        placedDeck.placeCard(card);
        return true;
    }
    public boolean playMultipleCards(Card cards[], PlacedDeck placedDeck){
        int firstCardValue = cards[0].getValue();
        Card topCard = placedDeck.getTopCard();
        Boolean oneValidCard = false;
        for(int i = 0; i<cards.length; i++){
            if(firstCardValue != cards[i].getValue()){
                return false;
            }
            if(cards[i].getSuit() == topCard.getSuit() || cards[i].getValue() == topCard.getValue()){
                oneValidCard = true;
            }
        }
        if(oneValidCard){
            return true;
        }
        else{
            return false;
        }

    }
    public void drawCard(Deck deck){
        this.hand.add(deck.pullTopCard());
    }

    public boolean getHasWon(){
        if(getHand().size() == 0){
            this.hasWon = true;
            return true;
        }
        return false;
    }

    public boolean playerHasValidMoves(Card topCard, Deck deck){
        for(int i =0; i< this.hand.size()-1; i++){
            if(this.hand.get(i).getSuit() == topCard.getSuit() || this.hand.get(i).getValue() == topCard.getValue()){
                return true;
            }
        }
        drawCard(deck);
        return false;
    }


}
