package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class AddBookImpl implements BaseAction {

	public AddBookImpl() {
		super();
	}

	private BookService servis = new BookService();

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User)session.getAttribute("user");
		System.out.println("add user " + us.getRole());
		if (us.getRole().equals("admin")) {
			String nameBook = request.getParameter("addName");
			String nameAuthor = request.getParameter("addAuthor");
			String stringDate = request.getParameter("publishDate");
			SimpleDateFormat format = new SimpleDateFormat();
			format.applyPattern("yyyy-MM-dd");
			Date date;
			try {
				date = format.parse(stringDate);
				servis.criate(new Book(nameBook, nameAuthor, date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return PAGE_ADMIN;
	}
}
