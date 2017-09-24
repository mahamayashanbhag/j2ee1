package com.abc.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.book.bean.AuthorBean;
import com.abc.book.bean.BookBean;
import com.abc.book.util.DBUtil;

public class BookDAO extends AuthorDAO
{
	public BookBean fetchBook(String isbn)
	{
		Connection con=null;
		con=DBUtil.getDBConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		BookBean b1=new BookBean();
		AuthorBean a2=new AuthorBean();
		try 
		{
			ps=con.prepareStatement("select * from BOOK_TBL where ISBN=?");
			ps.setString(1,isbn);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b1.setIsbn(rs.getString("ISBN"));
				b1.setBookName(rs.getString("BOOK_TITLE"));
				b1.setBookType(rs.getString("BOOK_TYPE"));
				int acode=rs.getInt("AUTHOR_CODE");
				a2=getAuthor(acode);
				b1.setAuthor(a2);
				b1.setCost(rs.getFloat("BOOK_COST"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b1;
		
	}
}
