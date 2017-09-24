package com.abc.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.book.bean.AuthorBean;
import com.abc.book.util.DBUtil;

public class AuthorDAO 
{
	AuthorBean getAuthor(int authorCode)
	{
		Connection con=null;
		con=DBUtil.getDBConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		AuthorBean a1=new AuthorBean();
		try 
		{
			ps=con.prepareStatement("select * from AUTHOR_TBL where AUTHOR_CODE=?");
			ps.setInt(1,authorCode);
			rs=ps.executeQuery();
			while(rs.next())
			{
				a1.setAuthorCode(rs.getInt("AUTHOR_CODE"));
				a1.setAuthorName(rs.getString("AUTHOR_NAME"));
				a1.setContactno(rs.getLong("CONTACT_NO"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return a1;
		
	}
	
	public AuthorBean getAuthor(String authorName)
	{
		Connection con=null;
		con=DBUtil.getDBConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		AuthorBean a1=new AuthorBean();
		try 
		{
			ps=con.prepareStatement("select * from AUTHOR_TBL where AUTHOR_NAME=?");
			ps.setString(1,authorName);
			rs=ps.executeQuery();
			while(rs.next())
			{
				a1.setAuthorCode(rs.getInt("AUTHOR_CODE"));
				a1.setAuthorName(rs.getString("AUTHOR_NAME"));
				a1.setContactno(rs.getLong("CONTACT_NO"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return a1;
	}
}
