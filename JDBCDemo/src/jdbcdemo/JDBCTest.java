package jdbcdemo;

// JDBC API
// java.sql || javax.sql

import java.sql.*;

public class JDBCTest {
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
        
        // 4. Execute Queries
        String query = "select * from class;";
        ResultSet rs = st.executeQuery(query);
        
        // 5. Process results
        while(rs.next()){
            System.out.println(rs.getString(1) + " | " 
                            + rs.getInt(2) + " | "
                            + rs.getString(3));
        }
        
        // 6. Close connection
        conn.close();
    }
    
}
