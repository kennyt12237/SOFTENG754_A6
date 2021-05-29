package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.MainRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class BreakoutRoomController {

    @Autowired
    MainRoom service;

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {

        model.put("students", service.maingroup.GetStudents());
        model.put("breakoutRooms", service.maingroup.GetBreakoutRooms());
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.POST)
    public String addBreakoutRoom(ModelMap model){
        model.put("students", service.maingroup.GetStudents());
        service.maingroup.CreateBreakoutRooms(1);
        model.put("breakoutRooms", service.maingroup.GetBreakoutRooms());
        return "mainroom-lecturer-screen";
    }
}
