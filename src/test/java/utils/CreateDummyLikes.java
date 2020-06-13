package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CreateDummyLikes {
	public static final int NUM = 100;
	
	public static void createLikes(Connection conn) throws Exception {
		int itemNum = NUM;
		
		// to keep the foreign key constraints
		String sql = "INSERT IGNORE INTO history (user_id, item_id, like_it) " + 
				"SELECT users.user_id, items.item_id, true " + 
				"FROM users, items " + 
				"WHERE users.user_id = items.item_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = "INSERT IGNORE INTO history (user_id, item_id, like_it) " + 
				"SELECT users.user_id, items.item_id, false " + 
				"FROM users, items " + 
				"WHERE users.user_id + 1 = items.item_id";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
	}
	
	public static void createLikesNaive(Connection conn) throws Exception {
		int itemNum = NUM;
		
		// to keep the foreign key constraints
		for (int i = 0; i < itemNum; i++) {
			int user_id = i;
			int item_id = i;
			String sql = "INSERT IGNORE INTO history (user_id, item_id, like_it) " + 
					"VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(user_id));
			ps.setString(2, String.valueOf(item_id));
			ps.setBoolean(3, true);
			ps.execute();	
			
			item_id = i + 1;
			sql = "INSERT IGNORE INTO history (user_id, item_id, like_it) " + 
					"VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(user_id));
			ps.setString(2, String.valueOf(item_id));
			ps.setBoolean(3, false);
			ps.execute();	
		}
	}
}
