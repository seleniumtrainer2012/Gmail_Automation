package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Select_Query_Example1 {
	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "test";
		String username="root";
		String password="root";

		try{
			Class.forName(driver).newInstance();			
			conn = DriverManager.getConnection(url+dbName,username,password);
			System.out.println(conn.isClosed());			
			
			//query
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from updated_persons");
			
			while(rs.next()){
				System.out.println("empid:-"+rs.getString(1)+", emp city:-"+rs.getString("City"));
				
			}
			
			conn.close();
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}

}
