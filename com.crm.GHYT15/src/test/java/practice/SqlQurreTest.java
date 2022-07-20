package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SqlQurreTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			System.out.println("connection is done");

			Statement stat = conn.createStatement();
			String query = "select * from student_info";

			ResultSet resultset = stat.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+"\t"+ resultset.getString(2));
			}   
		}
		catch(Exception e) {	
		}finally {
			conn.close();
			System.out.println("===========close db connection=====");
		}
	}
}

