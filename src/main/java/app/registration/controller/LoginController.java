package app.registration.controller;

import app.registration.dto.Login;
import app.registration.dto.User;
import app.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    //Контроллер для страницы ввода логина и пароля.
    @GetMapping(value = "/login")
    public ModelAndView showLogin() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());

        return mav;
    }

    /* Контроллер проверяет авторизацию пользователя. Если пароль и логин верны,
то переходим на страницу Welcome, иначе на страницу логина с ошибкой. */
    @PostMapping(value = "/loginProcess")
    public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
        ModelAndView mav = null;

        User user = userService.validateUser(login);

        if (user != null) {
            mav = new ModelAndView("welcome");
            mav.addObject("firstname", user.getFirstname());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "The user name or password is incorrect!");
        }

        return mav;
    }
}
