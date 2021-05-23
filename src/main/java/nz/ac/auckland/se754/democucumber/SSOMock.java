package nz.ac.auckland.se754.democucumber;

import java.util.HashSet;
import java.util.Set;

public class SSOMock {

    private Set<String> verified;

    public SSOMock() {
        verified = new HashSet<>();
    }

    public boolean verify(String upi, String password) {


        return true;
    }
}