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
import by.htp.controller.action.BaseAction;
import by.htp.servis.BookService;

public class EditBookPage implements BaseAction {

	private BookService servis = new BookService();

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
		String bookid = request.getParameter("edit_book_id");
		int f = Integer.parseInt(bookid);
		String editBookName = (String) session.getAttribute("BookNameIntoEditPage");
		
		String editAuthorName = request.getParameter("editAuthor");
		session.setAttribute("editAuthorName", (String)session.getAttribute("AuthorNameIntoEditPage"));
		String editStringDate = request.getParameter("editDate");
	    session.setAttribute("editAuthorName", (String)session.getAttribute("AuthorNameIntoEditPage"));

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(editStringDate);
			servis.editBook(f, new Book(editBookName, editAuthorName, date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return PAGE_ADMIN;
	}

}
