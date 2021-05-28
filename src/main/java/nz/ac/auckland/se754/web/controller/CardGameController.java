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

import java.util.ArrayList;
import java.util.List;

@Controller
public class CardGameController {

    @Autowired
    CardGame service;

    @RequestMapping(value="/CardGame", method=RequestMethod.GET)
    public String showCardGamePage(ModelMap model){
        return "cardgame";
    }

    @RequestMapping(value="/CardGame", method = RequestMethod.POST)
    public CardGame createNewCardGame(){
        List<User> students = new ArrayList<>();
        students.add(null);
        CardGame cardGame = new CardGame(students);
        return cardGame;
    }
}
