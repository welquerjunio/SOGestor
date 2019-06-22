package Controler;
/**
 *
 * @author Lucas
 */
import java.util.regex.*;
public class EmailValidador {
  public static void main(String[] args) {
        
    }

    public static boolean validar(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(expression, java.util.regex.Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
    
}
