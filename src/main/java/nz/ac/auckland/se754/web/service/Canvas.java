package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Canvas {
    private List<List<User>> userList;

    public Canvas() {
        ArrayList<User> SubGroup = new ArrayList<User>(Arrays.asList(new User("cpat430"), new User("akha379"), new User("abc123")));
        ArrayList<User> SubGroup1 = new ArrayList<User>(Arrays.asList(new User("sat230"), new User("has379")));

        userList = new ArrayList<>();
        userList.add(SubGroup);
        userList.add(SubGroup1);
    }

    public List<List<User>> getUserList() {
        return userList;
    }
}
