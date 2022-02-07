package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    private static List<User> users;

    static {
        users = new ArrayList<>(List.of(
                new User(1, "admin", "123456"),
                new User( 2, "senkialfonz", "123456")
        ));
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        for (User user: users) {
            if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
                status = true;
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

        return status;
    }
}