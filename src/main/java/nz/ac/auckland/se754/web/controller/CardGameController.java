package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.CardGame.*;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CardGameController {
    @Autowired
    CardGame service = new CardGame();


    @RequestMapping(value="/CardGame", method=RequestMethod.GET)
    public String showCardGamePage(ModelMap model){
        loadPage(model);
        return "cardgame";
    }

    @RequestMapping(value="/CardGame", method=RequestMethod.POST)
    public String drawCardFromDeck(ModelMap model){
        service.getPlayers().get(service.getCurrentPlayer()).drawCard(service.getDeck());

        loadPage(model);
        return "cardgame";
    }

    public void loadPage(ModelMap model){
        model.put("hand", service.getPlayers().get(0).getHand());
        model.put("Suit", service.getPlacedDeck().getTopCard().getWordSuit());
        model.put("Value", service.getPlacedDeck().getTopCard().getWordValue());
        model.put("HelpMessage", "Last Card is a game in which each player takes turns placing cards that match the suit or value. You can place multiple cards at the same time, so long as they match value. If you're unable to place any cards, you must pick up 1. Whoever empties their hand first wins the game.");

    }

}
