package pro.sky.Usserword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static pro.sky.Usserword.UserPassServis.chekLogAndPass;

@RestController
public class UserPassController {
    private final UserPassInterface userPassInterface;

    public UserPassController(UserPassInterface userPassInterface) {
        this.userPassInterface = userPassInterface;
    }

    @GetMapping
    public String hello() {
        return userPassInterface.hello();
    }

    @GetMapping(path = "/user")
    public String tryLogin(@RequestParam() String login, String password, String confirmPassword) {
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


}
