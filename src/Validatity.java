import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validatity {
    static public boolean validateMobile(String phoneNumber) {
        String regex = "^375[0-9]{2} [0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches())
            return true;
        return false;
    }

    static public boolean validateEmail(String email) {
        if ((email.contains("@")) && (email.contains(".")) && (email.indexOf("@") < email.lastIndexOf(".")))
            return true;
        return false;
    }
}

