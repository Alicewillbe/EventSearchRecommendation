package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import db.mysql.MySQLDBUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CreateDummyUsers {
	// Run this as Java application to create dummy users.
	public static void main(String[] args) {
		try {
			// Step 1 Connect to MySQL.
			System.out.println("Connecting to " + MySQLDBUtil.URL);
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			Connection conn = DriverManager.getConnection(MySQLDBUtil.URL);
			
			if (conn == null) {
				return;
			}
			
			// Step 2 Create Users
			createUsers(conn);
			
			conn.close();
			System.out.println("Test Succeeded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createUsers(Connection conn) throws Exception {
		Statement statement = conn.createStatement();
		List<List<String>> users = getUsers();
		for (List<String> user : users) {
			String sql = "INSERT INTO users (user_id, password, first_name, last_name)"
					+ "VALUES ('" + user.get(0) + "', '" + user.get(1) + "', 'jack', 'Ron')";
			statement.executeUpdate(sql);
		}
	}
	
	private static List<List<String>> getUsers() {
		List<List<String>> res = new ArrayList<>();
		
		int userNum = 100;
		
		for (int i = 0; i < userNum; i++) {
			String username = "" + i;
			String password_naive = "" + (i + 1);
			//String password = encryptPassword(username, password_naive);
			res.add(Arrays.asList(username, password_naive));
			
			System.out.println(username);
			System.out.println(password_naive);
		}
		
		return res;
	}
	
	private static String encryptPassword(String username, String password) {
		String res = null;
		
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] passwordBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
		    md.reset();
		    byte[] resBytes = md.digest(
		    		username.concat(
		    				new String(passwordBytes)).getBytes(StandardCharsets.UTF_8));
		
  		    res = new String(resBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
