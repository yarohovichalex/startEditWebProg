package by.htp.controller.action.imple;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_EDIT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.controller.action.BaseAction;

public class ToEditBookPage implements BaseAction{
	
	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user");
		System.out.println(us.getLogin() + " login");
		request.setAttribute("user_name", us.getLogin());		
		int f= Integer.parseInt(request.getParameter("book_id2"));
		String bookName = request.getParameter("bookName");		
		String author = request.getParameter("authorName");
		//TODO String date = request.getParameter("date");

		
//			request.setAttribute("edit_book_id", f);
//			request.setAttribute("book_value", bookName);
//			request.setAttribute("author_value", author);
			request.setAttribute("author_value1", "lulu");

		return PAGE_EDIT;
	}
	
}
