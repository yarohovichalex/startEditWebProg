package by.htp.controller.action.imple;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.htp.controller.action.BaseAction;

public class UploadFileToServ implements BaseAction{

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 	String description = request.getParameter("description"); 
		    Part filePart = request.getPart("file"); 
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
		    InputStream fileContent = filePart.getInputStream();
		    
		    //TODO
		    
		    
		    
		return null;
	}
	
}
