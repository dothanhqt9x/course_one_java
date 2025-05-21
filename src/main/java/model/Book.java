package model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import utils.DatabaseUtil;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private static final Logger LOGGER = Logger.getLogger(Book.class.getName());
    String serial;
    String title;
    String author;
    int releaseYear;

    public String getDescription() {
        return "Book description: Serial: " + serial + ", title: " + title + ", author: " + author + ", releaseYear: " + releaseYear;
    }

    private static final String FIND_BY_SERIAL_SQL = "SELECT serial, title, author, releaseYear FROM book WHERE serial = ?";

    public static void findBookBySerial(String serial) throws SQLException {
        if (serial == null || serial.trim().isEmpty()) {
            LOGGER.warning("Serial cannot be null or empty.");
            throw new IllegalArgumentException("Serial cannot be null or empty.");
        }
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(FIND_BY_SERIAL_SQL)) {
            pstmt.setString(1, serial);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setSerial(rs.getString("serial"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setReleaseYear(rs.getInt("releaseYear"));
                    LOGGER.info("Found book with serial: " + serial);
                } else {
                    LOGGER.info("No book found with serial: " + serial);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding book with serial: " + serial, e);
            throw e;
        }
    }

    public static Book findBySerialWithStatement(String serial) throws SQLException {
        if (serial == null || serial.trim().isEmpty()) {
            throw new IllegalArgumentException("Serial cannot be null or empty");
        }
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT serial, title, author, releaseYear FROM book WHERE serial = " + serial;
            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setSerial(rs.getString("serial"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setReleaseYear(rs.getInt("releaseYear"));
                    LOGGER.info("Found book with serial: " + serial + " using Statement");
                    return book;
                }
                LOGGER.info("No book found with serial: " + serial + " using Statement");
                return null;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding book with Statement: " + serial, e);
            throw e;
        }
    }
}