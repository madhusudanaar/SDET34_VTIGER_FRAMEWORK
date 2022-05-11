package JDBCMySql1;

import com.vtiger.comcast.genericUtility.DataBaseUtility;

public class DataBaseUpdatesExcell {

	public static void main(String[] args) throws Throwable
	{
		int result;
		DataBaseUtility dlib = new DataBaseUtility();
		/*Connection*/
		dlib.connectDB();
		String query="insert into students_info values ('10','rudra','prakash','k');";
		
		/*execute query*/
	     result = dlib.executeUpdate(query);
	    if(result==1)
	    {
	    	System.out.println("data is inserted");
	    }
	    else
	    {
	    	System.out.println("data is not inserted");
	    }
	
		dlib.closeDB();
	}

}

