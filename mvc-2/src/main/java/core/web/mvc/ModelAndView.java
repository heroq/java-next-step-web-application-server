package core.web.mvc;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private final View view;
	private Map<String, Object> model = new HashMap<>();

	public ModelAndView(View view) {
		this.view = view;
	}

	public ModelAndView(View view, Map<String, Object> model) {
		this.view = view;
		this.model = model;
	}

	public ModelAndView addModel(String key, Object value) {
		this.model.put(key, value);
		return this;
	}

	public Map<String, Object> getModel() {
		return this.model;
	}

	public View getView() {
		return this.view;
	}
}
