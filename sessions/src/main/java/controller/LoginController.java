package controller;

import model.User;
import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;

public class LoginController extends AbstractController {
    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));
        if(user == null || !user.login(request.getParameter("password"))) {
            response.sendRedirect("/user/login_failed.html");
            request.getSession().invalidate();
            return;
        }

        request.getSession().setAttribute("logined", "true");
        response.sendRedirect("/index.html");
    }
}
