package nz.ac.auckland.se754.web.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MainRoom {

    ArrayList<User> userlist = new ArrayList<>(Arrays.asList(new User("cpat430"), new User("akha379"), new User("abc123"), new User("sat230"), new User("has379")));
    public UserGroup maingroup = new UserGroup(userlist);

}