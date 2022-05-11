package JDBCMySql1;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vtiger.comcast.genericUtility.DataBaseUtility;

public class DataBaseSelectQuerryExcell {

	public static void main(String[] args) throws Throwable {
		int result;
		DataBaseUtility dlib = new DataBaseUtility();
		
		/*Connection*/
		dlib.connectDB();
		String query= "select * from students_info;";
		
		
		/*execute query*/
	     ResultSet resultset = dlib.executeQuery(query);
	     while(resultset.next())
	     {
	     System.out.println(resultset.getString(1));
	     }
	    
	
		dlib.closeDB();

	}

}
