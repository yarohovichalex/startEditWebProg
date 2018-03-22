package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.servis.BookService;

public class OutputAllBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "output";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    List<Book> list = new ArrayList<>();
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        list = bookService.outputBook();             
        request.setAttribute("listbook", list);     
        System.out.println(list.size() + " size");
        return PAGE_ADMIN;
    }

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

}
