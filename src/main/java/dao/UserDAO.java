package dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.Getter;
import model.Role;
import model.User;
import utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO implements DAO<User> {
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    private UserDAO() {
    }

    @Getter
    private static final UserDAO instance = new UserDAO();

    public boolean isExistsUser(String username) {
        String sql = "SELECT 1 FROM jdbc.user WHERE username = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(User user) {
        if (isExistsUser(user.getUsername())) {
            throw new RuntimeException("Username already in use");
        }
        String sql = "INSERT INTO jdbc.user (username, password, role) VALUES (?, ?, ?::public.roles)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // hash password
            String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3,String.valueOf(user.getRole()));

            int rowsAffected = preparedStatement.executeUpdate();
            LOGGER.info("Inserted " + rowsAffected + " user with username: " + user.getUsername());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMany(List<User> users) {
        String sql = "INSERT INTO jdbc.user (username, password) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            connection.setAutoCommit(false);
            for (User user : users) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.addBatch();
            }
            int[] rowsAffected = preparedStatement.executeBatch();
            connection.commit();
            LOGGER.info("Inserted " + rowsAffected.length + " users successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE jdbc.user SET username = ?, role = ?::public.roles WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, String.valueOf(user.getRole()));
            preparedStatement.setInt(3, user.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            LOGGER.info("Updated " + rowsAffected + " user with username: " + user.getUsername());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * from jdbc.user";
        List<User> userList = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
        ) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int userId = result.getInt("id");
                String username = result.getString("username");
                String role = result.getString("role");
                User user = User.builder()
                        .id(userId)
                        .username(username)
                        .role(Role.valueOf(role))
                        .build();
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer");
        }
        String sql = "SELECT * from jdbc.user WHERE id =?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int userId = result.getInt("id");
                String username = result.getString("username");
                String role = result.getString("role");
                return User.builder()
                        .id(userId)
                        .username(username)
                        .role(Role.valueOf(role))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        if (findById(id) == null) {
            throw new RuntimeException("User not found");
        }
        String sql = "DELETE from jdbc.user WHERE id =?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            LOGGER.info("Deleted " + rowsAffected + " user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
