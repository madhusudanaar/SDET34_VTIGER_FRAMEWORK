package JDBCMySql1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.QueryResult;
import com.mysql.cj.xdevapi.Statement;
import com.vtiger.comcast.genericUtility.DataBaseUtility;

public class Selectquery_Samplecode {

	public static void main(String[] args) throws SQLException
	{
		
		DataBaseUtility dlib = new DataBaseUtility();
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
			    String Query = "select * from students_info;";
			    
		
			    //step4: execute the querry
			    ResultSet resultset = stat.executeQuery(Query);
			    
			    while (resultset.next()) 
			    {
			    	System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			    	
			    }
		} catch (Exception e) {
			
		}
		       
		       
		  finally
		         {
			         
	                 //step5: close the connection
			          conn.close();
			          System.out.println("close db connection");
		          }
		}

	}
	


