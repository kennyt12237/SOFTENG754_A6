package nz.ac.auckland.se754.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.Login;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    Login service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String signInWithCredentials(ModelMap model, @RequestParam String username, @RequestParam String password){

        boolean isValidUser = service.validateUser(username, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", username);
        model.put("password", password);

        return "welcome";
    }

    @RequestMapping(value="/sso", method = RequestMethod.POST)
    public String signInUsingSso(ModelMap model){

        model.put("name", "SSO User");
        return "sso";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String openWelcomePage(ModelMap model) {
        return "welcome";
    }

    @RequestMapping(value="/lecture", method = RequestMethod.POST)
    public String joinLecture(ModelMap model, @RequestParam(required = false) Boolean authenticated, @RequestParam(required = false) Boolean enrolled) {

        boolean isAuthenticated = authenticated == null ? false : authenticated;
        boolean isEnrolled = enrolled == null ? false : enrolled;

        System.out.println(isAuthenticated + " " + isEnrolled);
        if (isAuthenticated && isEnrolled) {
            return "lecture";
        }

        model.put("errorMessage", "Invalid Credentials");
        return "welcome";
    }
}
