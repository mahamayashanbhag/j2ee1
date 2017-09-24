package com.abc.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.book.bean.AuthorBean;
import com.abc.book.bean.BookBean;
import com.abc.book.dao.AuthorDAO;
import com.abc.book.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String operation=request.getParameter("operation");
		String j = null;
		if(operation.equals("AddBook"))
		j=addBook(request);
		PrintWriter out=response.getWriter();
		
		if(j.equals("SUCCESS"))
		{
				out.println("<h2>Book successfully added</h2>");
		}
		else
		{
			out.println("<h2>Error !!!!!!!</h2>");
			out.println(j);
		}
		out.close();
		if(operation.equals("viewBook"))
		viewBook(request.getParameter("isbn"));
	}
	public String addBook(HttpServletRequest request)
	{
	BookBean bk=new BookBean();
	AuthorBean at=new AuthorBean();
	AuthorDAO atdao=new AuthorDAO();
	bk.setIsbn(request.getParameter("isbnnumber"));
	bk.setBookName(request.getParameter("bookname"));
	bk.setBookType(request.getParameter("type").charAt(0));
	at=atdao.getAuthor(request.getParameter("author"));
	bk.setAuthor(at);
	bk.setCost(Float.parseFloat(request.getParameter("bookcost")));
	Administrator ad=new Administrator();
	String result=ad.addBook(bk);
	return result;
	}
	public BookBean viewBook(String isbn)
	{
		Administrator ad=new Administrator();
		BookBean bk=new BookBean();
		bk=ad.viewBook(isbn);
		return bk;
	}
}