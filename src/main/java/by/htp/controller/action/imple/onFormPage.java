package by.htp.controller.action.imple;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.controller.action.BaseAction;

public class onFormPage implements BaseAction {

	@Override
	public String todoAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("author_value1", "lulu");
		System.out.println("onForm");

		return PAGE_ADMIN;
	}

}
