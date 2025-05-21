package service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Role;
import model.User;
import utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {

    public static User login(String username, String password) {
        String sql = "SELECT * FROM jdbc.user WHERE username = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, username);

            ResultSet result = preparedStatement.executeQuery();
           if (result.next()){
               String hashedPassword = result.getString("password");
               // compare password
               BCrypt.Result verifyResult = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);

               if (verifyResult.verified) {
                   String roleString = result.getString("role");
                   Role role = Role.valueOf(roleString);
                   return User.builder()
                           .id(result.getInt("id"))
                           .username(result.getString("username"))
                           .role(role)
                           .build();
               }
           }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
