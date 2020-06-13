package recommendation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;

public class NaiveRanking {
	public List<Item> rankItems(String userId, List<Item> items) {
		Collections.sort(items,
				(a, b) -> {
					if (Double.compare(a.getRating(), b.getRating()) == 0) {
						// a == b
						if (a.getLikeIt() == null && b.getLikeIt() == null ||
						    (a.getLikeIt() != null && a.getLikeIt() == b.getLikeIt())) {
							return 0;
						}
						
						// a != b
						// a prior to b
						if (a.getLikeIt() != null && a.getLikeIt() == true ||
							(a.getLikeIt() == null && b.getLikeIt() == false)) {
							return -1;
						}
						
						// b prior to a
						return 1;
					}
					
					return  Double.compare(b.getRating(), a.getRating());
				});
		return items;
	}
}
