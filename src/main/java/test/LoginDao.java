package test;

import java.sql.*;
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

//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
//
//            PreparedStatement ps = con.prepareStatement(
//                    "select * from userreg where name=? and password=?");
//            ps.setString(1, name);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//            status = rs.next();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        return validatedUser;
    }
}