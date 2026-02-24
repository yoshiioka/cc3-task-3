import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private Connection conn;
    private final String DB_URL = "jdbc:sqlite:University.db"; // Change to your actual .db file name

    private Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void save(Student s) {
        // Matches your StudentInfo table columns 
        String sql = "INSERT INTO StudentInfo(SURNAME, FIRSTNAME, MIDDLENAME, AGE, GENDER, BIRTHMONTH, BIRTHYEAR, STUDENTID, COURSE, YEAR) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connect().prepareStatement(sql)) {
            pstmt.setString(1, s.getSurname());
            pstmt.setString(2, s.getFirstName());
            pstmt.setString(3, s.getMiddleName());
            pstmt.setInt(4, s.getAge());
            pstmt.setString(5, s.getGender());
            pstmt.setString(6, s.getBirthMonth());
            pstmt.setInt(7, s.getBirthYear());
            pstmt.setInt(8, s.getStudentId());
            pstmt.setString(9, s.getCourse());
            pstmt.setInt(10, s.getYear());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentInfo";
        try (Statement stmt = connect().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Rebuilding the Student object from database rows [cite: 8, 57]
                list.add(new Student.Builder()
                        .setSurname(rs.getString("SURNAME"))
                        .setFirstName(rs.getString("FIRSTNAME"))
                        .setMiddleName(rs.getString("MIDDLENAME"))
                        .setAge(rs.getInt("AGE"))
                        .setGender(rs.getString("GENDER"))
                        .setBirthMonth(rs.getString("BIRTHMONTH"))
                        .setBirthYear(rs.getInt("BIRTHYEAR"))
                        .setStudentID(rs.getInt("STUDENTID"))
                        .setCourse(rs.getString("COURSE"))
                        .setYear(rs.getInt("YEAR"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
