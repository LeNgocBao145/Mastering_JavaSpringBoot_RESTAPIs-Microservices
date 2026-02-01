import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
public class PSTDemo {
     public static void main(String[] args) throws Exception { 
        Scanner in = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/student_management";
        String uname ="root";
        String pwd ="090909lol";
        Connection con = DriverManager.getConnection(url,uname,pwd);
        if(con != null){
            System.out.println("Connection established!");
        }
        else{
            System.out.println("Connection Failed");
        }
        // Prepared Statement - demo 
        String q1 = "insert into student values (?,?,?,?,?,?,?)";
        
        System.out.println("Enter student details");
        int sid = in.nextInt();
        in.nextLine();
        String first_name = in.nextLine();        
        String last_name = in.nextLine();        
        LocalDate date_of_birth = LocalDate.parse(in.nextLine());
        int year_enrolled = in.nextInt();
        int library_id = in.nextInt();
        in.nextLine();
        String course_id = in.nextLine();
//        
        PreparedStatement pst = con.prepareStatement(q1);
        // set the placeholders
        pst.setInt(1, sid);
        pst.setString(2, first_name);        
        pst.setString(3, last_name);
        pst.setObject(4, date_of_birth);
        pst.setInt(5, year_enrolled);
        pst.setInt(6, library_id);
        pst.setString(7, course_id);
        
        int x = pst.executeUpdate();
        if(x>0)
             System.out.println(x+ " record(s) inserted");
        /*
        pst = con.prepareStatement("update student set sname = ? where sid = ?");
        pst.setString(1, "Jarvis");
        pst.setInt(2, 199);
        int y = pst.executeUpdate();
        if(y>0)
             System.out.println(y+ " record(s) updated");
       */
        ResultSet rs = pst.executeQuery("select * from student");  // just like Statement
         while(rs.next()){
            System.out.println(rs.getInt("student_id")+" "+rs.getString("first_name")+" "+
                    rs.getString("last_name")+" "+rs.getString("date_of_birth")+" "+
                    rs.getInt("year_enrolled")+" "+rs.getInt("library_id")+" "+
                    rs.getString("course_id"));
        }
        
         con.close();
     }
}