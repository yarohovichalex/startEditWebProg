package by.htp.controller;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.controller.action.test.IActionProcessor;
import by.htp.controller.action.test.ProcessorsSingleton;

public class ActionManager
{

    public static void defineServerAction(String action, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        Optional<IActionProcessor> foundProcessor = ProcessorsSingleton.getProcessors().stream()
                .filter(e -> e.isAllowed(request)).findFirst();
        String defaultPage = PAGE_ERROR;
        System.out.println(request.getAttribute("action") + " ne vosh " + request.getMethod());
        if (foundProcessor.isPresent())
        {
            System.out.println(" !!vosh!! ");
            defaultPage = foundProcessor.get().process(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(defaultPage);
        dispatcher.forward(request, response);

        // BaseAction act = null;
        // User us = new User();
        // HttpSession session = request.getSession();
        // switch (action)
        // {
        // case "action":
        // {
        // us = (User) session.getAttribute("user");
        // act = new Autorizate();
        // break;
        // }
        // case "registration":
        // {
        // us = (User) session.getAttribute("user");
        // act = new Autorizate();
        // break;
        // }
        // case "output":
        // {
        // us = (User) session.getAttribute("user");
        // act = new OutputAllBook();
        // break;
        // }
        // case "search":
        // {
        // us = (User) session.getAttribute("user");
        // act = new SearchBookImpl();
        // break;
        // }
        // case "add":
        // {
        // us = (User) session.getAttribute("user");
        // System.out.println("session us" + us.getRole());
        // if (us.getRole().equals("admin"))
        // {
        // act = new AddBookImpl();
        // }
        // break;
        // }
        // case "ToEdit":
        // {
        // us = (User) session.getAttribute("user");
        // System.out.println(us.getRole() + " log");
        // if (us.getRole().equals("admin"))
        // {
        // act = new ToEditBookPage();
        // }
        // break;
        // }
        // case "edit":
        // {
        // us = (User) session.getAttribute("user");
        // if (us.getRole().equals("admin"))
        // {
        // act = new EditBookPage();
        // }
        // break;
        // }
        // case "delete":
        // {
        // us = (User) session.getAttribute("user");
        // if (us.getRole().equals("admin"))
        // {
        // act = new DeleteBook();
        // }
        // break;
        // }
        // case "upload":
        // {
        // us = (User) session.getAttribute("user");
        // if (us.getRole().equals("admin"))
        // {
        // act = new UploadFileToServ();
        // }
        // break;
        // }
        // case "onForm":
        // {
        // us = (User) session.getAttribute("user");
        // if (us.getRole().equals("admin"))
        // {
        // act = new onFormPage();
        // }
        // break;
        // }
        // default:
        // System.out.println("Error");
        // }
    }
}
