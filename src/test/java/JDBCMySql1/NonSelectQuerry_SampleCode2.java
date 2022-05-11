package JDBCMySql1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;
import com.vtiger.comcast.genericUtility.DataBaseUtility;

public class NonSelectQuerry_SampleCode2 {

	         public static void main(String[] args) throws SQLException 
	         {
	        	 
		Connection conn=null;
		try {
		         Driver driverRef = new com.mysql.cj.jdbc.Driver();
			   
			   //step1:load/Register mysql the database
			   DriverManager.registerDriver(driverRef);
			   
			   //step2: connect to database
			   conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			   System.out.println("connection is done");
			   
			   //step3 :create querry statement
			    java.sql.Statement stat=conn.createStatement();
			    String Query = "insert into students_info values('7','tam','linga','h')";
			    
			    //step4: execute the querry
			     int result = stat.executeUpdate(Query);
			   
		}catch (Exception e) {
			
		}finally {
			
			
			 //step5: close the connection
			conn.close();
			System.out.println("close db connection");
			}
		}

}
