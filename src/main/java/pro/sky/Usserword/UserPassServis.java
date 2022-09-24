package pro.sky.Usserword;

import org.springframework.stereotype.Service;

@Service
public class UserPassServis implements UserPassInterface {
    private static final String symbol = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789_";

    public String hello() {
        return "<b>hello world</b>";
    }

    public String tryLogin(String login, String password, String confirmPassword) {
        try {
            chekLogAndPass(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());

            return e.getMessage();
        } finally {
            System.out.println("Работа метода закончена");
        }
        return "Введены верные параметры";
    }

    protected static void chekLogAndPass(String login, String password, String confirmPassword

    ) throws WrongLoginException, WrongPasswordException {

        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина привышает допустимые значения");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongLoginException("Длина пароля привышает допустимые значения");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не подтвержден");
        }
        chekSymbols(login, true);
        chekSymbols(password, false);
    }
    protected static void chekSymbols(String insert, boolean isLogin) throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < insert.length(); i++) {
            if (!symbol.contains(String.valueOf(insert.charAt(i)))) {
                if (isLogin) {
                    throw new WrongLoginException("Использован недопустимый символ - " + insert.charAt(i));
                } else {
                    throw new WrongPasswordException("Использован недопустимый символ - " + insert.charAt(i));
                }
            }

        }
    }
}
