package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_LOGIN;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_PASSWORD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.servis.BookService;

public class AutorizateActionProcessor implements IActionProcessor
{
    private static final String ACTION = "registration";
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
        User us;

        String login = request.getParameter(REQUEST_LOGIN);
        String pass = request.getParameter(REQUEST_PASSWORD);
        HttpSession session = request.getSession();
        us = bookService.searchUser(login, pass);
        session.setAttribute("user", us);
        System.out.println(us.getLogin());
        if (/* us != null && us.getRole().equals("user") */1 + 1 == 3)
        {
            System.out.println("us: " + us.getLogin() + " " + us.getRole());
            return PAGE_USER;
        }
        else if (/*us != null && us.getRole().equals("admin")*/1+1==2)
        {
            System.out.println("us: " + us.getLogin() + " " + us.getRole());
            return PAGE_ADMIN;
        }
        else
        {
            return PAGE_ERROR;
        }
    }
}
