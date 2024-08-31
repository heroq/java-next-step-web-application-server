package http;

import java.util.HashMap;
import java.util.Map;

public class HttpSession {
	Map<String, Object> values = new HashMap<>();

	private final String id;

	public HttpSession(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setAttribute(String key, Object value) {
		values.put(key, value);
	}

	public Object getAttribute(String key) {
		return values.get(key);
	}

	public void removeAttribute(String key) {
		values.remove(key);
	}

	public void invalidate() {
		values.clear();
	}
}
