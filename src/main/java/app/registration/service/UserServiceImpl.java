package app.registration.service;


import app.registration.dao.UserDaoImpl;
import app.registration.dto.Login;
import app.registration.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserDaoImpl containerService;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.containerService = userDao;
    }

    // Метод добавляет зарегистрированного пользователя.
    public User register(User user) {
        return containerService.register(user);
    }

    //Метод возвращает авторизованного пользователя
    public User validateUser(Login login) {
        return containerService.validateUser(login);
    }
}
