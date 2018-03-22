package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class DeleteBook implements BaseAction {

	private BookService servis = new BookService();

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete!!!");
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user");
		if(us.getRole().equals("admin")) {
			int f = Integer.parseInt(request.getParameter("book_id"));
			servis.delete(f);
		}
		return PAGE_ADMIN;
	}

}
