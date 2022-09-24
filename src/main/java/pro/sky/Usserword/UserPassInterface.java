package pro.sky.Usserword;

public interface UserPassInterface {
    String hello(); // все публичные по умолчанию

    String tryLogin(String login, String password, String confirmPassword);


}
