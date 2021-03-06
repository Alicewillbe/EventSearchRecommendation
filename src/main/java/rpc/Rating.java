package rpc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;

/**
 * Servlet implementation class Rating
 */
@WebServlet("/rating")
public class Rating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnection connection = DBConnectionFactory.getConnection();
	  	try {
	  		JSONObject input = RpcHelper.readJSONObject(request);
	  		JSONArray array = input.getJSONArray("item_ids");
	  		
	  		List<String> itemIds = new ArrayList<>();
	  		for(int i = 0; i < array.length(); ++i) {
	  			itemIds.add(array.getString(i));
	  		}
	  		
	  		List<Float> arrayRes = connection.calculateRating(itemIds);
	  		
	  		array = new JSONArray();
        	for (Float num : arrayRes) {
        		array.put(num);
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
