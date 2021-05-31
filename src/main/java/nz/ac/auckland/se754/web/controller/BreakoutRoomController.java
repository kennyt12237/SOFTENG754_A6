package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.Canvas;
import nz.ac.auckland.se754.web.service.MainRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class BreakoutRoomController {

    @Autowired
    MainRoom service;

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.POST)
    public String addBreakoutRoom(ModelMap model) {
        service.maingroup.CreateBreakoutRooms(1);
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }


    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "id")
    public String finishshowMainPage(ModelMap model,@RequestParam String id) {
        service.maingroup.findBreakoutRoom(id).setInviteStatus(false);
        service.maingroup.findBreakoutRoom(id).setActivityStatus(false);
        service.maingroup.sendBackToBreakoutRoom( service.maingroup.findBreakoutRoom(id));
        LoadPage(model);
        return "mainroom-lecturer-screen";

    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "joinid")
    public String joinshowMainPage(ModelMap model,@RequestParam String joinid) {
        service.maingroup.joinBreakoutRoom(service.maingroup.findUser("Lecturer"),service.maingroup.findBreakoutRoom(joinid));
        LoadPage(model);
        return "mainroom-lecturer-screen";

    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "enablebk")
    public String enableshowMainPage(ModelMap model) {
        service.maingroup.setBreakoutRoomsEnabled(true);
        LoadPage(model);
        return "mainroom-lecturer-screen";

    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "disablebk")
    public String disableshowMainPage(ModelMap model) {
        service.maingroup.setBreakoutRoomsEnabled(false);
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/addtopic", method = RequestMethod.GET)
    public String setTopic(ModelMap model, @RequestParam String id) {
        if (id == "") {
            LoadPage(model);
            return "mainroom-lecturer-screen";
        } else {
            model.put("idnum", id);
            return "addtopic";
        }

    }

    @RequestMapping(value = "/addtopic", method = RequestMethod.POST)
    public String addTopic(ModelMap model, @RequestParam String roomid, @RequestParam(required = false) String topicname) {
        service.maingroup.SetTopicNameForGivenRoom(roomid, topicname);
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "importcanvas")
    public String canvasImportGroups(ModelMap model) {
        service.maingroup.CreateBreakoutRooms(service.maingroup.importUserGroupsFromCanvas(new Canvas()));
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/mainroom-lecturer-screen", method = RequestMethod.GET, params = "reset")
    public String ResetGroups(ModelMap model) {
        service = new MainRoom();
        LoadPage(model);
        return "mainroom-lecturer-screen";
    }

    @RequestMapping(value = "/student-room", method = RequestMethod.GET)
    public String joinStudent(ModelMap model, @RequestParam(required = false) String id, @RequestParam String user) {
        if (id == null) {
            model.put("username", user);
            loadStudentPage(model);
            return "student-room";
        } else {
            service.maingroup.joinBreakoutRoom(service.maingroup.findUser(user), service.maingroup.findBreakoutRoom(id));
            model.put("username", user);
            model.put("idnum", id);
            loadStudentPage(model);
            return "student-room";
        }
    }

    @RequestMapping(value = "/student-room", method = RequestMethod.POST)
    public String finishStudent(ModelMap model, @RequestParam String roomid, @RequestParam String usernameid) {
        service.maingroup.findBreakoutRoom(roomid).NotifyActivityComplete();
        model.put("username", usernameid);
        model.put("idnum", roomid);
        loadStudentPage(model);
        return "student-room";
    }


    @RequestMapping(value = "/student-room", method = RequestMethod.POST, params = "callbtn")
    public String callStudent(ModelMap model, @RequestParam String roomid, @RequestParam String usernameid) {
        service.maingroup.findBreakoutRoom(roomid).setInviteStatus(true);
        model.put("username", usernameid);
        model.put("idnum", roomid);
        loadStudentPage(model);
        return "student-room";
    }

    public void LoadPage(ModelMap model) {
        if (service.maingroup.getBreakoutRoomsEnabled()) {
            model.put("lblEnabled", "Breakout Rooms Enabled");
        } else {
            model.put("lblEnabled", "Breakout Rooms Disabled");
        }
        model.put("students", service.maingroup.GetStudents());
        model.put("breakoutRooms", service.maingroup.GetBreakoutRooms());
    }

    public void loadStudentPage(ModelMap model) {
        if (service.maingroup.getBreakoutRoomsEnabled()) {
            model.put("lblEnabled", "true");
        } else {
            model.put("lblEnabled", "false");
        }
        model.put("students", service.maingroup.GetStudents());
        model.put("breakoutRooms", service.maingroup.GetBreakoutRooms());
    }
}
