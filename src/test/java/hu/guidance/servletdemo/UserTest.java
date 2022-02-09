package hu.guidance.servletdemo;

import hu.guidance.servletdemo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void createUser() {
        User user = new User();
        user.setUsername("torokzultan");
        user.setPassword("abc123");

        String username = user.getUsername();
        String password = user.getPassword();

        assertEquals("torokzultan", username);
        assertEquals("abc123", password);
    }
}
