package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;

import com.mysql.cj.xdevapi.JsonArray;

import db.mysql.MySQLDBUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CreateDummyUsers {
	public static final int NUM = 100;
	
	public static final String DUMMY_USERS = "[{\n" + 
			"	        	    \"user_id\": \"0\",\n" + 
			"	        	    \"password\": \"ee6ce49420107f45af39050d7cb69322\",\n" + 
			"	        	    \"first_name\": \"Dummy0\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"1\",\n" + 
			"	        	    \"password\": \"60f9fdd03b313977ab1b90fdbb694e6a\",\n" + 
			"	        	    \"first_name\": \"Dummy1\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"2\",\n" + 
			"	        	    \"password\": \"e7a89f172ccd36dd9d384d95d4c1b154\",\n" + 
			"	        	    \"first_name\": \"Dummy2\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"3\",\n" + 
			"	        	    \"password\": \"09f99f99c7a72c779a15d06cedbeaa30\",\n" + 
			"	        	    \"first_name\": \"Dummy3\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"4\",\n" + 
			"	        	    \"password\": \"96d48a03db0b737046ad8c9e67603526\",\n" + 
			"	        	    \"first_name\": \"Dummy4\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"5\",\n" + 
			"	        	    \"password\": \"ce5f21caff649c1fc40a64212d61898b\",\n" + 
			"	        	    \"first_name\": \"Dummy5\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"6\",\n" + 
			"	        	    \"password\": \"6e20168ef3d5e024246a7155eff9630f\",\n" + 
			"	        	    \"first_name\": \"Dummy6\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"7\",\n" + 
			"	        	    \"password\": \"88f155839dcfb6a6b86a876a232a92c8\",\n" + 
			"	        	    \"first_name\": \"Dummy7\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"8\",\n" + 
			"	        	    \"password\": \"228e0092283fed0b2c80550e0c43cd16\",\n" + 
			"	        	    \"first_name\": \"Dummy8\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"9\",\n" + 
			"	        	    \"password\": \"80e30e383c9265e5a1057a67cf658790\",\n" + 
			"	        	    \"first_name\": \"Dummy9\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"10\",\n" + 
			"	        	    \"password\": \"55f53687cda7ce8629eca7d8990fb21e\",\n" + 
			"	        	    \"first_name\": \"Dummy10\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"11\",\n" + 
			"	        	    \"password\": \"4fac31f41fe7d859a6cfd035f7e10cc8\",\n" + 
			"	        	    \"first_name\": \"Dummy11\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"12\",\n" + 
			"	        	    \"password\": \"e1ac31a33e0b43d39e873cd63e42533b\",\n" + 
			"	        	    \"first_name\": \"Dummy12\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"13\",\n" + 
			"	        	    \"password\": \"58e514bc82b1c4642758a081282855dd\",\n" + 
			"	        	    \"first_name\": \"Dummy13\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"14\",\n" + 
			"	        	    \"password\": \"b99d2c4e2f00000989ccfa5a201b48fc\",\n" + 
			"	        	    \"first_name\": \"Dummy14\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"15\",\n" + 
			"	        	    \"password\": \"899903b4c4040137f084cfe2612da41d\",\n" + 
			"	        	    \"first_name\": \"Dummy15\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"16\",\n" + 
			"	        	    \"password\": \"b220416b1b17a0e48723ce9199007969\",\n" + 
			"	        	    \"first_name\": \"Dummy16\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"17\",\n" + 
			"	        	    \"password\": \"2c40ca7fb71c9f7e439433cef6cd30b0\",\n" + 
			"	        	    \"first_name\": \"Dummy17\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"18\",\n" + 
			"	        	    \"password\": \"8c2a8c4cb1e7d6b7d79c5e6a03e82cb2\",\n" + 
			"	        	    \"first_name\": \"Dummy18\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"19\",\n" + 
			"	        	    \"password\": \"c870b2c88cdab91e0578cee57a690c8e\",\n" + 
			"	        	    \"first_name\": \"Dummy19\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"20\",\n" + 
			"	        	    \"password\": \"7fb5fc82c8172ae3ff359d767325de59\",\n" + 
			"	        	    \"first_name\": \"Dummy20\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"21\",\n" + 
			"	        	    \"password\": \"0fcc1244ae61c6071e8e8c1866d92dfc\",\n" + 
			"	        	    \"first_name\": \"Dummy21\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"22\",\n" + 
			"	        	    \"password\": \"8edfe4f7a8efd0b8e9848011e3e11b4c\",\n" + 
			"	        	    \"first_name\": \"Dummy22\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"23\",\n" + 
			"	        	    \"password\": \"9c1cf84e3c92d5da79a7c27f5de11303\",\n" + 
			"	        	    \"first_name\": \"Dummy23\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"24\",\n" + 
			"	        	    \"password\": \"a589c417d161a9d49ad97b89ec38ae78\",\n" + 
			"	        	    \"first_name\": \"Dummy24\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"25\",\n" + 
			"	        	    \"password\": \"95ad596e94e4fd8e1872f7ff6df60b39\",\n" + 
			"	        	    \"first_name\": \"Dummy25\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"26\",\n" + 
			"	        	    \"password\": \"0da020e67f37c106bbd2e386bc304b84\",\n" + 
			"	        	    \"first_name\": \"Dummy26\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"27\",\n" + 
			"	        	    \"password\": \"18966232cc3adbe46585645c56aeb6d7\",\n" + 
			"	        	    \"first_name\": \"Dummy27\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"28\",\n" + 
			"	        	    \"password\": \"bb0f6919abe1749ed78417efeae3c285\",\n" + 
			"	        	    \"first_name\": \"Dummy28\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"29\",\n" + 
			"	        	    \"password\": \"d7b3fb393b2c2973cf8966dbf65b35d6\",\n" + 
			"	        	    \"first_name\": \"Dummy29\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"30\",\n" + 
			"	        	    \"password\": \"73418895ba1ed6a5600a26f4fd738d90\",\n" + 
			"	        	    \"first_name\": \"Dummy30\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"31\",\n" + 
			"	        	    \"password\": \"d366ac3a4bcb80cf985f93784181382e\",\n" + 
			"	        	    \"first_name\": \"Dummy31\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"32\",\n" + 
			"	        	    \"password\": \"3ea27c3c10c0ee6a00949dd1a82b90ed\",\n" + 
			"	        	    \"first_name\": \"Dummy32\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"33\",\n" + 
			"	        	    \"password\": \"f1f8a565dc9edf8ce53c91fbab27f9bf\",\n" + 
			"	        	    \"first_name\": \"Dummy33\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"34\",\n" + 
			"	        	    \"password\": \"59759c03a257e59c2002be59c38e8ffe\",\n" + 
			"	        	    \"first_name\": \"Dummy34\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"35\",\n" + 
			"	        	    \"password\": \"24e497268aeab942fa2f84325d03d8f2\",\n" + 
			"	        	    \"first_name\": \"Dummy35\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"36\",\n" + 
			"	        	    \"password\": \"33104e41511f618817c5d313d541eb5f\",\n" + 
			"	        	    \"first_name\": \"Dummy36\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"37\",\n" + 
			"	        	    \"password\": \"7a46782167b459b14805b66b34f21e6c\",\n" + 
			"	        	    \"first_name\": \"Dummy37\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"38\",\n" + 
			"	        	    \"password\": \"58761d1c41e6b2c8bb9f859019bf9006\",\n" + 
			"	        	    \"first_name\": \"Dummy38\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"39\",\n" + 
			"	        	    \"password\": \"ead1940ded4b715a85d3802406f3c0ee\",\n" + 
			"	        	    \"first_name\": \"Dummy39\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"40\",\n" + 
			"	        	    \"password\": \"0a99fe22bc734c3651cf9d571f5cae1a\",\n" + 
			"	        	    \"first_name\": \"Dummy40\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"41\",\n" + 
			"	        	    \"password\": \"b0309ca5b46c80b57572dd736a25734d\",\n" + 
			"	        	    \"first_name\": \"Dummy41\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"42\",\n" + 
			"	        	    \"password\": \"582205f0d18552528245a274413ed702\",\n" + 
			"	        	    \"first_name\": \"Dummy42\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"43\",\n" + 
			"	        	    \"password\": \"07daf07ec9f5625c0360cee473efacff\",\n" + 
			"	        	    \"first_name\": \"Dummy43\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"44\",\n" + 
			"	        	    \"password\": \"93a3622fd3752a33bfc0914aab8ea3c1\",\n" + 
			"	        	    \"first_name\": \"Dummy44\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"45\",\n" + 
			"	        	    \"password\": \"f68aa1bab28a521b1816df5684637486\",\n" + 
			"	        	    \"first_name\": \"Dummy45\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"46\",\n" + 
			"	        	    \"password\": \"effc35a6d5c46c3a5fa58a0d8f87dcfc\",\n" + 
			"	        	    \"first_name\": \"Dummy46\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"47\",\n" + 
			"	        	    \"password\": \"8ad73945812e61469473ebb85c62c567\",\n" + 
			"	        	    \"first_name\": \"Dummy47\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"48\",\n" + 
			"	        	    \"password\": \"2c7b3fe39cad9a083b9278354d7df38d\",\n" + 
			"	        	    \"first_name\": \"Dummy48\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"49\",\n" + 
			"	        	    \"password\": \"85a6aaae41d8f968a232fa0015e08ae1\",\n" + 
			"	        	    \"first_name\": \"Dummy49\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"50\",\n" + 
			"	        	    \"password\": \"cb5df8c6a20e658b62c56c1f4f6a8fef\",\n" + 
			"	        	    \"first_name\": \"Dummy50\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"51\",\n" + 
			"	        	    \"password\": \"22851cd5283d0a9142f9816534fd3274\",\n" + 
			"	        	    \"first_name\": \"Dummy51\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"52\",\n" + 
			"	        	    \"password\": \"e1b215a5bee747e30103416ef4252bdf\",\n" + 
			"	        	    \"first_name\": \"Dummy52\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"53\",\n" + 
			"	        	    \"password\": \"b3b0bc31c80619d0fda843801d374011\",\n" + 
			"	        	    \"first_name\": \"Dummy53\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"54\",\n" + 
			"	        	    \"password\": \"5f08b1f73fd1eb13769bf37d987badd1\",\n" + 
			"	        	    \"first_name\": \"Dummy54\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"55\",\n" + 
			"	        	    \"password\": \"84ccb1257b5ea029164312a5c6e6f74b\",\n" + 
			"	        	    \"first_name\": \"Dummy55\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"56\",\n" + 
			"	        	    \"password\": \"e6d2eb5750e95452884f4387f9045b2c\",\n" + 
			"	        	    \"first_name\": \"Dummy56\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"57\",\n" + 
			"	        	    \"password\": \"256fa4f3bb02f318ae66a7eeb389bdba\",\n" + 
			"	        	    \"first_name\": \"Dummy57\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"58\",\n" + 
			"	        	    \"password\": \"342736a75582634037d63d92916fd99b\",\n" + 
			"	        	    \"first_name\": \"Dummy58\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"59\",\n" + 
			"	        	    \"password\": \"4a14d2919dcabee9825c65d8aa28f75e\",\n" + 
			"	        	    \"first_name\": \"Dummy59\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"60\",\n" + 
			"	        	    \"password\": \"c7af7389ab6dfefcc75f4c1b6555ec33\",\n" + 
			"	        	    \"first_name\": \"Dummy60\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"61\",\n" + 
			"	        	    \"password\": \"218a7a42634b8b34d76807c26abb3a15\",\n" + 
			"	        	    \"first_name\": \"Dummy61\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"62\",\n" + 
			"	        	    \"password\": \"8e4958d4571dd66db19fec46c18b1fd6\",\n" + 
			"	        	    \"first_name\": \"Dummy62\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"63\",\n" + 
			"	        	    \"password\": \"23e8963a35cbec10054c0b772700ff88\",\n" + 
			"	        	    \"first_name\": \"Dummy63\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"64\",\n" + 
			"	        	    \"password\": \"cc7f11f18ec295a1128ad587d1f505b4\",\n" + 
			"	        	    \"first_name\": \"Dummy64\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"65\",\n" + 
			"	        	    \"password\": \"3b71924e12df2c5338565a1aff52bb0c\",\n" + 
			"	        	    \"first_name\": \"Dummy65\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"66\",\n" + 
			"	        	    \"password\": \"22c59dd2caa60688bbadae79b3ecf8f5\",\n" + 
			"	        	    \"first_name\": \"Dummy66\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"67\",\n" + 
			"	        	    \"password\": \"51124e9fdbb6b7050c63a5fb30289551\",\n" + 
			"	        	    \"first_name\": \"Dummy67\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"68\",\n" + 
			"	        	    \"password\": \"6cf390781d2837ba0322fed6f7e18e3b\",\n" + 
			"	        	    \"first_name\": \"Dummy68\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"69\",\n" + 
			"	        	    \"password\": \"2abb987c57c44554d3a36379f64def92\",\n" + 
			"	        	    \"first_name\": \"Dummy69\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"70\",\n" + 
			"	        	    \"password\": \"dec2dbe1f9d520c7fa72bff31cfa2200\",\n" + 
			"	        	    \"first_name\": \"Dummy70\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"71\",\n" + 
			"	        	    \"password\": \"c9560e3f461ded92f85939a9edafa39d\",\n" + 
			"	        	    \"first_name\": \"Dummy71\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"72\",\n" + 
			"	        	    \"password\": \"705bb112ccbccbbf663a8524bc101ff2\",\n" + 
			"	        	    \"first_name\": \"Dummy72\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"73\",\n" + 
			"	        	    \"password\": \"abff42e82a356cadc27a933a7bb755b6\",\n" + 
			"	        	    \"first_name\": \"Dummy73\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"74\",\n" + 
			"	        	    \"password\": \"e632ab011b93119ebf6cd23324a6f674\",\n" + 
			"	        	    \"first_name\": \"Dummy74\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"75\",\n" + 
			"	        	    \"password\": \"72687ffa0e987a546d4be60c0579f196\",\n" + 
			"	        	    \"first_name\": \"Dummy75\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"76\",\n" + 
			"	        	    \"password\": \"c846dd1e4092226d865ab26b6b81f2fc\",\n" + 
			"	        	    \"first_name\": \"Dummy76\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"77\",\n" + 
			"	        	    \"password\": \"3cc88c42378ecda0d7aa8bf9891590e9\",\n" + 
			"	        	    \"first_name\": \"Dummy77\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"78\",\n" + 
			"	        	    \"password\": \"33714529b56116fcfffd679dafc57b3d\",\n" + 
			"	        	    \"first_name\": \"Dummy78\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"79\",\n" + 
			"	        	    \"password\": \"cc1a810cf85b3e4822ef2371dd5cac59\",\n" + 
			"	        	    \"first_name\": \"Dummy79\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"80\",\n" + 
			"	        	    \"password\": \"49a63636619d91dd7de6e3943ba129ae\",\n" + 
			"	        	    \"first_name\": \"Dummy80\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"81\",\n" + 
			"	        	    \"password\": \"70ea5f05c7fca9fe55d59fe2717053df\",\n" + 
			"	        	    \"first_name\": \"Dummy81\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"82\",\n" + 
			"	        	    \"password\": \"2dfb7c94ab2d640fd373f1e4b045b5c8\",\n" + 
			"	        	    \"first_name\": \"Dummy82\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"83\",\n" + 
			"	        	    \"password\": \"2f2caf1027fdf38614d4ffbd16ccdcbd\",\n" + 
			"	        	    \"first_name\": \"Dummy83\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"84\",\n" + 
			"	        	    \"password\": \"dc4430cb02d1677f2092961bcaf3bd14\",\n" + 
			"	        	    \"first_name\": \"Dummy84\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"85\",\n" + 
			"	        	    \"password\": \"56e827c87a136032e7346964012ea73a\",\n" + 
			"	        	    \"first_name\": \"Dummy85\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"86\",\n" + 
			"	        	    \"password\": \"aee2a12ec44544d9e32df17f49791e2e\",\n" + 
			"	        	    \"first_name\": \"Dummy86\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"87\",\n" + 
			"	        	    \"password\": \"88d02145565e8ad3ee3afe430c40f6ff\",\n" + 
			"	        	    \"first_name\": \"Dummy87\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"88\",\n" + 
			"	        	    \"password\": \"6a7a09c403d09f5f91262f5efd5dcf7e\",\n" + 
			"	        	    \"first_name\": \"Dummy88\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"89\",\n" + 
			"	        	    \"password\": \"206b843b670a0cfcdec450f585343b16\",\n" + 
			"	        	    \"first_name\": \"Dummy89\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"90\",\n" + 
			"	        	    \"password\": \"91a9bbf0ba1fb116e7b5fbacc31d1f42\",\n" + 
			"	        	    \"first_name\": \"Dummy90\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"91\",\n" + 
			"	        	    \"password\": \"19c1abb98b038db43aa38fa2d175c9d5\",\n" + 
			"	        	    \"first_name\": \"Dummy91\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"92\",\n" + 
			"	        	    \"password\": \"2eb2c9617f0a1dbeda3ab38bea84f83b\",\n" + 
			"	        	    \"first_name\": \"Dummy92\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"93\",\n" + 
			"	        	    \"password\": \"7a5dd280f4bca71aa79345622e2d17d9\",\n" + 
			"	        	    \"first_name\": \"Dummy93\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"94\",\n" + 
			"	        	    \"password\": \"4d8ac06147144d596c049dddc1d79a77\",\n" + 
			"	        	    \"first_name\": \"Dummy94\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"95\",\n" + 
			"	        	    \"password\": \"cb9fbeb61c44c5e36be365c5003af96c\",\n" + 
			"	        	    \"first_name\": \"Dummy95\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"96\",\n" + 
			"	        	    \"password\": \"95931234d61e6b375d462f4977adbed0\",\n" + 
			"	        	    \"first_name\": \"Dummy96\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"97\",\n" + 
			"	        	    \"password\": \"4acab41e9933b92e5b1a2e1b00748cd9\",\n" + 
			"	        	    \"first_name\": \"Dummy97\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"98\",\n" + 
			"	        	    \"password\": \"5f02b14855f0e4e8bd0ce6af9bc98bcd\",\n" + 
			"	        	    \"first_name\": \"Dummy98\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  },\n" + 
			"	        	  {\n" + 
			"	        	    \"user_id\": \"99\",\n" + 
			"	        	    \"password\": \"41a9b98f6f4fce2ffbb53f5fa978df12\",\n" + 
			"	        	    \"first_name\": \"Dummy99\",\n" + 
			"	        	    \"last_name\": \"D\"\n" + 
			"	        	  }\n" + 
			"	]";
	
	// Run this as Java application to create dummy users.
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
			createUsers(conn);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createUsers(Connection conn) throws Exception {
		List<List<String>> users = getUsers();
		for (List<String> user : users) {
			String sql = "INSERT INTO users (user_id, password, first_name, last_name) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.get(0));
			ps.setString(2, user.get(1));
			ps.setString(3, user.get(2));
			ps.setString(4, user.get(3));
			ps.execute();
		}
	}
	
	private static List<List<String>> getUsers() {
		List<List<String>> res = new ArrayList<>();
		
		try {
			JSONArray array = new JSONArray(DUMMY_USERS);
			
			for (int i = 0; i < array.length(); ++i) {
				res.add(Arrays.asList(
						array.getJSONObject(i).getString("user_id"),
						array.getJSONObject(i).getString("password"),
						array.getJSONObject(i).getString("first_name"),
						array.getJSONObject(i).getString("last_name")
						));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
