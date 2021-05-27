//package nz.ac.auckland.se754.web.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("name")
//@RequestMapping("/")
//public class SSOController {
//
//    @RequestMapping(value="/sso", method = RequestMethod.GET)
//    public String signInUsingSso(ModelMap model){
//
//        model.put("name", "SSO User");
//        return "sso";
//    }
//
//    @RequestMapping(value="/sso", method = RequestMethod.POST)
//    public String redirectToWelcome(ModelMap model) {
//        return "redirect:welcome";
//    }
//}
