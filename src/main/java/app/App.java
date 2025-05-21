package app;


import dao.UserDAO;
import model.Book;
import model.Role;
import model.User;
import utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void insertWithStatement(Book book) throws SQLException {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO book (serial, title, author, releaseYear) VALUES ('" + book.getSerial() + "', '" + book.getTitle() + "', '" + book.getAuthor() + "', " + book.getReleaseYear() + ")";
            conn.setAutoCommit(false);
            int rowsAffected = stmt.executeUpdate(sql);
            conn.commit();
            System.out.println("Inserted " + rowsAffected + " book(s) with serial: " + book.getSerial() + " using StatementApp");
        } catch (SQLException e) {
            System.out.println("Error" + e);
            throw e;
        }
    }

    public static void main(String[] args) throws SQLException {
        User user1 = User.builder().username("admin").role(Role.valueOf("ADMIN")).password("12").build();
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.insert(user1);

    }
}