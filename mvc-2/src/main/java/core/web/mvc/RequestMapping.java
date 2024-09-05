package core.web.mvc;

import java.util.HashMap;
import java.util.Map;

import core.web.controller.CreateUserController;
import core.web.controller.FrontController;
import core.web.controller.JsonListUserController;
import core.web.controller.ListUserController;
import core.web.controller.UpdateUserController;
import core.web.controller.UpdateUserFormController;

public class RequestMapping {

	private Map<String, Controller> controllerMap = new HashMap<String, Controller>();

	void init() {
		controllerMap.put("/", new FrontController("/index.jsp"));
		controllerMap.put("/users/form", new FrontController("/user/form.html"));
		controllerMap.put("/users/loginForm", new FrontController("/user/login.jsp"));
		controllerMap.put("/users/create", new CreateUserController());
		controllerMap.put("/users/updateForm", new UpdateUserFormController());
		controllerMap.put("/users/update", new UpdateUserController());
		controllerMap.put("/users", new ListUserController());

		controllerMap.put("/users/list/json", new JsonListUserController());
	}

	public Controller getController(String name) {
		return controllerMap.get(name);
	}

	public void putController(String name, Controller controller) {
		controllerMap.put(name, controller);
	}
}
