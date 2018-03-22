package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_LOGIN;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_PASSWORD;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class Autorizate extends User implements BaseAction {

	public Autorizate() {

	}

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User us;

		String login = request.getParameter(REQUEST_LOGIN);
		String pass = request.getParameter(REQUEST_PASSWORD);
		System.out.println(pass);
		System.out.println(login);

		BookService servis = new BookService();
		HttpSession session = request.getSession();

		us = servis.searchUser(login, pass);
		session.setAttribute("user", us);
		System.out.println( us.getLogin());
		if (us != null && us.getRole().equals("user")) {
			System.out.println("us: " + us.getLogin() + " " + us.getRole());
			return PAGE_USER;
		} else if (us != null && us.getRole().equals("admin")) {
			System.out.println("us: " + us.getLogin() + " " + us.getRole());
			return PAGE_ADMIN;
		} else {
			return PAGE_ERROR;
		}
	}

}
