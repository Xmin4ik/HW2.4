package pro.sky.Usserword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path ="/user")
    public String tryLogin(@RequestParam() String login, String password, String confirmPassword) {

        try {
            return userPassInterface.tryLogin(login, password, confirmPassword);

        } catch (WrongLoginException e) {
            return "введены не верные параметры";
        } catch (WrongPasswordException r) {
            return "введены не верные параметры";
        }

        finally {System.out.println("Работа метода закончена");}

    }
}
