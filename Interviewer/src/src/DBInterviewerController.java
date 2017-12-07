package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBInterviewerController {
	private Connection connection;
	private Statement statement;
	private PreparedStatement ps;
	private ResultSet resultSet;
	private String sql;
	
	
	public void dbaseConnect(String url, String user, String pass) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, pass);
	}
	
	public void useDatabase(String db) throws SQLException {
		sql = "use "+db;
		ps = connection.prepareStatement(sql);
		ps.executeQuery();
	}
	
	public ResultSet queryAll() throws Exception {
		statement = connection.createStatement();
		sql = "select * from interviewer";
		return statement.executeQuery(sql);
	}
	
}
