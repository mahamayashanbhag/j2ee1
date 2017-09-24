package com.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {

	public static void main(String[] args) {
		Connection con=null;
		try
		{
			con=DButil.getConn();
			String sql="update tb1 set salary=80000 where empno=1004";
			Statement st=con.createStatement();
			int result=st.executeUpdate(sql);
			
			System.out.println("Rows updated:" +result);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.closeconn(con);
		}
	}

}
