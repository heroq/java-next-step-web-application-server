package webserver;

import java.util.Map;

import db.DataBase;
import model.User;

public class RequestCreate {
	public static void create( Map<String, String> user) {
		String userId = user.get("userId");
		String password = user.get("password");
		String name = user.get("name");
		String email = user.get("email");
		DataBase.addUser(new User(userId, password, name, email));
	}
}
