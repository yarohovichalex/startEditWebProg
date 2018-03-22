package by.htp.controller.action.test;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_EDIT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToEditBookPageActionProcessor implements IActionProcessor
{
    private static final String ACTION = "ToEdit";
    private static final String METHOD = "POST";

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        
        
//        request.setAttribute("user_name", us.getLogin());       
        int id = Integer.parseInt(request.getParameter("BookIdIntoEditPage"));
        String bookName = request.getParameter("BookNameIntoEditPage");     
        String authorName = request.getParameter("AuthorNameIntoEditPage");
        String printDate = request.getParameter("PrintDateIntoEditPage");

        HttpSession session = request.getSession();
        session.setAttribute("BookNameIntoEditPage", bookName);
        session.setAttribute("AuthorNameIntoEditPage", authorName);
        session.setAttribute("BookIdIntoEditPage", id);
        session.setAttribute("PrintDateIntoEditPage", printDate);
        
//        SimpleDateFormat format = new SimpleDateFormat();
//        format.applyPattern("yyyy-MM-dd");
//        Date date = null;
//        try
//        {
//            date = format.parse(printDate);
//        }
//        catch (ParseException e)
//        {
//            e.printStackTrace();
//        }

        return PAGE_EDIT;
    }
}
