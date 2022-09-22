package pro.sky.Usserword;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserPassServis implements UserPassInterface {
    public String hello() {
        return "<b>hello world</b>";
    }

    public String tryLogin(String login, String password, String confirmPassword) {
        final UserPassServis userPassServis;
        char[] a = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '_', '~',};
        boolean result1 = false;
        boolean result2 = false;
        String data=" ";
        if (login.length() <= 20 && password.length() < 20 && Arrays.equals(password.toCharArray(), confirmPassword.toCharArray())) {
            for (int i = 0; i < login.length(); i++) {
                for (int j = 0; j < a.length; j++) {
                    if (login.charAt(i) == a[j]) {
                        result1 = true;
                        System.out.println(login.charAt(i) + " " + a[j]);
                        break;
                    } else if (a.length - 1 <= j && login.charAt(i) != a[j]) {
                        System.out.println("login not pass");
                        result1 = false;
                        break;
                    }
                }
                if (!result1) {
                    System.out.println("login not pass!!!");
                    break;
                }
            }
            for (int i = 0; i < password.length(); i++) {
                for (int j = 0; j < a.length; j++) {
                    if (password.charAt(i) == a[j]) {
                        result2 = true;
                        System.out.println(password.charAt(i) + " " + a[j]);
                        break;
                    } else if (a.length - 1 <= j && password.charAt(i) != a[j]) {
                        System.out.println("password  not pravilno");
                        result2 = false;
                        break;
                    }
                }
                if (!result2) {
                    System.out.println("login not pass!!!");
                    break;
                }
            }
            if (!result1 && !result2) {
                System.out.println("login and pass");
                data = "Данные введены не корректно";
            }if (result1 && result2) {
                System.out.println("login and pass");
                data = "Данные введены верно";
            }
            System.out.println(result1 + " " + result2);

        }

        return data;
    }}