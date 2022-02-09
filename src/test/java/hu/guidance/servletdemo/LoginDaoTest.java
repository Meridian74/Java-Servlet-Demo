package hu.guidance.servletdemo;

import hu.guidance.servletdemo.model.LoginDao;
import hu.guidance.servletdemo.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginDaoTest {
    @Test
     void validUserName() {
        String name = "senkialfonz";
        String password = "123456";
        Optional<User> result = LoginDao.validate(name, password);

        assertEquals("Senki Alfonz", result.get().getName());
    }

    @Test
    void invalidUserName() {
        String name = "anybody";
        String password = "123456";
        Optional<User> result = LoginDao.validate(name, password);

        assertTrue(result.isEmpty());
    }

    @Test
    void validPassword() {
        String name = "admin";
        String password = "123456";
        Optional<User> result = LoginDao.validate(name, password);

        assertEquals("123456", result.get().getPassword());
    }

    @Test
    void invalidPassword() {
        String name = "admin";
        String password = "abc123";
        Optional<User> result = LoginDao.validate(name, password);

        assertTrue(result.isEmpty());
    }

}

