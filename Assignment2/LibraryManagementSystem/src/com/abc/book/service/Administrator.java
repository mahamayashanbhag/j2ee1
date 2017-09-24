package com.abc.book.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.book.bean.BookBean;
import com.abc.book.dao.BookDAO;
import com.abc.book.util.DBUtil;

public class Administrator 
{
	public String addBook(BookBean bookBean)
	{
		String Invalid="FAILURE";
		if(bookBean==null)		return Invalid;
		
		String name=bookBean.getBookName();
		if(name.equals(null))	return Invalid;

		String isbn=bookBean.getIsbn();
		if(isbn.equals(null))	return Invalid;
		
		String type=String.valueOf(bookBean.getBookType());
		if(!(type.equals("G") && type.equals("T")))	return Invalid;
		
		float cost=bookBean.getCost();
		if(cost==0)		return Invalid;
		
		String aname=bookBean.getAuthorName();
		if(aname.equals(" ")) return Invalid;	
		
		int res=0;
		String s="SUCCESS";
		Connection con=null;
		con=DBUtil.getDBConnection();
		PreparedStatement ps=null;
		try 
		{
			ps=con.prepareStatement("insert into BOOK_TBL values(?,?,?,?,?)");
			ps.setString(1, bookBean.getIsbn());
			ps.setString(2, bookBean.getBookName());
			
			ps.setString(3, String.valueOf(bookBean.getBookType()));
			
			ps.setInt(4, bookBean.getAuthorCode());
			ps.setFloat(5, bookBean.getCost());
			res=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(res>0)		return s;
		else			return Invalid;
	}
	
	public BookBean viewBook(String isbn)
	{
		BookDAO b3=new BookDAO();
		BookBean b4=b3.fetchBook(isbn);
		return b4;
	}
		
}

