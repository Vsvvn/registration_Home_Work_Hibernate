package app.registration;

import app.registration.dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    private User user;


    @BeforeEach
    public void setUp() {

        user = new User(0,"test@ya.ru", "pass", "Name", "Surname", "test@ya.ru", "Test Street", 880088888);

    }

    @Test
    @DisplayName("When an object is created by passing parameters, then the test is correct.")
    void userCheckArgument() {
        String username = "test@ya.ru";
        String password = "pass";
        String firstname = "Name";
        String lastname = "Surname";
        String email = "test@ya.ru";
        String address = "Test Street";
        int phone = 880088888;


        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(firstname, user.getFirstname());
        assertEquals(lastname, user.getLastname());
        assertEquals(email, user.getEmail());
        assertEquals(address, user.getAddress());
        assertEquals(phone, user.getPhone());

    }

    @Test
    @DisplayName("When login and email do not match, then they are correct.")
    void notEqualEmailAndLogin() {
        assertNotEquals(user.getUsername(), user.getPassword());
    }

    @Test
    @DisplayName("When the email address contains the characters '@' and '.', then the test is correct.")
    void checkEmail() {

        assertTrue(user.getEmail().contains("@"));
        assertTrue(user.getEmail().contains("."));
    }
}
