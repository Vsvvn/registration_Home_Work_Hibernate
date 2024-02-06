package app.registration.dao;

import app.registration.dto.Login;
import app.registration.dto.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {

    // вызываем на объекте сессии метод save данный метод внутри себя содержит необходимый запрос к базе
    @Override
    public User register(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable createdId = session.save(user);
            User createdUser = session.get(User.class, createdId);
            transaction.commit();
            return createdUser;
        }
    }

    // В параметре метода get нужно указать объект какого класса нам нужен и его login
    @Override
    public User validateUser(Login login) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(User.class, (Serializable) login);
        }
    }
}
