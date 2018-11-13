package pre.send.mail;

import java.sql.*;
import java.util.ArrayList;

public class PreSendMail {

	public Connection con;

	// se declara con inainte de void pentru ca este folosit si in alte metode
	/**
	 * Connects to MySql DB
	 */
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// importa driverul pentru baza de date pentru a putea functiona
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_01", "user", "pass");
			// se conecteaza la baza de data folosind connection
			// string(driver:TipBazaDeDate://link conectare BD(ip:port)/nume
			// baza date
			// process DB request/query
			Statement stmt = con.createStatement();
			// creaza un obiect prin care pot executa comenzi pe baza
			ResultSet rs = stmt.executeQuery("select 1 from dual");
			// folosesc stmt.executeQuery(insert sau update)
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			rs.close();
			stmt.close();
			// while parcurge query declarat la resultSet*20
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList getMail(int[] IDs) {
		connectDB();
		ArrayList mails = new ArrayList();
		try {
			Statement stmt = con.createStatement();
			for (int i = 0; i < IDs.length; i++) {
				ResultSet rs = stmt.executeQuery("select Mail from Candidati where ID"+IDs[i]);
				mails.add(rs.getInt(0));
			}
			// parsare cu for pe IDs, pentru fiecare id din lista selectez
			// mailul
			// din tabela candidati si ce este in resultSet pui in mails
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mails;
	}
}
