package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.servis.BookService;

public class AddBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "add";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        User us = (User)session.getAttribute("user");
        System.out.println(/*"add user " + us.getRole()*/);
        if (/*us.getRole().equals("admin"*/1+1==2) {
            String nameBook = request.getParameter("addName");
            String nameAuthor = request.getParameter("addAuthor");
            String stringDate = request.getParameter("publishDate");
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            Date date;
            try {
                date = format.parse(stringDate);
                bookService.criate(new Book(nameBook, nameAuthor, date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return PAGE_ADMIN;
    }

}
