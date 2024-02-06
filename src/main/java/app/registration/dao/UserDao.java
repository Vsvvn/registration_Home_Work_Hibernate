package app.registration.dao;

import app.registration.dto.Login;
import app.registration.dto.User;

public interface UserDao {

  User register(User user);

  User validateUser(Login login);
}
