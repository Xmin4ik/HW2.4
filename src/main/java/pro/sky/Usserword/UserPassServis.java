package pro.sky.Usserword;

import org.springframework.stereotype.Service;

@Service
public class UserPassServis implements UserPassInterface {
    public String hello() {
        return "<b>hello world</b>";
    }

    public String tryLogin(String login, String password, String confirmPassword) {
        final UserPassServis userPassServis;
        char[] a = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z' };
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '_', '~',};
        if (login.length() <= 20) {
            boolean result;

            for (int i = 0; i < login.length(); i++) {
                for (int j = 0; j < a.length; j++) {
                    for (int k = 0; k < b.length; j++) {
                        if (login.charAt(i) != a[j] && b[k] != login.charAt(i)) {
                            result = false;

                        }
                    }
                }
            }
            result = true;
            throw new WrongLoginException("!!!!");
        }
        if (password.length() < 20) {


            boolean result;

            for (int i = 0; i < password.length(); i++) {
                for (int j = 0; j < a.length; j++) {
                    for (int k = 0; k < b.length; j++) {
                        if (password.charAt(i) != a[j] && b[k] != password.charAt(i)&& password.equals(confirmPassword)) {
                            result = false;

                        }
                    }
                }
            }
            result = true;
            throw new WrongPasswordException("!!!!");}

        return "Данные введены верно";
    }


}
