package recommendation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;

public class CollaborativeFiltering {
	public List<Item> recommendItems(String userId, double lat, double lon) {
		List<Item> recommendedItems = new ArrayList<>();

		
		DBConnection connection = DBConnectionFactory.getConnection();
		
		// step 1: find similar users
		
		// step 2: find 
		
		connection.close();
		return recommendedItems;
	}
}
