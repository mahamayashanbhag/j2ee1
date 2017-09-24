package com;
import java.sql.*;
import com.util.DButil;
public class CallableDemo {

	public static void main(String[] args)
	{
		Connection con=null;
		CallableStatement cs=null;
		try
		{
			con=DButil.getConn();
			cs=con.prepareCall("{call GET_SAL(?,?,?)}");
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.DOUBLE);
			
			cs.setInt(1, 1004);
			boolean res=cs.execute();
			
			
				System.out.println(cs.getString(2)+" "+cs.getDouble(3));
			
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			DButil.closeconn(con);
		}
	}

}
