package app.registration.controller;


import app.registration.dto.User;
import app.registration.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RegistrationController {
    public final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    //Контроллер для страницы регистрации пользователя.
    @GetMapping("/register")
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());

        return mav;
    }

    //Контроллер для страницы авторизованного пользователя.
    @PostMapping("/registerProcess")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.register(user);
        return new ModelAndView("welcome", "firstname", user.getFirstname());
    }
}




