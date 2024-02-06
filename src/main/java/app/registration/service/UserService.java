package app.registration.service;

import app.registration.dto.Login;
import app.registration.dto.User;

public interface UserService {

    User register(User user);

    User validateUser(Login login);
}

