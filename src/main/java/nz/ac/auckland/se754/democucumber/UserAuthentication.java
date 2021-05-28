package nz.ac.auckland.se754.democucumber;

public class UserAuthentication {

    private static String UPI_PATTERN = "[A-Za-z]{3,4}\\d{3}";
    private static String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private SSOMock sso;

    public UserAuthentication() {
        sso = new SSOMock();
    }

    public UserAuthentication(SSOMock sso) {
        this.sso = sso;
    }

    public boolean checkUpi(String upi) {

        return upi.matches(UPI_PATTERN);
    }

    public boolean checkEmail(String email) {

        return email.matches(EMAIL_PATTERN);
    }

    public boolean verifyLogin(String upi, String password) {

        return sso.verify(upi, password);
    }
}
