package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.servis.BookService;

public class EditActionProcessor implements IActionProcessor
{
    private static final String ACTION = "edit";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getAttribute("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        String editBookName = (String) session.getAttribute("BookNameIntoEditPage");
        String editAuthorName = (String) session.getAttribute("AuthorNameIntoEditPage");
        String editStringDate = (String) session.getAttribute("PrintDateIntoEditPage");
        int bookId = Integer.parseInt((String) session.getAttribute("BookIdIntoEditPage"));

        session.setAttribute("author_value", editAuthorName);
        session.setAttribute("book_value", editBookName);
//        session.setAttribute("date_value", editStringDate);




        try
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(editStringDate);
            session.setAttribute("date_value", editStringDate);
            bookService.editBook(bookId, new Book(editBookName, editAuthorName, date));
            return PAGE_ADMIN;
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException(e);
        }
    }
}
