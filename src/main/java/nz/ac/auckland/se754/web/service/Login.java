package nz.ac.auckland.se754.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Login {

    public boolean validateUser(String userid, String password) {
        return userid.equals("test")
                && password.equals("password");
    }

}