package by.htp.servis;

import java.util.ArrayList;
import java.util.List;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.dao.BaseDao;
import by.htp.dao.impl.AddBookDaoImpl;
import by.htp.dao.impl.DeleteBookDaoImpl;
import by.htp.dao.impl.EditBookDaoImpl;
import by.htp.dao.impl.OutputBookDaoImpl;
import by.htp.dao.impl.SearchBookDaoImpl;
import by.htp.dao.impl.UserAuthenticationImpl;

public class BookService {
	private List<Book> list = new ArrayList<>();
		
	public BookService() {
			super();		
	}
	
	private BaseDao dao;
	private User us;
	
	public void delete(int id) {
	dao = new DeleteBookDaoImpl();
	System.out.println(id + "delete");
	dao.delete(id);
	}
	
	public void criate(Book book) {
		dao = new AddBookDaoImpl();
		dao.criate(book);
		System.out.println(book.getTittle() + " TITLE!!!");
	}
	
	public User searchUser(String login, String password) {
		dao = new UserAuthenticationImpl();
		us = dao.searchUser(login, password);
		return us;
	}
	
	public void editBook(int id, Book book) {
		dao = new EditBookDaoImpl();
		dao.editBook(id, book);
	}
	
	public List<Book> outputBook() {
		dao = new OutputBookDaoImpl();
		list.clear();
		list = dao.outputBook();
		return list;
	}
	public List<Book> bookComents(int id) {
		dao = new OutputBookDaoImpl();
		list.clear();
		list = dao.outputBook();
		return list;
	}
	
	public List<Book> searchBookDao(String bookName) {
		dao = new SearchBookDaoImpl();
		list.clear();
		list = dao.searchBookDao(bookName);
		return list;
	}
	
}
