package src;

import java.util.Scanner;
import java.sql.ResultSet;

public class Interviewer {
	private static DBInterviewerController controller;
	private static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {
		controller = new DBInterviewerController();
		try {
			String url = "jdbc:mysql://localhost:3306/";
			controller.dbaseConnect(url, "root", "");
			controller.useDatabase("employees");
			ResultSet rs = controller.queryAll();
			System.out.println(rs);
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e);
		}
	}
}
