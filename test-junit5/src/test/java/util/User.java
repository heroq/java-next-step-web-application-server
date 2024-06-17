package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import db.DataBase;

public class User {
	@Test
	@DisplayName("회원가입")
	public void create() {
		Map<String, String> user = new HashMap<>() {
			{
				this.put("userId", "nextstepId");
				this.put("password", "password");
				this.put("name", "황만득");
				this.put("email", "nextstep@gmail.com");
			}
		};

		String userId = user.get("userId");
		String password = user.get("password");
		String name = user.get("name");
		String email = user.get("email");
		model.User newUser = new model.User(userId, password, name, email);
		DataBase.addUser(newUser);

		assertEquals(DataBase.findUserById("nextstepId"), newUser);
	}

	@Test
	public void create_null() {
		Map<String, String> user = new HashMap<>();
		assertTrue(user.isEmpty());
	}
}
