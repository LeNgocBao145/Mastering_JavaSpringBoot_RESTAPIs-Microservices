package jdbcdemo;

// JDBC API
// java.sql || javax.sql

import java.sql.*;

public class CRUDOps {
    public static void main(String[] args) throws Exception {
        // 1. Loading drivers
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 2. Establishing the connection
        String url = "jdbc:mysql://localhost:3306/university_management";
        String uname = "root";
        String pwd = "";
        
        Connection conn = DriverManager.getConnection(url,uname,pwd);
        
        if(conn != null){
            System.out.println("Connection established");
        }
        else{
            System.out.println("Connection failed");
        }
        
        // 3. Create statement
        Statement st = conn.createStatement();
        
        // 4. Create table
        String cq = "CREATE TABLE department (" +
            " dept_id INT AUTO_INCREMENT PRIMARY KEY," +
            " dept_name VARCHAR(100) NOT NULL," +
            " dean_id INT," +
            " office_location VARCHAR(100)," +
            " established_year YEAR" +
        ");";
        
        int res = st.executeUpdate(cq); // return 0 if success
        if (res >= 0){
            System.out.println("Table Created");
        }else {
            System.out.println("Table is not created");
        }
        
        // 6. Close connection
        conn.close();
    }
    
}
