package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import utils.DBUtil;

public class UserDAO {
    public static boolean validate(User user) {
        boolean status = false;
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            status = rs.next(); // Nếu tìm thấy user
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
