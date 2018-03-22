package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class SearchBookImpl implements BaseAction{
	private List<Book> listBook = new ArrayList<>();		
	private BookService servis = new BookService(); 


	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		listBook = servis.searchBookDao(name);
		
		System.out.println("razmer: " + listBook.size());		
		request.setAttribute("listbook", listBook);		
		
		return PAGE_ADMIN;
	}
	
}
