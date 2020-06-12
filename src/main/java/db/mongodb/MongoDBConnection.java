package db.mongodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

import db.DBConnection;
import entity.Item;
import entity.Item.ItemBuilder;
import external.TicketMasterClient;

public class MongoDBConnection implements DBConnection {
	private MongoClient mongoClient;
	private MongoDatabase db;
	
	public MongoDBConnection() {
		this.mongoClient = MongoClients.create();
		this.db = mongoClient.getDatabase(MongoDBUtil.DB_NAME);
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (mongoClient != null) {
			mongoClient.close();
		}
	}

	@Override
	public void setFavoriteItems(String userId, List<String> itemIds) {
		// TODO Auto-generated method stub
		if (db == null) {
			return;
		}
		db.getCollection("users").updateOne(eq("user_id", userId),
				new Document("$push", 
						new Document("favorite", 
								new Document("$each", itemIds))));
	}

	@Override
	public void unsetFavoriteItems(String userId, List<String> itemIds) {
		// TODO Auto-generated method stub
		if (db == null) {
			return;
		}
		db.getCollection("users").updateOne(eq("user_id", userId), 
				new Document("$pullAll", 
						new Document("favorite", itemIds)));
	}

	@Override
	public Set<String> getFavoriteItemIds(String userId) {
		// TODO Auto-generated method stub
		if (db == null) {
			return new HashSet<>();
		}
		Set<String> favoriteItems = new HashSet<>();
		FindIterable<Document> iterable = db.getCollection("users").find(eq("user_id", userId));
		
		if (iterable.first() != null && iterable.first().containsKey("favorite")) {
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) iterable.first().get("favorite");
			favoriteItems.addAll(list);
		}

		return favoriteItems;
	}

	@Override
	public Set<Item> getFavoriteItems(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getCategories(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> searchItems(double lat, double lon, String term) {
		// TODO Auto-generated method stub
		TicketMasterClient ticketMasterClient = new TicketMasterClient();
	    List<Item> items = ticketMasterClient.search(lat, lon, term);
	
	    for(Item item : items) {
	    	saveItem(item);
	    }
	
	    return items;
	}

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		if (db == null) {
			return;
		}
		FindIterable<Document> iterable = db.getCollection("items").find(eq("item_id", item.getItemId()));
		if (iterable.first() == null) {
			db.getCollection("items")
					.insertOne(new Document()
							.append("item_id", item.getItemId())
							.append("distance", item.getDistance())
							.append("name", item.getName())
							.append("address", item.getAddress())
							.append("url", item.getUrl())
							.append("image_url", item.getImageUrl())
							.append("rating", item.getRating())
							.append("categories", item.getCategories()));
		}
	}

	@Override
	public String getFullname(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyLogin(String userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(String userId, String password, String firstname, String lastname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkLikeIt(String userId, Collection<Item> items) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<Boolean> updateLikeIt(String userId, List<String> itemIds, boolean isLikeBtn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void getRating(Collection<Item> items) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public List<Float> calculateRating(List<String> itemIds) {
		// TODO Auto-generated method stub
		return null;
	}
}
