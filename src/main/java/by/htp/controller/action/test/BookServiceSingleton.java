package by.htp.controller.action.test;

import by.htp.servis.BookService;

public class BookServiceSingleton {
	private static BookService INSTANCE = null;
	
	public static synchronized BookService getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new BookService();
		}
		return INSTANCE;
	}
}
