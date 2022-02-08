package hu.guidance.servletdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class LoginDao {

    private static List<User> users;

    static {
        users = new ArrayList<>(List.of(
                new User(1, "admin", "123456"),
                new User( 2, "senkialfonz", "123456")
        ));
    }

    public static Optional<User> validate(String name, String password) {
        Optional<User> validatedUser = Optional.empty();
        for (User user: users) {
            if(user.getUsername().toLowerCase(Locale.ROOT).equals(name) &&
                    user.getPassword().equals(password)) {
                validatedUser = Optional.of(user);
                break;
            }
        }

        return validatedUser;
    }
}