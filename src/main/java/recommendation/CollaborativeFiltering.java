package recommendation;

import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;

public class CollaborativeFiltering {
	public List<Item> recommendItems(String userId, double lat, double lon) {
		List<Item> recommendedItems = new ArrayList<>();

		
		DBConnection connection = DBConnectionFactory.getConnection();
		
		// step 1: find similar users & get score for this users to rate unchosen items
		
		
		connection.close();
		return recommendedItems;
	}
}
