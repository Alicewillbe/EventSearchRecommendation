package rpc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;

/**
 * Servlet implementation class ItemHistory
 */
@WebServlet("/history")
public class ItemHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("user_id");
		JSONArray array = new JSONArray();

		DBConnection conn = DBConnectionFactory.getConnection();
		try {
			Set<Item> items = conn.getFavoriteItems(userId);
			
			for (Item item : items) {
				JSONObject obj = item.toJSONObject();
				array.put(obj);
			}

			RpcHelper.writeJsonArray(response, array);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnection connection = DBConnectionFactory.getConnection();
	  	try {
	  		JSONObject input = RpcHelper.readJSONObject(request);
	  		String userId = input.getString("user_id");
	  		JSONArray array = input.getJSONArray("favorite");
	  		boolean isLikeBtn = input.getBoolean("isLikeBtn");
	  		
	  		List<String> itemIds = new ArrayList<>();
	  		for(int i = 0; i < array.length(); ++i) {
	  			itemIds.add(array.getString(i));
	  		}
	  		List<Boolean> arrayRes = connection.updateLikeIt(userId, itemIds, isLikeBtn);
	  		
	  		array = new JSONArray();
        	for (Boolean bool : arrayRes) {
        		array.put(bool);
        	}
	  		RpcHelper.writeJsonObject(response, new JSONObject()
	  				.put("array", array).put("result", "SUCCESS"));
	  	} catch (Exception e) {
	  		e.printStackTrace();
	  	} finally {
	  		connection.close();
	  	}
	}
}