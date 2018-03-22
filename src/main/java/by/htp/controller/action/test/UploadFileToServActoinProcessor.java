package by.htp.controller.action.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.htp.servis.BookService;

public class UploadFileToServActoinProcessor implements IActionProcessor
{
    private static final String ACTION = "edit";
    private static final String METHOD = "POST";

    private final BookService bookService = BookServiceSingleton.getInstance();
    
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        
        return false;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        String description = request.getParameter("description"); 
        Part filePart;
        try
        {
            filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
            InputStream fileContent = filePart.getInputStream();
        }
        catch (IOException | ServletException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        
        
        
    return null;
    }

}
