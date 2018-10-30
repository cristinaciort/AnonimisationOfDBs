package DBManipulation;
import java.sql.*;
public class persoane {
	public Connection con;
	/**
	 * connect to mysql DB
	 */
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc.mysql://localhost:3306/app_01","user","pass");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select 1 from dual");
			//pt insert sau update fara resultset
			while (rs.next())
				System.out.println(rs.getString(1));
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void return1(String nume, int xp, String workarea, String lang){
	connectDB();
	}
}