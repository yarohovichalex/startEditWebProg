package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.servis.BookService;

public class SearchBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "search";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    private static List<Book> listBook = new ArrayList<>();        

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        String name = request.getParameter("search");
        listBook = bookService.searchBookDao(name);        
        request.setAttribute("listbook", listBook);        
        return PAGE_ADMIN;
    }

}
