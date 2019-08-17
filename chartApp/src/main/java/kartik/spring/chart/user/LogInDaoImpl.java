package kartik.spring.chart.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class LogInDaoImpl implements LogInDao{

	public String doLogIn(UserBean user) {
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			  Connection con=DriverManager.getConnection(
			  "jdbc:mysql://remotemysql.com:3306/9p039dOST5","9p039dOST5","25H9Vb3xkp");
			 
			/*
			 * Connection con=DriverManager.getConnection(
			 * "jdbc:mysql://48581.us-imm-sql6.000webhost.io" +
			 * ":3306/mychartdb","kartik","kartik@1234");
			 */ 
			//here sonoo is database name, root is username and password  
			
			
			if(null!=con)
				System.out.println("connection succed");
			else
				System.out.println("no connectoion found");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Student");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			con.close();  
			}catch(Exception e){ e.printStackTrace();}  
		return null;
	}

}
