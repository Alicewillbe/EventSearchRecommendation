package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.mysql.MySQLDBUtil;
import utils.CreateDummyItems;
import utils.CreateDummyLikes;
import utils.CreateDummyUsers;

public class TestCheckLikeIt {
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
			CreateDummyUsers.createUsers(conn);
			
			// Step 3 Create Items
			CreateDummyItems.createItems(conn);
			
			// Step 4 Create Likes
			CreateDummyLikes.createLikesNaive(conn);
			System.out.println(test(conn, 50,50, true));
			System.out.println(test(conn, 50,51, false));
			System.out.println(test(conn, 50,49, null));
			
			update(conn, 50,50,false);
			System.out.println(test(conn, 50,50,false));
			
			update(conn, 50,51,true);
			System.out.println(test(conn, 50,51,true));
			
			update(conn, 50,49,true);
			System.out.println(test(conn, 50,49,true));
			
			update(conn, 50,48,false);
			System.out.println(test(conn, 50,48,false));
			
			update(conn, 50,50,false);
			System.out.println(test(conn, 50,50,null));
			
			update(conn, 50,51,true);
			System.out.println(test(conn, 50,51,null));
			
			conn.close();
			System.out.println("Test Succeeded");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed");
		} finally {
			System.out.println("Test Closed");
		}
	}
	
	private static boolean test(Connection conn, 
			int user_id, 
			int item_id, 
			Boolean likeIt) throws Exception {
		String sql = "SELECT * FROM history WHERE user_id = ? AND item_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(user_id));
		ps.setString(2, String.valueOf(item_id));
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return likeIt != null && rs.getBoolean("like_it") == likeIt;
		} else {
			return likeIt == null;
		}
	}
	
	private static void update(Connection conn, 
			int user_id, 
			int item_id, 
			Boolean likeIt) throws Exception {
		String sql = "SELECT * FROM history WHERE user_id = ? AND item_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(user_id));
		ps.setString(2, String.valueOf(item_id));
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			Boolean res = rs.getBoolean("like_it");
			if (res == likeIt) {
				// case 1.1: (Delete) the pair is in history and new choice is different than before
				deleteHistory(conn, user_id, item_id, likeIt);
			} else {
				// case 1.2: (Overwrite) the pair is in history and new choice is different than before
				updateHistory(conn, user_id, item_id, likeIt);
			}	
		} else {
			// case 2: no opinion in database
			// (Insert) the pair is not yet in history
			insertHistory(conn, user_id, item_id, likeIt);
		}
	}
	
	private static void insertHistory (Connection conn, 
			int user_id, 
			int item_id, 
			Boolean likeIt) throws Exception {
		String sql = "INSERT IGNORE INTO history (user_id, item_id, like_it) " + 
				"VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(user_id));
		ps.setString(2, String.valueOf(item_id));
		ps.setBoolean(3, likeIt);
		ps.execute();	
	}
	
	private static void deleteHistory (Connection conn, 
			int user_id, 
			int item_id, 
			Boolean likeIt) throws Exception {
		String sql = "DELETE FROM history WHERE user_id = ? AND item_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(user_id));
		ps.setString(2, String.valueOf(item_id));
		ps.execute();	
	}
	
	private static void updateHistory(Connection conn, 
			int user_id, 
			int item_id, 
			Boolean likeIt) throws Exception {
		String sql = "UPDATE history SET like_it = ? WHERE user_id = ? AND item_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBoolean(1, likeIt);
		ps.setString(2, String.valueOf(user_id));
		ps.setString(3, String.valueOf(item_id));
		ps.execute();
	}
}
