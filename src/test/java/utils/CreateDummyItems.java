package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateDummyItems {
	public static void createItems(Connection conn) throws Exception {
		List<String> itemIds = getItems();
		for (String itemId : itemIds) {
			String sql = "INSERT IGNORE INTO items (item_id) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemId);
			ps.execute();
		}
	}
	
	private static List<String> getItems() {
		List<String> res = new ArrayList<>();
		
		int itemNum = 100;
		
		for (int i = 0; i < itemNum; i++) {
			String itemId = "" + i;
			res.add(itemId);
			
			System.out.println(itemId);
		}
		
		return res;
	}
}
