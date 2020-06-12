package db;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import entity.Item;


public interface DBConnection {
	/**
	 * Close the connection.
	 */
	public void close();

	/**
	 * Insert the favorite items for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void setFavoriteItems(String userId, List<String> itemIds);

	/**
	 * Delete the favorite items for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void unsetFavoriteItems(String userId, List<String> itemIds);

	/**
	 * Get the favorite item id for a user.
	 * 
	 * @param userId
	 * @return itemIds
	 */
	public Set<String> getFavoriteItemIds(String userId);

	/**
	 * Get the favorite items for a user.
	 * 
	 * @param userId
	 * @return items
	 */
	public Set<Item> getFavoriteItems(String userId);

	/**
	 * Gets categories based on item id
	 * 
	 * @param itemId
	 * @return set of categories
	 */
	public Set<String> getCategories(String itemId);

	/**
	 * Search items near a geolocation and a term (optional).
	 * 
	 * @param userId
	 * @param lat
	 * @param lon
	 * @param term
	 *            (Nullable)
	 * @return list of items
	 */
	public List<Item> searchItems(double lat, double lon, String term);

	/**
	 * Save item into db.
	 * 
	 * @param item
	 */
	public void saveItem(Item item);

	/**
	 * Get full name of a user. (This is not needed for main course, just for demo
	 * and extension).
	 * 
	 * @param userId
	 * @return full name of the user
	 */
	public String getFullname(String userId);

	/**
	 * Return whether the credential is correct. (This is not needed for main
	 * course, just for demo and extension)
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean verifyLogin(String userId, String password);
	
	/**
	 * Register one user
	 * 
	 * @param userId
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @return boolean - true if the user register successfully, false if user fail to register
	 */
	public boolean registerUser(String userId, String password, String firstname, String lastname);
	
	/**
	 * check what are items previously rated by user
	 * 
	 * @param userId
	 * @param items
	 * @modify item in items if it is previously rated
	 */
	public void checkLikeIt(String userId, Collection<Item> items);
	
	
	/**
	 * try to update the opinion user has on items to isLikeBtn
	 * if user used to have same opinion, then cancel it
	 * 
	 * @param userId
	 * @param itemIds
	 * @param isLikeBtn
	 * @return List<Boolean> - 
	 *          first element shows whether the update is successful
	 *          
	 *          for rest element, each maps to the result of items
	 *          true if user then likes this item
	 *          false if user then dislikes this item
	 *          null if user then neutral on this item
	 */
	public List<Boolean> updateLikeIt(String userId, List<String> itemIds, boolean isLikeBtn);
}