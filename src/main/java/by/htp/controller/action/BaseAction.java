package by.htp.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseAction {
	/**
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}

	