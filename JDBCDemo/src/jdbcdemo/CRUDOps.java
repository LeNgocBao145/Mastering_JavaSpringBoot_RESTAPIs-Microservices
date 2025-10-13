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

        //4. CRUD Operations
        // Insert
        String iq = "INSERT INTO department (dept_name, dean_id, office_location, established_year)\n" +
            "VALUES\n" +
            "('Computer Science', 1, 'Building A - Room 201', 2001),\n" +
            "('Information Technology', 2, 'Building B - Room 305', 2003),\n" +
            "('Electronics Engineering', 3, 'Building C - Room 101', 1998),\n" +
            "('Mathematics', 4, 'Building D - Room 405', 1995),\n" +
            "('Physics', 5, 'Building D - Room 410', 1997);";
        int insertedRes = st.executeUpdate(iq); // return number of records that insert successfully
        if(insertedRes > 0){
            System.out.println(insertedRes + " record(s) inserted successfully!!!");
        }else{
            System.out.println("Can't insert record(s) due to errors!!!");
        }
        
        //Update
        String uq = "UPDATE department SET established_year = 1999 WHERE dean_id=3";
        int updatedRes = st.executeUpdate(uq); // return number of records that updated successfully
        if(updatedRes > 0){
            System.out.println(updatedRes + " record(s) updated successfully!!!");
        }else{
            System.out.println("Can't update record(s) due to errors!!!");
        }
        
        //Delete
        String dq = "DELETE FROM department WHERE dean_id=5";
        int deletedRes = st.executeUpdate(dq); // return number of records that updated successfully
        if(deletedRes > 0){
            System.out.println(deletedRes + " record(s) deleted successfully!!!");
        }else{
            System.out.println("Can't delete record(s) due to errors!!!");
        }
        
        //Read
        String rq = "select * from department;";
        ResultSet rs = st.executeQuery(rq);
        
        // 5. Process results
        System.out.println("Department Details: ");
        while(rs.next()){
            System.out.println(rs.getInt("dept_id") + "\t|\t" 
                            + rs.getString(2) + "\t|\t"
                            + rs.getInt(3) + "\t|\t"
                            + rs.getString(4) + "\t|\t"
                            + rs.getInt(5) + "\t|\t");
        }
        
        // 6. Close connection
        conn.close();
    }
    
}
