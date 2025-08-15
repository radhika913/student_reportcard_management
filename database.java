import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/CruciFy";
    private static final String USER = "root";
    private static final String PASSWORD = "root@1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void  insertStudent(int student_id,int roll_no,String sname,String standard,String division,int total_sub)
    {
		String sql="INSERT INTO student (student_id, roll_no, sname, standard, division, total_sub) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = Database.getConnection();
		            PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setInt(1, student_id);
		            pstmt.setInt(2, roll_no);
		            pstmt.setString(3, sname);
		            pstmt.setString(4, standard);
		            pstmt.setString(5, division);
		            pstmt.setInt(6, total_sub);
		            pstmt.executeUpdate();
		            System.out.println("Record Inserted.");
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            e.printStackTrace();
		        }
		    }

}




