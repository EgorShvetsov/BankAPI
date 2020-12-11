package model.logic;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	private static final String URL = "jdbc:h2:/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db/juniorBank";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	private static final String DB_DRIVER = "org.h2.Driver";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("СОЕДИНЕНИЕ УСТАНОВЛЕНО");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			System.out.println("ОШИБКА ПОДКЛЮЧЕНИЯ");
		}
		return connection;
	}
}
