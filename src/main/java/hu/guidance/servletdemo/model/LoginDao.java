package hu.guidance.servletdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class LoginDao {

    private static final List<User> users;

    static {
        users = new ArrayList<>(List.of(
                new User(1, "admin", "123456", "Adminisztrátor", 0),
                new User( 2, "senkialfonz", "123456", "Senki Alfonz", 0)
        ));
    }

    private LoginDao() {
    }

    public static Optional<User> validate(String name, String password) {
        for (User user: users) {
            if(user.getUsername().toLowerCase(Locale.ROOT).equals(name) &&
                    user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public static Optional<Integer> getTokenById(long givenId) {
        for (User user: users) {
            if(user.getId() == givenId) {
                return Optional.of(user.getToken());
            }
        }
        return Optional.empty();
    }
}