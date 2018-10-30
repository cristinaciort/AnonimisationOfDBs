package DBManipulation;
//se declara pachetul folosit
import java.sql.*;
//se importa baza de date
public class Create {
	public Connection con;
//se declara con inainte de void pentru ca este folosit si in alte metode
	/**
	 * Connects to MySql DB
	 */
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//importa driverul pentru baza de date pentru a putea functiona
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_01", "user", "pass");
			//se conecteaza la baza de data folosind connection string(driver:TipBazaDeDate://link conectare BD(ip:port)/nume baza date
			//process DB request/query
			Statement stmt = con.createStatement();
			//creaza un obiect prin care pot executa comenzi pe baza
			ResultSet rs = stmt.executeQuery("select 1 from dual");
			//folosesc stmt.executeQuery(insert sau update)
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
			rs.close();
			stmt.close();
			//while parcurge query declarat la resultSet*20
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
