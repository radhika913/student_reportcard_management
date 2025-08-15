import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Connect_Database {
    private static final String URL = "jdbc:mysql://localhost:3306/student_report_card";
    private static final String USER = "root";
    private static final String PASSWORD = "root@1234";
    public static String uname;
    public static String emailid;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void  insertStudent(int student_id,int roll_no,String sname,String standard,String division,int total_sub)
    {
		String sql="INSERT INTO student (student_id, roll_no, sname, standard, division, total_sub) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = Connect_Database.getConnection();
		            PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setInt(1, student_id);
		            pstmt.setInt(2, roll_no);
		            pstmt.setString(3, sname);
		            pstmt.setString(4, standard);
		            pstmt.setString(5, division);
		            pstmt.setInt(6, total_sub);
		            pstmt.executeUpdate();
		            System.out.println("Record Inserted.");
		        } catch (SQLException e)
		         {
		            System.out.println(e.getMessage());
		            e.printStackTrace();
		         }
		   }

   public static void  updateStudent(int student_id, int roll_no, String sname, String standard, String division, int total_sub)
   {
         String sql = "UPDATE student SET roll_no=?, sname=?, standard=?, division=?, total_sub=? WHERE student_id=?";
         try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
               pstmt.setInt(1, roll_no);
               pstmt.setString(2, sname);
               pstmt.setString(3, standard);
               pstmt.setString(4, division);
               pstmt.setInt(5, total_sub);
               pstmt.setInt(6, student_id);
               int rows = pstmt.executeUpdate();
               if (rows > 0)
                   System.out.println("Student record updated.");
               else
                   System.out.println("Student ID not found.");
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }


   public static void deleteStudent(int student_id)
   {
        String sql = "DELETE FROM student WHERE student_id=?";
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
               pstmt.setInt(1, student_id);
               int rows = pstmt.executeUpdate();
               if (rows > 0)
                   System.out.println("Student record deleted.");
               else
                   System.out.println("Student ID not found.");
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }


   public static boolean userRegistration(String name, String email_id, String contact_no, String designation, String password, String username) {
       String checkQuery = "SELECT * FROM user WHERE username = ?";
       String insertQuery = "INSERT INTO user (name, email_id, contact_no, designation, password, username) VALUES (?, ?, ?, ?, ?, ?)";

       try (Connection conn = getConnection()) {

           PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
           checkStmt.setString(1, username);
           ResultSet rs = checkStmt.executeQuery();

           if (rs.next()) {
               System.out.println("Username already exists.");
               return false;
           }


           PreparedStatement pstmt = conn.prepareStatement(insertQuery);
           pstmt.setString(1, name);
           pstmt.setString(2, email_id);
           pstmt.setString(3, contact_no);
           pstmt.setString(4, designation);
           pstmt.setString(5, password);
           pstmt.setString(6, username);
           pstmt.executeUpdate();

           System.out.println("User registered successfully.");
           return true;

       } catch (SQLException e) {
           System.out.println("Database error during registration: " + e.getMessage());
           e.printStackTrace();
           return false;
       }
   }



    public static boolean resetPassword(String email, String username, String newPassword) {
	    String checkQuery = "SELECT * FROM user WHERE email_id = ? AND username = ?";
	    String updateQuery = "UPDATE user SET password = ? WHERE email_id = ? AND username = ?";

	    try (Connection conn = getConnection();
	         PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

	        checkStmt.setString(1, email);
	        checkStmt.setString(2, username);
	        ResultSet rs = checkStmt.executeQuery();

	        if (rs.next()) {
	            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	            updateStmt.setString(1, newPassword);
	            updateStmt.setString(2, email);
	            updateStmt.setString(3, username);
	            int rows = updateStmt.executeUpdate();
	            return rows > 0;
	        } else {
	            return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static void insertEnquiry(String name, String email, String contactNo, String standard, String message) {
	    String sql = "INSERT INTO enquiry (name, email, contact_no, standard, message) VALUES (?, ?, ?, ?, ?)";

	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.setString(3, contactNo);
	        pstmt.setString(4, standard);
	        pstmt.setString(5, message);

	        pstmt.executeUpdate();
	        System.out.println("Enquiry submitted successfully.");

	    } catch (SQLException e) {
	        System.out.println("Error inserting enquiry: " + e.getMessage());
	        e.printStackTrace();
	    }
	}



    public static void insertUserLog(String username)
    {
	        String sql = "INSERT INTO userlog (username, login_date, login_time) VALUES (?, CURRENT_DATE, CURRENT_TIME)";

	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, username);
	            pstmt.executeUpdate();
	            System.out.println("Login recorded in userlog.");

	        } catch (SQLException e) {
	            System.out.println("Error inserting into userlog: " + e.getMessage());
	            e.printStackTrace();
	        }
    }

	public static boolean login(String username, String password)
	{
	        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

	        try (Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql))
	        {
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next())
	            {
				   insertUserLog(username);
	               System.out.println("Login successful!");
	               return true;
	            }
	            else
	            {
	                System.out.println("Invalid credentials.");
	                return false;
	             }
	        } catch (SQLException e)
	         {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	            return false;
	        }
	    }


    public static String getEmailByUsername(String username)
    {
	    String email = "";
	    String sql = "SELECT email_id FROM users WHERE username = ?";
	    try (Connection conn = getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql))
	         {
	           stmt.setString(1, username);
	           ResultSet rs = stmt.executeQuery();
	           if (rs.next())
	           {
	              email = rs.getString("email_id");
	           }
	        } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return email;
	}
}





