import java.sql.*;
import java.util.Scanner;
public class CSTDemo {
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
        // calling stored procedure
//         String query = "{call first_proc1(?,?)}"; // calling procedure
        
        //Calling stored function
        String query = "{? = call add_ab(?,?)}";
        CallableStatement cst = con.prepareCall(query);
        
        System.out.println("Enter two input values");
        int a = in.nextInt();
        int b = in.nextInt();
        
        cst.setInt(2,a); // setting the i/p param - second ?
        cst.setInt(3,b); //  third ?
        cst.registerOutParameter(1, Types.INTEGER);
//        cst.setInt(1,25); 
//        cst.registerOutParameter(2, Types.INTEGER);
        
        cst.execute(); // executing the stored function
        
        int result = cst.getInt(1); // 
        System.out.println("Sum : "+result);
//        System.out.println("Square of 25 is : "+result);
    }
}

/* Stored Procedure
delimiter $$
mysql> create procedure first_pro(a int, out b int)
    -> begin
    -> set b = (a*a);
    -> end
    -> $$
*/

/*   Stored Function
create function add_ab(a int, b int)
    -> returns int deterministic
    -> begin
    -> declare c int;
    -> set c = (a+b);
    -> return c;
    -> end
    -> $$
*/
