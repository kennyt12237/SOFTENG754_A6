package nz.ac.auckland.se754.web.service.CardGame;
import nz.ac.auckland.se754.web.service.User;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public Deck deck;
    private List<Player> players = new ArrayList<Player>();
    private PlacedDeck placedDeck;
    private Player gameWinner;
    private int currentPlayer;
    public CardGame(List<User> newStudents){
        deck = new Deck(newStudents.size());
        for(int i =0; i<newStudents.size(); i++){
            players.add(new Player(newStudents.get(i)));
        }
        placedDeck = new PlacedDeck(deck);
        currentPlayer = 0;

        while(!playerHasWon()){


        }


    }
    public boolean started(){
        return true;
    }

    public boolean hasPlayers(){
        if(this.players.size() > 0){
            return true;
        }
        return false;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public Deck getDeck(){
        return this.deck;
    }
    public PlacedDeck getPlacedDeck(){
        return this.placedDeck;
    }

    public void setCurrentPlayer(int playerID){
        this.currentPlayer = playerID;
    }

    public void currentPlayerMoveOver(){
        if(this.currentPlayer+1 > this.players.size()-1){
            this.currentPlayer = 0;
        }
        else{
            this.currentPlayer++;
        }
    }

    public int getCurrentPlayer(){
        return this.currentPlayer;
    }

    public boolean playerHasWon(){
        int noPlayers = this.players.size();
        for(int i =0; i<noPlayers; i++){
            if(this.players.get(i).getHasWon()){
                this.setGameWinner(this.players.get(i));
                return true;
            }
        }
        return false;
    }

    public void setGameWinner(Player winner){
        this.gameWinner = winner;
    }


}
